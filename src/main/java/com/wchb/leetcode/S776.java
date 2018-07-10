package com.wchb.leetcode;

/**
 * @date 7/9/18 6:23 PM
 */
public class S776 {


    public TreeNode[] splitBST(TreeNode root, int V) {

        TreeNode[] ret = new TreeNode[2];

        if (root == null) {
            return ret;
        }

        if (root.val == V) {
            //如果V 等于root.val
            //0 为 root去掉右子树
            //1 为 root.右子树.

            TreeNode ret1 = root.right;
            root.right = null;
            ret[0] = root;
            ret[1] = ret1;
        } else if (root.val < V) {
            // V 在右边
            // 0 为 V + root
            // 1 为 root.right 去掉V.
            TreeNode ret0 = new TreeNode(V);
            TreeNode left = root.left;
            root.left = null;
            ret0.right = root;

            TreeNode ret1 = remove(left, V);

            ret[0] = ret0;
            ret[1] = ret1;
        } else {
            // V 在左边
            // 0 为 V 去掉 v.right
            // 1 为 V.right接在vParent.left之后的root.

            TreeNode floor = findFloor(root, V);
            if (floor == null) {
                ret[0] = null;
                ret[1] = root;
                return ret;
            }


            V = floor.val;
            TreeNode vParent = findParent(root, V);
            TreeNode v = find(root, V);
            TreeNode vRight = v.right;

            v.right = null;
            vParent.left = vRight;

            ret[0] = v;
            ret[1] = root;
        }

        return ret;
    }

    private TreeNode remove(TreeNode root, int V) {
        if (root == null) {
            return null;
        }
        if (root.val > V) {
            root.left = remove(root.left, V);
            return root;
        }

        if (root.val < V) {
            root.right = remove(root.right, V);
            return root;
        }

        if (root.val == V) {
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }

            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }

            //待删除节点左右均不为空
            //找到比待删除节点大的最小节点,即待删除节点右子树的最小节点
            //用这个节点替代待删除节点的位置
            TreeNode successor = minimum(root.right);

            successor.right = removeMin(root.right);
            successor.left = root.left;

            root.left = null;
            root.right = null;
            return successor;
        }
        return null;
    }

    private TreeNode removeMin(TreeNode root) {
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
    }

    private TreeNode minimum(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.left == null) {
            return root;
        }

        return minimum(root.left);
    }

    private TreeNode findParent(TreeNode root, int V) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }

        if ((root.left != null && root.left.val == V) || (root.right != null && root.right.val == V)) {
            return root;
        }
        if (root.val > V) {
            return findParent(root.left, V);
        }
        if (root.val < V) {
            return findParent(root.right, V);
        }
        return null;
    }

    private TreeNode find(TreeNode root, int V) {
        if (root == null) {
            return null;
        }

        if (root.val == V) {
            return root;
        } else if (root.val > V) {
            return find(root.left, V);
        } else {
            return find(root.right, V);
        }

    }


    //寻找 比V小的最大的Node
    private TreeNode findFloor(TreeNode root, int V) {
        if (root == null) {
            return null;
        }
        if (root.val == V) {
            return root;
        } else if (root.val > V) {
            return findFloor(root.left, V);
        } else {
            TreeNode right = findFloor(root.right, V);
            if (right == null) {
                return root;
            } else {
                return right;
            }
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
