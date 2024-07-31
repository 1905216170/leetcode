package 牛客.p5_hash;

import java.util.*;

public class BM54_三数之和2 {

    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        // 需要先排序
        Arrays.sort(num);
        int maxIndex = num.length - 1;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < num.length - 2; i++) {
            // 定义左指针和右指针。固定第一个数num[i]
            int left = i + 1;
            int right = maxIndex;
            // 另外两个数之和需要等于 num[i] * -1
            int targetVal = num[i] * -1;
            // -40,-10,-10,0,10,20
            //      i           j   -10+20 < 40，所以指针i需要往右移，这样才两数之和才可能变大，才可能 = -40
            while (left < right){
                if(targetVal < num[left] + num[right]){
                    // 两数之和 大于 目标值，右指针往左走，这样两数之和才会变小
                    right--;
                }else if(targetVal > num[left] + num[right]){
                    // 两数之和 小于 目标值，左指针往右走，这样两数之和才会变大
                    left++;
                }else {
                    // 两数之和大于目标值，
                    // 用set进行去重，按照小到大的方式排序，例如 -3~1~2，这样可避免 -3~2~1，从而导致结果重复
                if(num[i] <= num[left]){
                        set.add(num[i] + "~" + num[left] + "~" + num[right]);
                    }else if(num[i] > num[left] &&  num[i] < num[right]){
                        set.add(num[left] + "~" + num[i] + "~" + num[right]);
                    }else {
                        set.add(num[left] + "~" + num[right] + "~" + num[i]);
                    }
                    left++;
                    right--;
                }
            }
        }
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        for (String s : set) {
            String[] arr = s.split("~");
            ArrayList<Integer> innerList = new ArrayList<>(arr.length);
            innerList.add(Integer.parseInt(arr[0]));
            innerList.add(Integer.parseInt(arr[1]));
            innerList.add(Integer.parseInt(arr[2]));
            outerList.add(innerList);
        }
        outerList.sort((arr1, arr2) -> {
            if(arr1.get(0) > arr2.get(0)){
                return 1;
            }else if(arr1.get(0) < arr2.get(0)){
                return -1;
            }else {
                if(arr1.get(1) > arr2.get(1)){
                    return 1;
                }else if(arr1.get(1) < arr2.get(1)){
                    return -1;
                }else {
                    if(arr1.get(3) > arr2.get(3)){
                        return 1;
                    }else if(arr1.get(3) < arr2.get(3)){
                        return -1;
                    }else {
                        return 1;
                    }
                }
            }
        });
        return outerList;
    }


    public static void main(String[] args) {
        BM54_三数之和2 test = new BM54_三数之和2();
        ArrayList<ArrayList<Integer>> outList = test.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        for (ArrayList<Integer> innerList : outList) {
            System.out.println(innerList);
        }
    }
}
