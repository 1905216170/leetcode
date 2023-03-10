package 牛客.p2_二分查找;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class BM20_数组中的逆序对 {

    static int count = 0;

    public void mergeSort(int[]arr, int start, int end){
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        int[] tmp = new int[end - start + 1];
        int i = start,j = mid + 1, n = 0;
        while (i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                tmp[n++] = arr[i++];
            }else {
                count = (count + mid - i + 1)%1000000007;
                tmp[n++] = arr[j++];
            }
        }
        while (i<=mid){
            tmp[n++] = arr[i++];
        }
        while (j<=end){
            tmp[n++] = arr[j++];
        }
        for(i = 0; i < n; i ++){
            arr[start + i] = tmp[i];
        }
    }

    public int InversePairs(int [] array) {
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        int inversePairs = new BM20_数组中的逆序对().InversePairs(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
        System.out.println(inversePairs);
    }
}
