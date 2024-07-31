package 力扣;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {

    String [] arr = new String[]{"", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz",};


    public List<String> doLetterCombinations(String digits, StringBuilder sb, List<String>list) {
        if(digits.length() == 0) {
            return list;
        }
        int num = Integer.parseInt(digits.charAt(0) + "") - 1;
        String str = arr[num];
        for (int i = 0; i < arr[num].length(); i++) {
            char c = arr[num].charAt(i);
            sb.append(c);
            if(digits.length() > 1){
                doLetterCombinations(digits.substring(1, digits.length()), sb, list);
            } else {
                list.add(sb.toString());
            }

            sb.deleteCharAt(sb.length() -1);
        }
        return list;
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        doLetterCombinations(digits, new StringBuilder(""), list);
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new 电话号码的字母组合().letterCombinations("23");
        list.forEach(item ->{
            System.out.print(item + " ");
        });
    }

}
