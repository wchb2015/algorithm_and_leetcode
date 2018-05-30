package course1.chapter7;

import com.wchb.course1.chapter7.BSTSet;
import com.wchb.course1.chapter7.FileOperation;
import com.wchb.course1.chapter7.LinkedListSet;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date 5/29/18 4:38 PM
 */
public class SetTest {

    @Test
    public void testBstSet() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total  words: " + words.size());
            System.out.println("Total different words: " + set.getSize());
        }
    }

    @Test
    public void testLinkedListSet() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            LinkedListSet<String> set = new LinkedListSet<>();
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total  words: " + words.size());
            System.out.println("Total different words: " + set.getSize());
        }
    }
}


