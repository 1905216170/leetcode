package 牛客.其他算法;

import java.util.ArrayList;
import java.util.Arrays;

public class 寻找子串_KMP {


    public String kpmSearch(String s, String t){
        // 构造Next数组
        int[] nextArr = buildNextArr(t);
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()){
            if(t.charAt(j) == s.charAt(i)){
                j++;
                i++;
                if(j == t.length()){
                    sb.append(i - j + " ");
                    j = 0;
                }
            }else {
                int newJIndex = nextArr[j];
                if(newJIndex == -1){
                    i++;
                }else {
                    j = newJIndex;
                }
            }
        }
        String result = sb.toString().trim();
        return result.length() == 0 ? "-1" : sb.toString();
    }

    /**
     *  A B C A B A B
     * -1 0 0 0 1 2 1
     *
     *  A B A C A B A B D
     * -1 0 0 1 0 1 2 3 2
     * @param t
     * @return
     */
    public int[] buildNextArr(String t){
        int[] next = new int[t.length()];
        if(t.length() == 0) return next;
        int commLength = 0;
        int i = 1;
        next[0] = -1;
        while (i < t.length() - 1){
            if(t.charAt(commLength) == t.charAt(i)){
                commLength ++;
                next[++i] = commLength;
            }else if(commLength == 0){
                next[++i] = 0;
            }else {
                commLength = next[commLength];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        寻找子串_KMP test = new 寻找子串_KMP();
        System.out.println(test.kpmSearch("ababab", "abd"));
    }
}
