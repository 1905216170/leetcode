package sort;

public class QuickSortApp {


    public static void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int i = start, j = end;
        int baseVal = arr[start];
        while (i < j){
            while (baseVal < arr[j]){
                j --;
            }
            if(i == j) break;
            arr[i++] = arr[j];
            arr[j] = baseVal;

            while (baseVal > arr[i]){
                i ++;
            }
            if(i == j) break;
            arr[j--] = arr[i];
            arr[i] = baseVal;
        }
        arr[i] = baseVal;
        quickSort(arr, start, i - 1);
        quickSort(arr, i+1, end);

    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 8, 4, 9, 10, 5, 7, 6};
        quickSort(arr, 0, arr.length - 1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
