package course1.chapter4;

import com.wchb.course1.chapter3.*;
import com.wchb.course1.chapter4.LinkedList;
import com.wchb.course1.chapter4.LinkedListQueue;
import com.wchb.course1.chapter4.LinkedListStack;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ListTest {
    private static final Logger logger = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void test01() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(5);
        list.add(2, 666);
        logger.info("List:{}", list);

        list.remove(2);
        list.removeFirst();
        list.removeLast();

        list.set(1, 2222);

        logger.info("List:{}", list);
    }

    @Test
    public void test03() {

        LinkedListStack<Integer> as = new LinkedListStack<>();

        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(5);

        logger.info(" as :{}", as);
        logger.info(" as peek:{}", as.peek());
        as.pop();
        logger.info(" as :{}", as);

    }


    @Test
    public void test06() {

        LinkedListQueue<Integer> lq = new LinkedListQueue<>();

        for (int i = 1; i < 11; i++) {
            lq.enqueue(i);
            logger.info(" lq:{} ", lq);

        }

        while (!lq.isEmpty()) {
            lq.dequeue();
        }

        logger.info(" lq:{} ", lq);

        lq.enqueue(11);
        lq.enqueue(12);
        lq.enqueue(13);
        logger.info(" lq:{} ", lq);
    }

    @Test
    public void compareArrayStackAndLinkedStack() {
        int opCount = 1000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        // 其实这个时间比较很复杂，因为LinkedListStack中包含更多的new操作
    }

    @Test
    public void compareQueue() {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }

    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(IStack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueue(IQueue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

}
