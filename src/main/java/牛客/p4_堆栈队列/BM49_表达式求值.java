package 牛客.p4_堆栈队列;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BM49_表达式求值 {


//    1+(2*(3-4))*5

    public int solve (String s) {
        // write code here
        char[] arr = s.toCharArray();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // 当前是操作数
            if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/'){
                list.add(arr[i]);
            }else if(arr[i] == '('){
                // 当前是括号表达式，找出整个括号表达式内容，进行递归处理计算括号内的值
                // 左括号数
                int left_kh = 1;
                StringBuilder sb = new StringBuilder();
                while (left_kh != 0){
                    i++;
                    if(arr[i] == '('){
                        left_kh ++;
                    }else if(arr[i] == ')'){
                        left_kh --;
                        if(left_kh == 0) {
                            break;
                        }
                    }
                    sb.append(arr[i]);
                }
                // 将括号内容进行递归处理，拿到括号内计算结果
                list.add(solve(sb.toString()));
            }else {
                // 当前是操作数，找出具体的完整数值
                StringBuilder sb = new StringBuilder();
                while (i < arr.length && arr[i] >= '0' && arr[i] <= '9'){
                    sb.append(arr[i++]);
                }
                // 当前i下标对应字符已不是数值，应该退回上一步
                i--;
                list.add(Integer.parseInt(sb.toString()));
            }
        }
        // 此stack中左右操作数以及操作符 + -，没有*。
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if(obj instanceof Character && (Character)obj == '*'){
                // 取出栈顶操作数 和 list中当前操作符的下一个操作数
                stack.push((Integer)stack.pop() * (Integer) list.get(++i));
            }else {
                stack.push(obj);
            }
        }
        // 翻转stack
        Stack<Object> stack2 = new Stack<>();
        while (!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        stack = stack2;
        // 此list中左右操作数以及操作符 + -，没有*
        int result = 0;
        while (!stack.isEmpty()){
            Object obj = stack.pop();
            if(obj instanceof Character){
                char operator = (char) obj;
                int num = (int)stack.pop();
                result = operator == '+' ? (result + num) : (result - num);
            }else {
                result = (int)obj;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BM49_表达式求值 test = new BM49_表达式求值();
        int i = test.solve("(2*(3-4))*5");
        System.out.println(i);
    }
}
