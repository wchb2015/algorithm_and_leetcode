package course1.chapter14;

import com.wchb.course1.chapter14.HashTable;
import com.wchb.course1.chapter7.FileOperation;
import com.wchb.course1.chapter7.LinkedListMap;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date 7/8/18 5:39 PM
 */
public class HashTableTest {
    @Test
    public void test01() {
        System.out.println("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total  words: " + words.size());
            HashTable<String, Integer> map = new HashTable<>();
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
