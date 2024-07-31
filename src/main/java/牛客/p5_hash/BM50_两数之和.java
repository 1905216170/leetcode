package 牛客.p5_hash;

import java.util.HashMap;
import java.util.Map;

public class BM50_两数之和 {

    public int[] twoSum (int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if(map.containsKey(target - num)){
                return new int[]{map.get(target - num), i + 1};
            }
            map.put(num, i + 1);
        }
        return null;
    }

    public static void main(String[] args) {
        BM50_两数之和 test = new BM50_两数之和();
        int[] arr = test.twoSum(new int[]{3, 2, 4}, 6);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
