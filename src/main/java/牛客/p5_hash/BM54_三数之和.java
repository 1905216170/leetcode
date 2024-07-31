package 牛客.p5_hash;

import java.util.*;

public class BM54_三数之和 {

    public ArrayList<ArrayList<Integer>> threeSum (int[] num) {
        // write code here
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if(i != j){
                    int smallIndex = i < j ? i : j;
                    int bigIndex = i < j ? j : i;
                    if(map.containsKey(num[smallIndex] + num[bigIndex])) {
                        Set<String> set = map.get(num[smallIndex] + num[bigIndex]);
                        set.add(smallIndex + "~" + bigIndex);
                    }else {
                        Set<String> set = new HashSet<>();
                        set.add(smallIndex + "~" + bigIndex);
                        map.put(num[smallIndex] + num[bigIndex], set);
                    }
                }
            }
        }
        Set<String> resultSet = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            Set<String> set = map.get(num[i] * -1);
            if(set != null){
                for (String s : set) {
                    String[] indexArr = s.split("~");
                    int index1 = Integer.parseInt(indexArr[0]);
                    int index2 = Integer.parseInt(indexArr[1]);
                    int index3 = 0;
                    if(index1 != i && index2 != i){
                        if(num[i] < num[index1]){
                            index3 = index2;
                            index2 = index1;
                            index1 = i;
                        }else if(i > index1 && i < index2){
                            index3 = index2;
                            index2 = i;
                        }else {
                            index3 = i;
                        }
                        resultSet.add(index1 + "~" + index2 + "~" + index3);
                    }
                }
            }
        }

        Set<String> resultValSet = new HashSet<>();
        for (String s : resultSet) {
            String[] indexArr = s.split("~");
            // 对值进行去重
            int index1 = Integer.parseInt(indexArr[0]);
            int index2 = Integer.parseInt(indexArr[1]);
            int index3 = Integer.parseInt(indexArr[2]);
            int val1, val2, val3;
            if(num[index1] <= num[index2]){
                if(num[index3] <= num[index1]){
                    val1 = num[index3];
                    val2 = num[index1];
                    val3 = num[index2];
                }else if(num[index3] > num[index1] && num[index3] < num[index2]){
                    val1 = num[index1];
                    val2 = num[index3];
                    val3 = num[index2];
                }else {
                    val1 = num[index1];
                    val2 = num[index2];
                    val3 = num[index3];
                }
            }else {
                if(num[index3] <= num[index2]){
                    val1 = num[index3];
                    val2 = num[index2];
                    val3 = num[index1];
                }else if(num[index3] > num[index2] && num[index3] < num[index1]){
                    val1 = num[index2];
                    val2 = num[index3];
                    val3 = num[index1];
                }else {
                    val1 = num[index2];
                    val2 = num[index1];
                    val3 = num[index3];
                }
            }
            resultValSet.add(val1 + "~" + val2 + "~" + val3);
        }
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<>();
        for (String val : resultValSet) {
            String[] split = val.split("~");
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(Integer.parseInt(split[0]));
            innerList.add(Integer.parseInt(split[1]));
            innerList.add(Integer.parseInt(split[2]));
            outerList.add(innerList);
        }
        outerList.sort((arr1, arr2) -> {
            if(arr1.get(0) > arr2.get(0)){
                return 1;
            }else if(arr1.get(0) < arr2.get(0)){
                return -1;
            }else {
                if(arr1.get(1) > arr2.get(1)){
                    return 1;
                }else if(arr1.get(1) < arr2.get(1)){
                    return -1;
                }else {
                    if(arr1.get(3) > arr2.get(3)){
                        return 1;
                    }else if(arr1.get(3) < arr2.get(3)){
                        return -1;
                    }else {
                        return 1;
                    }
                }
            }
        });
        return outerList;
    }

    public static void main(String[] args) {
        BM54_三数之和 test = new BM54_三数之和();
        ArrayList<ArrayList<Integer>> outList = test.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        for (ArrayList<Integer> innerList : outList) {
            System.out.println(innerList);
        }
    }

}
