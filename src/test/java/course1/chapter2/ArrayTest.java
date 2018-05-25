package course1.chapter2;

import com.wchb.course1.chapter2.Array;
import com.wchb.model.Student;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayTest {
    private static final Logger logger = LoggerFactory.getLogger(ArrayTest.class);


    @Test
    public void test01() {
        Array<Integer> array = new Array<>(10);


        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        logger.info("array:{}", array);


        array.add(3333, 2);
        logger.info("array:{}", array);


        array.addFirst(11);


        logger.info("array:{}", array);


        logger.info("remove:{}", array.remove(0));

        array.removeFirst();
        array.removeLast();
        logger.info("array:{}", array);

        array.removeElement(3333);
        logger.info("array:{}", array);

    }

    @Test
    public void test02() {
        Array<Student> array = new Array<>(4);
        array.addLast(new Student("xiaohua1", 101));
        array.addLast(new Student("xiaohua2", 102));
        array.addLast(new Student("xiaohua3", 103));
        array.addLast(new Student("xiaohua4", 104));


        logger.info("array:{}", array);

        logger.info("remove:{}", array.remove(1));
        array.removeFirst();
        array.removeLast();
        logger.info("array:{}", array);

    }

    @Test
    public void test03() {
        System.out.println(sum(new int[]{1, 2, 3}, 0));
    }


    // 计算 arr[l....n)这个区间内所有数字的和
    public int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}
