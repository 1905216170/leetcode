package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM41_输出二叉树的右视图 {
    int index = 0;

    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        if(index == preOrder.length || vinOrder.length == 0){
            return null;
        }
        // 先序遍历方式
        int curVal = preOrder[index];
        TreeNode curNode = new TreeNode(curVal);
        // 以当前节点作为vinOrder的断点，将其分成两个数组
        int indexOfVal = 0;
        for (int val : vinOrder) {
            if(val == curVal){
                break;
            }
            indexOfVal++;
        }
        int[] leftArr = new int[indexOfVal];
        int leftArrIndex = 0, rightArrIndex = 0;
        int[] rightArr = new int[vinOrder.length - indexOfVal - 1];
        for (int i = 0; i < vinOrder.length; i++) {
            if(i == indexOfVal){
                continue;
            }else if(i < indexOfVal){
                leftArr[leftArrIndex ++] = vinOrder[i];
            }else {
                rightArr[rightArrIndex ++] = vinOrder[i];
            }
        }
        index++;
        // 分成两个子数组之后，左数组即为当前节点的左子树节点，右数组即为当前节点右子树节点
        TreeNode leftChildNode = reConstructBinaryTree(preOrder, leftArr);
        TreeNode rightChildNode = reConstructBinaryTree(preOrder, rightArr);
        curNode.left = leftChildNode;
        curNode.right = rightChildNode;
        return curNode;
    }

    public int[] solve (int[] preOrder, int[] inOrder) {
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);
        List<Integer> resultList = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        if(root != null) resultList.add(root.val);
        while (list.size() != 0){
            List<TreeNode> childList = new ArrayList<>();
            for (TreeNode node : list) {
                if(node.left != null){
                    childList.add(node.left);
                }
                if(node.right != null){
                    childList.add(node.right);
                }
            }
            if(childList.size() != 0){
                resultList.add(childList.get(childList.size() - 1).val);
            }
            list = childList;
        }

        int[] arr = new int[resultList.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = resultList.get(i);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,5,3};
        int[] vinOrder = new int[]{4,2,5,1,3};
        int[] solve = new BM41_输出二叉树的右视图().solve(preOrder, vinOrder);
        System.out.println(solve);
    }

}
