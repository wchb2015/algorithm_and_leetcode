package leetcode;

import com.wchb.course3.chapter5.ListNode;
import com.wchb.leetcode.*;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeTest {

    private static final Logger logger = LoggerFactory.getLogger(LeetCodeTest.class);


    @Test
    public void test299() {
    }

    @Test
    public void test272() {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);

        System.out.println(Integer.MAX_VALUE);
        //2147483647
        //2147483647
        System.out.println(new S272().closestKValues(node, 2147483647.0, 1));
        System.out.println(2.147483646E9 > 2.147483645E9);
        System.out.println(new Float(2.147483646E9).compareTo(new Float(2.147483645E9)));
    }

    @Test
    public void test331() {
        System.out.println(new S331().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new S331().isValidSerialization("1,#"));
        System.out.println(new S331().isValidSerialization("9,#,#,1"));
        System.out.println(new S331().isValidSerialization(""));
    }

    @Test
    public void test271V2() {
        List<String> list = new LinkedList<>();

        list.add("#");
        list.add("#");


        String s = new S271().encode(list);
        List<String> list2 = new S271().decode(s);

        System.out.println(list + " ---- " + list2);
    }


    @Test
    public void test271() {
        List<String> list = new LinkedList<>();

        list.add("63/Rc");
        list.add("h");
        list.add("BmI3FS~J9#vmk");
        list.add("7uBZ?7*/");
        list.add("24h+X");
        list.add("O ");

        String s = new S271().encode(list);
        List<String> list2 = new S271().decode(s);

        System.out.println(list + " ---- " + list2);
    }

    @Test
    public void test78() {
        new S78().subsets(new int[]{1, 2});
    }

    @Test
    public void test186() {
        new S186().reverseWords(new char[]{'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'});

    }

    @Test
    public void test151() {
        System.out.println(new S151().reverseWords("the sky is blue"));
    }

    @Test
    public void test146() {
        LRUCache146 cache = new LRUCache146(5);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        System.out.println(cache);

        cache.get(4);

        cache.put(6, 6);

        System.out.println(cache);

    }

    @Test
    public void test200() {
        new S200V2().numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        });
    }

    @Test
    public void test414() {
        new S414().thirdMaxV2(new int[]{1, 2, 2, 5, 3, 5});
    }


    @Test
    public void test143() {
        S143 s143 = new S143();


        com.wchb.leetcode.S143.ListNode listNode = s143.builder(new int[]{1, 2, 3, 4, 5});

        s143.reorderList(listNode);
    }

    @Test
    public void test690() {
        new S690().justRun();
    }

    @Test
    public void test26() {
        new S26().removeDuplicatesV2(new int[]{1, 2, 3, 3, 4, 4, 4});
    }

    @Test
    public void test128() {
        System.out.println(new S128().longestConsecutiveV2(new int[]{1, 2, 0, 1}));
    }

    @Test
    public void test392() {
        new S392().isSubsequence("abc", "ahbgdc");
    }

    @Test
    public void test455() {
        new S455().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
    }

    @Test
    public void test70() {
        System.out.println(new S70().climbStairsV1(3));
        System.out.println(new S70().climbStairsV3(1));
    }

    @Test
    public void test46() {
        new S46().permute(new int[]{1, 2, 3});
    }

    @Test
    public void test17() {
//        new S17().letterCombinations("23");
        new S17V2().letterCombinations("234");
        new S17V3().letterCombinations("234");
    }

    @Test
    public void test279() {
        new S279().numSquares(4);
    }

    @Test
    public void test92() {
        int m = 2, n = 4;
        int[] arr = new int[]{1, 2, 3, 4, 5};

        ListNode head = new ListNode(arr);

        System.out.println(ListNode.printList(head));

        new S92().reverseBetween(head, m, n);

        System.out.println(ListNode.printList(head));
    }

    @Test
    public void test65() {
        System.out.println(new S65().isNumber("0"));
        System.out.println(new S65().isNumber("0.1"));
        System.out.println(new S65().isNumber("abc"));
        System.out.println(new S65().isNumber("1 a"));
        System.out.println(new S65().isNumber("2e10"));
        System.out.println(new S65().isNumber(".1"));
        System.out.println(new S65().isNumber("."));
        System.out.println(new S65().isNumber("3."));
        System.out.println(new S65().isNumber("2e0"));//true
        System.out.println(new S65().isNumber(".1."));//false
    }

    @Test
    public void testS447() {
        new S447().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
    }

    @Test
    public void test242() {
        System.out.println(new S242().isAnagram("anagram", "nagaram"));
    }

    @Test
    public void test345() {
        System.out.println(new S345().reverseVowels("hello"));
        System.out.println(new S345().reverseVowels("leetcode"));
        System.out.println(new S345().reverseVowels("aA"));
    }

    @Test
    public void test125() {
        System.out.println(new S125().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("---------");
        System.out.println(new S125().isPalindrome("race a car"));
        System.out.println("---------");
        System.out.println(new S125().isPalindrome(".,"));
        System.out.println("---------");
        System.out.println(new S125().isPalindrome("0P"));
    }

    @Test
    public void test215() {
        new S215().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    @Test
    public void test3() {
        new S3().lengthOfLongestSubstring("abcabcbb");
    }

    @Test
    public void test209() {
        System.out.println(new S209().minSubArrayLenV4(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    public void test283() {
        new S283().moveZeroesV1(new int[]{0, 1, 0, 3, 12});
    }

    @Test
    public void test323() {
        new S323().countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}});
    }

    @Test
    public void test137() {
        System.out.println(new S137().singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(new S137().singleNumber(new int[]{43, 16, 45, 89, 45,
                -2147483648, 45, 2147483646, -2147483647, -2147483648,
                43, 2147483647, -2147483646, -2147483648, 89, -2147483646, 89,
                -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43}));
    }

    @Test
    public void test75() {
        new S75().sortColorsV1(new int[]{2, 0, 2, 1, 1, 0});
        new S75().sortColorsV2(new int[]{2, 0, 2, 1, 1, 0, 0, 0, 0});
    }

    @Test
    public void test88() {
//        new S88().merge(new int[]{1, 2, 3, 0, 0, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        new S88().merge(new int[]{1}, 1, new int[]{0}, 0);
        new S88().merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    @Test
    public void test547() {
        new S547().findCircleNumV3(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println(
                //  new S547V2().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})
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
        System.out.println(new S136().singleNumber3(new int[]{}));
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
    public void test1() {
        S1 solution1 = new S1();

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

        Solution347 s1 = new Solution347();
        Solution347V2 s2 = new Solution347V2();

        System.out.println(s1.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
        System.out.println(s2.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2));
    }


    @Test
    public void test692() {
        S692 s1 = new S692();


        List<String> strings = s1.topKFrequentV2(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "friday"},
                4);

        System.out.println(strings);
    }

}

