package sort;

public class MergeSortApp {

    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end) return;
        int mid = (start + end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        int[] tmp = new int[end - start + 1];
        int i = 0, startIndex = start, endIndex = mid + 1;
        while (startIndex <= mid && endIndex <= end){
            tmp[i++] = arr[startIndex] <= arr[endIndex] ? arr[startIndex++] : arr[endIndex++];
        }
        while (startIndex <= mid){
            tmp[i++] = arr[startIndex++];
        }
        while(endIndex <= end){
            tmp[i++] = arr[endIndex++];
        }
        for(i = 0; i<= (end - start); i++){
            arr[start + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 8, 4, 9, 10, 5, 7, 6};
        mergeSort(arr, 0, arr.length - 1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
