package 牛客.p4_堆栈队列;


import java.util.Stack;

public class BM44_有效括号序列 {

    public boolean isValid (String s) {

        Stack<Character>stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(stack.isEmpty()){
                stack.push(c);
            }else {
                if(c == '[' || c == '{' || c == '('){
                    stack.push(c);
                } else if(c == ']'){
                    if(stack.peek() == '['){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else if(c == ')'){
                    if(stack.peek() == '('){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else if(c == '}'){
                    if(stack.peek() == '{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
