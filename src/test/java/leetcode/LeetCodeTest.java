package leetcode;

import com.wchb.leetcode.Solution110;
import com.wchb.leetcode.Solution20;
import com.wchb.leetcode.Solution347V2;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeetCodeTest {

    private static final Logger logger = LoggerFactory.getLogger(LeetCodeTest.class);

    @Test
    public void test110() {

        //1,2,2,3,null,null,3,4,null,null,4

        Solution110 solution110 = new Solution110();

        Solution110.TreeNode root = solution110.new TreeNode(1);

        root.left = solution110.new TreeNode(2);
        root.right = solution110.new TreeNode(2);
//
//        root.left.left = solution110.new TreeNode(3);
//
//        root.left.left.left = solution110.new TreeNode(4);
//
//        root.left.left.left.left = solution110.new TreeNode(4);
//
//        root.right.right = solution110.new TreeNode(3);

        System.out.println(new Solution110().isBalanced(root));

    }

    @Test
    public void test20() {
        Solution20 solution20 = new Solution20();

        String s1 = "({[]})";
        String s2 = "(){}[]";
        String s3 = "(){}[]{";

        logger.info(" s1 , {}", solution20.isValid(s1));
        logger.info(" s2 , {}", solution20.isValid(s2));
        logger.info(" s3 , {}", solution20.isValid(s3));
    }

    @Test
    public void test347() {

        Solution347V2 solution347 = new Solution347V2();

        System.out.println(solution347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

}
