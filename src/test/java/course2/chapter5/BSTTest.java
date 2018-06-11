package course2.chapter5;

import com.wchb.course1.chapter7.FileOperation;
import com.wchb.course2.chapter5.BST;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @date 6/10/18 10:10 PM
 */
public class BSTTest {


    @Test
    public void test() {

        // 使用圣经作为我们的测试用例
        String filename = "pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("There are totally " + words.size() + " words in " + filename);
            System.out.println();

            // 测试 BST
            long startTime = System.currentTimeMillis();

            // 统计圣经中所有词的词频
            // 注: 这个词频统计法相对简陋, 没有考虑很多文本处理中的特殊问题
            // 在这里只做性能测试用
            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                Integer res = bst.search(word);
                if (res == null)
                    bst.insert(word, new Integer(1));
                else
                    bst.insert(word, res + 1);
            }

            // 输出圣经中god一词出现的频率
            if (bst.contain("prejudice"))
                System.out.println("'prejudice' : " + bst.search("prejudice"));
            else
                System.out.println("No word 'prejudice' in " + filename);

            long endTime = System.currentTimeMillis();
            System.out.println("BST , time: " + (endTime - startTime) + "ms.");

            System.out.println();


        }
    }
}