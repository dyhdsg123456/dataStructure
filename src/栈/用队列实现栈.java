package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Auther: dyh
 * Date: 2020/9/8 21:28
 * Description:
 */
public class 用队列实现栈 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        int top = myStack.top();
        int pop = myStack.pop();
        System.out.println(pop);
    }
  static   class  MyStack {
        private Queue<Integer> queue;
        /** Initialize your data structure here. */
        public MyStack() {
            queue=new LinkedList();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.offer(x);
            for(int i=queue.size()-1;i>0;i--){
                queue.offer(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
