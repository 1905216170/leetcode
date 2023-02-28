package sort;

public class HeapSortApp {


    public static void justifyMaxHeap(int[]arr, int start, int end){
        int i = start, j = start * 2 + 1;
        while (j <= end){
            j = (j+1 > end) || (arr[j] < arr[j+1]) ? j : (j+1);
            if(arr[i] < arr[j]) break;
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i = j;
            j = j * 2 + 1;
        }
    }

    public static void heapSort(int[]arr, int len){
        int mid = len / 2 - 1;
        for(int i=mid; i>=0; i --){
            justifyMaxHeap(arr, i, len - 1);
        }

        int[] sortArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            sortArr[i] = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            justifyMaxHeap(arr, 0, arr.length - i - 2);
        }

        for (int i = 0; i< sortArr.length; i++){
            System.out.print (sortArr[i]+ " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 8, 4, 9, 10, 5, 7, 6};
        heapSort(arr, arr.length);

    }
}
