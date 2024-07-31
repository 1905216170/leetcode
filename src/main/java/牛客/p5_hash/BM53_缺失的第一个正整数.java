package 牛客.p5_hash;

import java.util.HashSet;
import java.util.Set;

public class BM53_缺失的第一个正整数 {

    public int minNumberDisappeared (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i=1;
        while (true){
            if(!set.contains(i)){
                return i;
            }
            i++;
        }
    }
}
