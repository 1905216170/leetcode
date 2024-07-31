package 牛客.p2_二分查找;

/**
 * 描述
 * 假设二维数值是依次递增的
 *
 */
public class BM18_二维数组中的查找2 {

    public boolean Find (int target, int[][] array) {
        // write code here
        // 0-1-2-3-5-10
        // [[],[],[]]
        // 排除0行或者0列的情况
        if(array.length == 0 || array[0].length == 0){
            return false;
        }
        // 最大行下标 和 最大列下标
        int rowMaxIndex, columnMaxIndex = 0;
        rowMaxIndex = array.length - 1;
        columnMaxIndex = array[0].length - 1;
        // 先找出行,再找列
        int min = 0, max = rowMaxIndex, mid, rowIndex = 0;
        // 排除比最小值小，比最大值大的情况
        if(target < array[0][0] || target > array[rowMaxIndex][columnMaxIndex]){
            return false;
        }
        while (min <= max){
            mid = (min + max) / 2;
            // 目标指若大于某一行的首个值且小于下一行的
            if(array[mid][0] <= target){
                if(target <= array[mid][columnMaxIndex]){
                    // target大于该行第一个值 且小于 该行的最后一个值，说明target在该行
                    rowIndex = mid;
                    break;
                }else {
                    // 目标值大于该行最后一个值，则说明目标值的行在该行之后
                    min = mid + 1;
                }
            }else {
                // target小于该行第一个值
                max = min - 1;
            }
        }
        // 目标行的最小值和最大值
        min = 0;
        max = columnMaxIndex;
        // 从指定行中找出target值
        while (min <= max){
            mid = (min + max) / 2;
            if(array[rowIndex][mid] < target){
                min = mid + 1;
            }else if(array[rowIndex][mid] > target){
                max = mid - 1;
            }else {
                // 找到目标值
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] douArr = {{1,4,6,8}, {10,14,18,20}, {21,23,25,29}, {30,33,38,81}};
        BM18_二维数组中的查找2 bm18_二维数组中的查找2 = new BM18_二维数组中的查找2();
        boolean find = bm18_二维数组中的查找2.Find(90, douArr);
        System.out.println(find);
    }
}
