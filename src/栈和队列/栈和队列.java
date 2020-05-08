package 栈和队列;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.*;

/**
 * Auther: dyh
 * Date: 2020/4/12 20:39
 * Description:
 */
public class 栈和队列 {
    public static void main(String[] args) {
        /**
         * https://www.cnblogs.com/yuandluck/p/9476123.html
         */
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ConcurrentLinkedQueue<Object> objects1 = new ConcurrentLinkedQueue<>();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(13);
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue();
        DelayQueue delayQueue = new DelayQueue();
        System.out.println(16       >>>1);
    }
}
