package 牛客.p3_二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BM40_重建二叉树 {

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

    void collectRightNode(TreeNode node, List<Integer>list){
        if(node == null){
            return;
        }
        // 当时是根节点，将跟节点添加进去
        if(list.size() == 0) list.add(node.val);
        // 左子节点不为空，将左子节点值添加进来
        if(node.right != null) list.add(node.right.val);
        collectRightNode(node.left, list);
        collectRightNode(node.right, list);
    }


    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,7,3,5,6,8};
        int[] vinOrder = new int[]{4,7,2,1,5,3,8,6};
        TreeNode treeNode = new BM40_重建二叉树().reConstructBinaryTree(preOrder, vinOrder);
        System.out.println(treeNode);
    }

}
