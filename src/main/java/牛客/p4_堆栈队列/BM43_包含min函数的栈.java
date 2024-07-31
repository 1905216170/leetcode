package 牛客.p4_堆栈队列;

import java.util.Iterator;
import java.util.Stack;

public class BM43_包含min函数的栈 {

    Stack<Integer> stack = new Stack();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        Iterator<Integer> iterator = stack.iterator();
        Integer min = null;
        while (iterator.hasNext()){
            Integer val = iterator.next();
            if(min == null || val < min){
                min = val;
            }
        }
        return min;
    }
}
