package leetcode;

import com.wchb.course3.chapter5.ListNode;
import com.wchb.leetcode.*;
import com.wchb.model.Point;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeTest {

    private static final Logger logger = LoggerFactory.getLogger(LeetCodeTest.class);

    @Test
    public void test238() {
        new S238().productExceptSelf(new int[]{1, 2, 3, 4});
    }

    @Test
    public void test739() {
        new S739().dailyTemperaturesV2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    @Test
    public void test516() {
        new S516().longestPalindromeSubseq("abcde");
    }

    @Test
    public void test149() {

        Point[] arr = new Point[3];
        arr[0] = new Point(1, 1);
        arr[1] = new Point(2, 2);
        arr[2] = new Point(3, 3);

        //new S149().maxPoints(arr);

        Point[] arr2 = new Point[6];
        arr2[0] = new Point(1, 1);
        arr2[1] = new Point(3, 2);
        arr2[2] = new Point(5, 3);
        arr2[3] = new Point(4, 1);
        arr2[4] = new Point(2, 3);
        arr2[5] = new Point(1, 4);

        Point[] arr3 = new Point[1];
        arr3[0] = new Point(0, 0);

        Point[] arr4 = new Point[2];
        arr4[0] = new Point(0, 0);
        arr4[1] = new Point(0, 0);

        Point[] arr5 = new Point[15];
        arr5[0] = new Point(0, -12);
        arr5[1] = new Point(5, 2);
        arr5[2] = new Point(2, 5);
        arr5[3] = new Point(0, -5);
        arr5[4] = new Point(1, 5);
        arr5[5] = new Point(2, -2);
        arr5[6] = new Point(5, -4);
        arr5[7] = new Point(3, 4);
        arr5[8] = new Point(-2, 4);
        arr5[9] = new Point(-1, 4);
        arr5[10] = new Point(0, -5);
        arr5[11] = new Point(0, -8);
        arr5[12] = new Point(-2, -1);
        arr5[13] = new Point(0, -11);
        arr5[14] = new Point(0, -9);

        new S149().maxPoints(arr5);
    }

    @Test
    public void test77() {
        new S77().combine(3, 2);
    }

    @Test
    public void test127() {
        new S127().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    @Test
    public void test76() {
        new S76().minWindowV2("ADOBECODEBANC", "ABC");
    }

    @Test
    public void test503() {
        new S503().nextGreaterElements(new int[]{1, 5, 3, 6, 8});
        new S503().nextGreaterElements(new int[]{1, 2, 1});
    }

    @Test
    public void test245() {
        new S245().shortestWordDistance(new String[]{"a", "a", "c", "b"}, "a", "b");
    }


    @Test
    public void test18() {
        new S18().fourSum(new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7);
    }

    @Test
    public void test16() {
        new S16().threeSumClosestV2(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 5, 6, 6, 2, 3, 4, 5, 6, 7, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 100);
    }

    @Test
    public void test15() {
        new S15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        new S15().threeSum(new int[]{0, 0, 0});
    }


    @Test
    public void test22() {
        System.out.println(new S22().generateParenthesis(3));
    }

    @Test
    public void test73() {
        new S73().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }

    @Test
    public void test161() {
        System.out.println(new S161().isOneEditDistance("ab", "acd"));
        System.out.println(new S161().isOneEditDistance("ab", "acb"));
        System.out.println(new S161().isOneEditDistance("a", "ac"));
        System.out.println(new S161().isOneEditDistance("a", ""));
    }

    @Test
    public void test132() {
        System.out.println(new S132().minCut("aab"));
    }

    @Test
    public void test541() {
        System.out.println(new S541().reverseStr("abcdefg", 2));
        System.out.println(new S541().reverseStr("abcdefg", 39));
    }

    @Test
    public void test8() {
        System.out.println(new S8().myAtoi("2147483648"));
        System.out.println(new S8().myAtoi("+-2"));
        System.out.println(new S8().myAtoi("42"));
        System.out.println(new S8().myAtoi("   -42"));
        System.out.println(new S8().myAtoi("-91283472332"));
        System.out.println(new S8().myAtoi("9223372036854775808"));
    }

    @Test
    public void test535() {
        System.out.println(new S535().encode("http:www.baidu.com"));
        System.out.println(new S535().decode(new S535().encode("http:www.baidu.com")));

    }

    @Test
    public void test322() {
        //System.out.println(new S322().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new S322().coinChange(new int[]{1, 2, 5}, 11));

    }

    @Test
    public void test718() {
        new S718().findLength(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0});
        //new S718().findLength(new int[]{1, 2, 3, 4, 5}, new int[]{11, 22, 33, 44, 55});
    }

    @Test
    public void test118() {
        new S118().generate(5);
    }


    @Test
    public void test678() {
        System.out.println(new S678().checkValidStringV2("(*)"));//true
        System.out.println(new S678().checkValidStringV2("(**)"));//true
        System.out.println(new S678().checkValidStringV2("(((******))"));//true
        System.out.println(new S678().checkValidStringV2("(())((())()()(*)(*()(())())())()()((()())((()))(*"));//false
    }

    @Test
    public void test300() {
        System.out.println(new S300().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        System.out.println(new S300().lengthOfLIS(new int[]{-2, -1}));
    }

    @Test
    public void test416() {
        new S416().canPartitionV2(new int[]{2, 2, 3, 5});
    }

    @Test
    public void test91() {
        new S91().numDecodings("12");
        new S91().numDecodings3("12");
    }

    @Test
    public void test401() {
        new S401().readBinaryWatch(3);
    }

    @Test
    public void test216() {
        new S216().combinationSum3(2, 6);
    }

    @Test
    public void test39() {
        new S39().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    @Test
    public void test47() {
        System.out.println(new S47().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new S47().permuteUniqueV2(new int[]{1, 1, 2}));
    }

    @Test
    public void test131() {
        System.out.println(new S131().partition("aab"));
    }

    @Test
    public void test93() {
        System.out.println(new S93().restoreIpAddresses("0123"));
    }

    @Test
    public void test685() {
        System.out.println(Arrays.toString(new S685().//4,1
                findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));

        System.out.println("-------");

        System.out.println(Arrays.toString(new S685().//2,3
                findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }

    @Test
    public void test684UF() {
        System.out.println(Arrays.toString(new S684UnionFind().
                findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));

        System.out.println("-------");

        System.out.println(Arrays.toString(new S684UnionFind().
                findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));

        System.out.println("-------");

        System.out.println(Arrays.toString(new S684UnionFind().
                findRedundantConnection(new int[][]{{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}})));
    }

    @Test
    public void test684() {
        System.out.println(Arrays.toString(new S684().
                findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}})));

        System.out.println("-------");

        System.out.println(Arrays.toString(new S684().
                findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));

        System.out.println("-------");

        System.out.println(Arrays.toString(new S684().
                findRedundantConnection(new int[][]{{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}})));

    }

    @Test
    public void test448() {
        new S448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }


    @Test
    public void test261DFS() {
        System.out.println(new S261DFS().validTree(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}));//true
        System.out.println(new S261DFS().validTree(4, new int[][]{{0, 1}, {2, 3}}));//false
        System.out.println(new S261DFS().validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));//false
    }

    @Test
    public void test261() {
        System.out.println(new S261().validTree(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}));//true

        System.out.println(new S261().validTree(4, new int[][]{{0, 1}, {2, 3}}));//false

        System.out.println(new S261().validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));//false

    }

    @Test
    public void test207() {
        int v1 = 3;
        int[][] data1 = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        System.out.println(new S207().canFinish(v1, data1));
        System.out.println("----------");

        int v2 = 4;
        int[][] data2 = new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}};
        System.out.println(new S207().canFinish(v2, data2));

        int v3 = 4;
        int[][] data3 = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        new S207().canFinish(v3, data3);
    }


    @Test
    public void test716() {
        MaxStack maxStack = new MaxStack();

        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);

        maxStack.top();
        maxStack.popMax();
        maxStack.top();
        maxStack.peekMax();
        maxStack.pop();
        maxStack.top();
    }


    @Test
    public void test48() {
        new S48().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    @Test
    public void test819() {
        new S819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit."
                , new String[]{"hit"});
    }

    @Test
    public void test307() {

        int[] nums = new int[]{1, 2, 3, 4, 5};

        S307 obj = new S307(nums);
        int param_1 = obj.sumRange(0, 2);

        System.out.println(param_1);
    }


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
        new S78().subsets(new int[]{1, 2, 3});
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
        LRUCacheV2146 cache = new LRUCacheV2146(2);


        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));   // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

    }

    @Test
    public void test200() {
        new S200().numIslands(new char[][]{{'1', '1', '0', '0', '0'},
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
    }

    @Test
    public void test46() {
        System.out.println(new S46().permute(new int[]{1, 2, 3}));
    }

    @Test
    public void test17() {
        System.out.println(new S17DFS().letterCombinations("23"));
        System.out.println(new S17BFS().letterCombinations("23"));
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
        System.out.println(new S323().countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));

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

