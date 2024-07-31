package 牛客.p6_递归回溯;

import java.util.ArrayList;
import java.util.List;

public class BM55_没有重复项数字的全排列 {


    public ArrayList<ArrayList<Integer>> recursionList(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(list));
            return resultList;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            recursionList(resultList, list, nums);
            list.remove(list.size() - 1);
        }
        return resultList;
    }
    public ArrayList<ArrayList<Integer>> permute (int[] num) {
        // write code here
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        recursionList(resultList, new ArrayList<Integer>(), num);
        return resultList;
    }

    public static void main(String[] args) {
        BM55_没有重复项数字的全排列 test = new BM55_没有重复项数字的全排列();
        ArrayList<ArrayList<Integer>> list = test.permute(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
