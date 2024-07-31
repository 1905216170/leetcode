//package 牛客.p6_递归回溯;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;
//
//public class BM58_字符串的排列_2 {
//
//
//    ArrayList<String> list = new ArrayList<>();
//    public ArrayList recursionHandle(String str, StringBuilder sb, HashSet<Integer>indexSet){
//        if(str.length() == sb.length()) {
//            if (!list.contains(sb.toString())) {
//                list.add(sb.toString());
//                return list;
//            }
//        }
//        Set<Integer>set = new HashSet<>();
//        for (int i = 0; i < str.length(); i++) {
//            if(indexSet.contains(i)) continue;
//            if(set.contains(i)) continue;
//            set.add(i);
//            indexSet.add(i);
//            sb.append(str.charAt(i));
//            recursionHandle(str, sb, indexSet);
//            indexSet.remove(i);
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        return list;
//    }
//
//    public ArrayList<String> Permutation (String str) {
//        // write code here
//        return recursionHandle(str, new StringBuilder(), new HashSet<>());
//    }
//
//    public static void main(String[] args) {
//        BM58_字符串的排列_2 test = new BM58_字符串的排列_2();
//        ArrayList<String> list = test.Permutation("qwertyuio");
////        ArrayList<String> list = test.Permutation("qwertyuio");
//        System.out.println(list.size());
//    }
//
//}
