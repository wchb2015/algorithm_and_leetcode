package course1.chapter12;

import com.wchb.course1.chapter12.AVLTree;
import com.wchb.course1.chapter7.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date 6/7/18 10:58 PM
 */
public class AVLTreeTest {

    @Test
    public void test() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println(" isBST :" + map.isBST());
            System.out.println(" isBalanced :" + map.isBalanced());
        }
    }
}
