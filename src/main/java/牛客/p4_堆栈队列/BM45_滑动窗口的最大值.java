package 牛客.p4_堆栈队列;

import java.util.ArrayList;

public class BM45_滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        if(size == 0){
            return new ArrayList<>();
        }
        Integer maxVal = Integer.MIN_VALUE;
        ArrayList<Integer>list = new ArrayList<>();
        // 循环需要移动的次数，例如数组长度5，窗口大小3，那么需要移动3次，即 5 - 3 + 1 = 3
        for (int i = 0; i < num.length - size + 1; i++) {
            if(i == 0){
                // 计算最大值。
                for (int j = 0; j < size; j++) {
                    maxVal = maxVal > num[j] ? maxVal : num[j];
                }
            }else {
                // size 包含当前i（即窗口的第一个数），所以窗口最后一个数下标应该是 i + size - 1
                // 比较原窗口最大值 和 移动后窗口里面最后一个值的大小，来判断出当前最大值
                maxVal = num[i + size - 1] > maxVal ? num[i + size - 1] :maxVal;
            }
            list.add(maxVal);
            // 窗口往前移动时，需要判断离开窗口的值是不是最大值，如果是需要重新计算移动后窗口最大值
            if(maxVal == num[i]){
                maxVal = Integer.MIN_VALUE;
                for (int j = i + 1; j <= i + size - 1; j++) {
                    if(maxVal == null){
                        maxVal = j;
                    }
                    maxVal = maxVal > num[j] ? maxVal : num[j];
                }
            }
        }
        return list;
    }


}
