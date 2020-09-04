package 栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Auther: dyh
 * Date: 2020/8/30 21:42
 * Description:实现一个MyQueue类，该类用两个栈来实现一个队列。
 */
public class 化栈为队 {

    class MyQueue {
        Deque<Integer> stack1;
        Deque<Integer> stack2;;
        /** Initialize your data structure here. */
        public MyQueue() {
            stack1=new LinkedList<>();
            stack2=new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack2.isEmpty()&&stack1.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
