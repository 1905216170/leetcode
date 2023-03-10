package 牛客.p2_二分查找;

/**
 * 描述
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 *
 * 数据范围：1 \le n \le 100001≤n≤10000，数组中任意元素的值: 0 \le val \le 100000≤val≤10000
 * 要求：空间复杂度：O(1)O(1) ，时间复杂度：O(logn)O(logn)
 */
public class BM21_旋转数组的最小数字 {

    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 1)return array[0];
        int base = array[0];
        int min = 1;
        int max = array.length - 1;
        while (min < max){
            int mid = (max + min) / 2;
            if(array[mid] == base){
                int nextDistinctIndex = mid + 1;
                while (nextDistinctIndex <= max && array[nextDistinctIndex] == base){
                    nextDistinctIndex++;
                }
                if(nextDistinctIndex > max){
                    max = mid - 1;
                } else if(array[nextDistinctIndex] < base){
                    return array[nextDistinctIndex];
                }else {
                    min = nextDistinctIndex + 1;
                }
            }else if(array[mid] > base){
                min = mid + 1;
            }else {
                max = mid;
            }
        }
        return base < array[min] ? base : array[min];
    }

    public static void main(String[] args) {
//        10111 11101
        int[] nums = new int[]{2,2,2,1,2};
        System.out.println(minNumberInRotateArray(nums));
    }
}
