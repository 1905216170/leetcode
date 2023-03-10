package 牛客.p2_二分查找;

/**
 * 描述
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 *
 * 给定 target = 3，返回 false。
 *
 * 数据范围：矩阵的长宽满足 0 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0 \le val \le 10^90≤val≤10
 * 9
 *
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n+m)O(n+m)
 * 示例1
 * 输入：
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：
 * true
 * 说明：
 * 存在7，返回true
 * 示例2
 * 输入：
 * 1,[[2]]
 * 返回值：
 * false
 * 示例3
 * 输入：
 * 3,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：
 * false
 * 说明：
 * 不存在3，返回false
 */
public class BM18_二维数组中的查找 {

    public boolean Find(int target, int [][] array) {
        if(array[0].length >= array.length){
            // 每行 比 每列的数要多，以行进行二分，以列作为遍历次数
            for (int i = 0; i < array.length; i++) {
                int min = 0;
                int max = array[0].length - 1;
                while (min <= max){
                    int mid = (min + max) / 2;
                    if(array[i][mid] == target){
                        return true;
                    }else if(target > array[i][mid]){
                        min = mid + 1;
                    }else {
                        max = mid - 1;
                    }
                }
            }
        }else {
            for (int i = 0; i < array[0].length; i++) {
                int min = 0;
                int max = array.length - 1;
                while (min <= max){
                    int mid = (min + max) / 2;
                    if(array[mid][i] == target){
                        return true;
                    }else if(target > array[mid][i]){
                        min = mid + 1;
                    }else {
                        max = mid - 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
