package 牛客.p2_二分查找;

/**
 * 描述
 * 请实现无重复数字的升序数组的二分查找
 *
 * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 *
 * 数据范围：0 \le len(nums) \le 2\times10^50≤len(nums)≤2×10
 *   ， 数组中任意值满足 |val| \le 10^9∣val∣≤10
 * 进阶：时间复杂度 O(\log n)O(logn) ，空间复杂度 O(1)O(1)
 *
 * 示例1
 * 输入：
 * [-1,0,3,4,6,10,13,14],13
 * 返回值：
 * 6
 * 说明：
 * 13 出现在nums中并且下标为 6
 * 示例2
 * 输入：
 * [],3
 * 返回值：
 * -1
 * 说明：
 * nums为空，返回-1
 * 示例3
 * 输入：
 * [-1,0,3,4,6,10,13,14],2
 * 返回值：
 * -1
 * 说明：
 * 2 不存在nums中因此返回 -1
 */
public class BM17_二分查_I {

    public static int search (int[] nums, int target) {
        // write code here
        if(nums.length == 0) return -1;
        int min = 0;
        int max = nums.length-1;
        while (min <= max){
            int mid = (min + max)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                max = mid -1;
            }else {
                min = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,4,6,10,13,14};
        System.out.println(search(nums, 2));
        System.out.println(search(nums, 4));

    }
}
