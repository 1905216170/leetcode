package 牛客.p2_二分查找;

/**
 * 描述
 * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
 * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
 * 2.假设 nums[-1] = nums[n] = -\infty−∞
 * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * 4.你可以使用O(logN)的时间复杂度实现此问题吗？
 *
 * 数据范围：
 * 1 \le nums.length \le 2\times 10^5 \1≤nums.length≤2×10
 * 5
 *
 * -2^{31}<= nums[i] <= 2^{31} - 1−2
 * 31
 *  <=nums[i]<=2
 * 31
 *  −1
 *
 * 如输入[2,4,1,2,7,8,4]时，会形成两个山峰，一个是索引为1，峰值为4的山峰，另一个是索引为5，峰值为8的山峰，如下图所示：
 *
 * 示例1
 * 输入：
 * [2,4,1,2,7,8,4]
 * 复制
 * 返回值：
 * 1
 * 说明：
 * 4和8都是峰值元素，返回4的索引1或者8的索引5都可以
 * 示例2
 * 输入：
 * [1,2,3,1]
 * 复制
 * 返回值：
 * 2
 * 说明：
 * 3 是峰值元素，返回其索引 2
 * TOP
 */
public class BM19_寻找峰值 {

    public static int findPeakElement (int[] nums) {
        // write code here
        int pre = 0;
        for (int i = 1; i < nums.length; i++, pre++) {
            if(nums[pre] > nums[i]){
                return pre;
            }
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,1,2,7,8,4};
        System.out.println(findPeakElement(nums));
    }
}
