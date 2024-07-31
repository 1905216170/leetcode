package 牛客.p5_hash;

import cn.hutool.core.lang.tree.Tree;

import java.util.*;

public class BM52_数组中只出现一次的两个数字 {


    public int[] FindNumsAppearOnce (int[] nums) {
        Map<Integer, Boolean>map = new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num, false);
            }else {
                map.put(num, true);
            }
        }
        int[] arr = new int[2];
        int i = 0;
        for (Integer key : map.keySet()) {
            if(map.get(key)){
                arr[i++] = key;
                if(i == 2){
                    return arr;
                }
            }
        }
        return arr;
    }

}
