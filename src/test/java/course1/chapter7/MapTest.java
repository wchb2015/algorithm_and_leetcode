package course1.chapter7;

import com.wchb.course1.chapter7.BSTMap;
import com.wchb.course1.chapter7.FileOperation;
import com.wchb.course1.chapter7.LinkedListMap;
import com.wchb.course1.chapter7.LinkedListSet;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date 5/29/18 5:45 PM
 */
public class MapTest {

    @Test
    public void testLinkedListMap() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total  words: " + words.size());
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total the: " + map.get("the"));
        }
    }


    @Test
    public void testBSTMap() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total  words: " + words.size());
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total the: " + map.get("the"));
        }
    }
}
