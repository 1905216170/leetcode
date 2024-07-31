package 牛客.p4_堆栈队列;

import com.sun.org.apache.bcel.internal.generic.FADD;
import jdk.nashorn.internal.ir.CallNode;

import java.util.Arrays;

public class BM47_寻找第K大 {


    public int quickSort(int[] arr, int start, int end, int k){
        int i = start, j = end;
        if(i >= j) return arr[start];
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
        if(i == k){
            return arr[i];
        }
        if(i > k){
           return quickSort(arr, start, i - 1, k);
        }else {
           return quickSort(arr, i + 1, end, k);
        }
    }

    public int findKth (int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, n - K);
    }
    public static void main(String[] args) {
        BM47_寻找第K大 test = new BM47_寻找第K大();
        int[] arr = new int[]{1,3,5,4,4,6};
        System.out.println(test.findKth(arr, 6, 2));
    }

//    public static void main(String[] args) {
//        int[] arr = { 1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
//        Arrays.sort(arr);
//        System.out.println(arr.length);
//        int j = 1;
//        for (int i = 0; i < arr.length; i++, j++) {
//            System.out.println(j + "---" + arr[arr.length - i - 1]);
//        }
//    }

}
