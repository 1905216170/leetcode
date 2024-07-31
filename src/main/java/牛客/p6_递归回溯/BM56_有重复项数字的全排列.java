package 牛客.p6_递归回溯;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BM56_有重复项数字的全排列 {

    public ArrayList<ArrayList<Integer>> recursionList(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> list, int[] nums){
        if(list.size() == nums.length){
            ArrayList<Integer> valList = new ArrayList<>(list.size());
            list.stream().forEach(index -> valList.add(nums[index]));
            resultList.add(valList);
            return resultList;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(i) || set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            list.add(i);
            recursionList(resultList, list, nums);
            list.remove(list.size() - 1);
        }
        return resultList;
    }

    public ArrayList<ArrayList<Integer>> permuteUnique (int[] num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        Arrays.sort(num);
        recursionList(resultList, new ArrayList<Integer>(), num);
        return resultList;
    }

    public static void main(String[] args) {
        BM56_有重复项数字的全排列 test = new BM56_有重复项数字的全排列();
        ArrayList<ArrayList<Integer>> list = test.permuteUnique(new int[]{2, 2,-1});
        System.out.println(list);
    }

}
