package 牛客.p4_堆栈队列;

import java.util.ArrayList;

public class BM46_最小的K个数 {


    /**
     * 构建小根堆
     * @param arr
     */
    public void buildSmallTree(int[] arr){
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            // 当前节点，左子节点 k*2+1，右子节点 k*2+2
            rebuildMinTree(arr, i, arr.length - 1);
        }
    }


    /**
     * 重建小根堆
     */
    public void rebuildMinTree(int[] arr, int startIndex, int maxIndex){
        int k = startIndex;
        while (k*2+1 <= maxIndex){
            // 左子节点
            int minChildIndex = k * 2 + 1;
            if(minChildIndex + 1 <= maxIndex){
                // 存在右子节点。比较左右子节点，拿到那个小的节点的下标
                minChildIndex = arr[minChildIndex] < arr[minChildIndex + 1] ? minChildIndex : minChildIndex + 1;
            }
            // 比较当前节点和最小子节点值 的大小
            if(arr[k] <= arr[minChildIndex]){
                // 当前节点 <= 最小子节点
                break;
            }else {
                int temp = arr[k];
                arr[k] = arr[minChildIndex];
                arr[minChildIndex] = temp;
                k = minChildIndex;
            }
        }
    }


    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end){
        int i = start, j = end;
        if(i >= j) return;
        int baseVal = arr[i];
        while (i < j){
            while (i != j && baseVal <= arr[j]){
                j --;
            }
            if(i == j) break;
            arr[i] = arr[j];
            i ++;
            while (i != j && baseVal >= arr[i]){
                i++;
            }
            if(i == j) break;
            arr[j] = arr[i];
            j --;
        }
        arr[i] = baseVal;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }


    

    public ArrayList<Integer> GetLeastNumbers_Solution (int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
//        快速排序
//        quickSort(input, 0, input.length - 1);
//        for (int i = 0; i < k; i++) {
//            list.add(input[i]);
//        }

        // 堆排序（小根堆）
        buildSmallTree(input);
        for (int i = 0; i < k; i++) {
            list.add(input[0]);
            input[0] = input[input.length - i - 1];
            rebuildMinTree(input, 0, input.length - i - 2);
        }

        return list;
    }


    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        BM46_最小的K个数 test = new BM46_最小的K个数();
        ArrayList<Integer> list = test.GetLeastNumbers_Solution(arr, 8);
        for (Integer num : list) {
            System.out.println(num);
        }
    }

}
