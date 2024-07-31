package 牛客.p5_hash;

import java.util.HashMap;
import java.util.Map;

public class BM51_数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution (int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
            if(map.get(num) > numbers.length / 2){
                return num;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}
