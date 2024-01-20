package leetcode_202401;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225.用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * ---------------------------------------------------------------------------------------
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 */
public class Leetcode_225 {
    static class MyStack{
        private final Queue<Integer> queue1;
        private final Queue<Integer> queue2;
        private int topElement;

        public MyStack(){
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        // 入栈即入队到一个非空队列，并记录栈顶值
        public void push(int x) {
            if (!queue1.isEmpty()){
                queue1.offer(x);
            }else {
                queue2.offer(x);
            }
            topElement = x;
        }


        public int pop() {
            // 将元素从非空队列依次出队并入队到另一个队列，直到最后一个元素
            Queue<Integer> fromQueue = queue1.isEmpty() ? queue2 : queue1;
            Queue<Integer> toQueue = queue1.isEmpty() ? queue1 : queue2;

            while (fromQueue.size() > 1) {
                topElement = fromQueue.poll();
                toQueue.offer(topElement);
            }

            // 获取并移除栈顶元素
            return fromQueue.poll();
        }

        public int top() {
            return topElement;
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // Output: 2
        System.out.println(stack.pop());   // Output: 2
        System.out.println(stack.empty()); // Output: false
    }
}
