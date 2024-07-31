package 牛客.p6_递归回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BM58_字符串的排列 {


    public ArrayList recursionHandle(ArrayList<String> list, String str, StringBuilder sb){
        if(str.length() == 0){
            if(sb.length() != 0){
                list.add(sb.toString());
            }
            return list;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))){
                continue;
            }
            set.add(str.charAt(i));
            sb.append(str.charAt(i));
            recursionHandle(list, str.substring(0, i) + (i + 1 < str.length() ? str.substring(i + 1, str.length()) : ""), sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return list;
    }

    public ArrayList<String> Permutation (String str) {
        // write code here
        return recursionHandle(new ArrayList<>(), str, new StringBuilder());
    }

    public static void main(String[] args) {
        BM58_字符串的排列 test = new BM58_字符串的排列();
        ArrayList<String> list = test.Permutation("qwertyuio");
        System.out.println(list.size());
    }

}
