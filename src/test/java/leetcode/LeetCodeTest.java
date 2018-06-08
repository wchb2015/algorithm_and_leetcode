package leetcode;

import com.wchb.leetcode.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class LeetCodeTest {

    private static final Logger logger = LoggerFactory.getLogger(LeetCodeTest.class);

    @Test
    public void test() {
        Integer.parseInt(new StringBuilder().toString());
    }

    @Test
    public void test547() {
        System.out.println(
                new S547V2().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})
        );
        System.out.println(
//                new S547V2().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})
        );
    }

    @Test
    public void testMapSum677() {
        MapSum677 obj = new MapSum677();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }

    @Test
    public void test211() {
        WordDictionary211 wordDictionary = new WordDictionary211();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    @Test
    public void test208() {
        Trie208 obj = new Trie208();
        obj.insert("good");
        System.out.println(obj.search("good"));
        System.out.println(obj.startsWith("go"));
    }

    @Test
    public void test203() {
        new S203().justRun();
    }

    @Test
    public void test7() {
        System.out.println(new S7().reverse(-3211));
    }

    @Test
    public void test771() {
        System.out.println(new S771().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new S771().numJewelsInStones("z", "ZZ"));
    }

    @Test
    public void test234() {
        new S234().justRun();
    }

    @Test
    public void test9() {
        System.out.println(new S9().isPalindrome(1001));
    }

    @Test
    public void test136() {
        System.out.println(new S136().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    @Test
    public void test344() {
        System.out.println(new Solution344().reverseString("1990"));
    }

    @Test
    public void test13() {

        System.out.println(new Solution13().romanToInt("MCMXCIV"));

    }

    @Test
    public void test3() {

        System.out.println(new Solution3().lengthOfLongestSubstring("au"));
    }


    @Test
    public void test1() {
        Solution1 solution1 = new Solution1();

        System.out.println(Arrays.toString(
                solution1.twoSum(new int[]{1, 2, 3, 4, 5}, 3)));

    }

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

        System.out.println(solution347.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }

}

