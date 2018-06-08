package course1.chapter10;

import com.wchb.course1.chapter10.Trie;
import com.wchb.course1.chapter7.BSTSet;
import com.wchb.course1.chapter7.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date 6/6/18 2:55 PM
 */
public class TrieTest {

    Trie trie = new Trie();


    @Test
    public void test() {
        trie.add("good");
        System.out.println(trie.contains("good"));
        System.out.println(trie.isPrefix("ga"));
    }

    @Test
    public void testCompareWithBST() {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {

            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for (String word : words)
                set.add(word);

            for (String word : words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }

            for (String word : words) {
                if (!trie.contains(word)) {
                    throw new RuntimeException();
                }
            }

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}