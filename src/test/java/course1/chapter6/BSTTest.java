package course1.chapter6;

import com.wchb.course1.chapter6.BST;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class BSTTest {

    BST<Integer> bst;

    @Before
    public void init() {
        bst = new BST<>();

        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int num : nums) {
            bst.add(num);
        }
    }

    @Test
    public void testPreOrder() {
        bst.preOrder();
        System.out.println("===============");
        bst.preOrderNR();

        System.out.println("===============");
        System.out.println(bst);
    }

    @Test
    public void testInOrder() {
        bst.inOrder();
    }

    @Test
    public void testPostOrder() {
        bst.postOrder();
    }

    @Test
    public void testLevelOrder() {
        bst.levelOrder();
    }

    @Test
    public void testMinMax() {
        System.out.println(bst.minimum());
        System.out.println(bst.maximum());
    }

    @Test
    public void remove() {
        System.out.println(bst.size());
        System.out.println(bst.removeMin());
        System.out.println(bst.removeMax());
        System.out.println(bst.size());
    }

    @Test
    public void testRemove() {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        // test removeMin
        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(10000));

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) > nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMin test completed.");


        // test removeMax
        for (int i = 0; i < n; i++)
            bst.add(random.nextInt(10000));

        nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMax());

        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++)
            if (nums.get(i - 1) < nums.get(i))
                throw new IllegalArgumentException("Error!");
        System.out.println("removeMax test completed.");
    }
}
