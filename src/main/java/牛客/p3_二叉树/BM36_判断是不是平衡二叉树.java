package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM36_判断是不是平衡二叉树 {

    boolean isBalancedSolution = true;

    public int checkIsBalanced_Solution(TreeNode node, int len){
        if(node == null)return len;
        int leftLen = checkIsBalanced_Solution(node.left, len);
        int rightLen = checkIsBalanced_Solution(node.right, len);
        if(!isBalancedSolution) return -1;
        // 任何一个节点到叶子节点的长度
        if(Math.abs(leftLen - rightLen) > 1){
            isBalancedSolution = false;
            return -1;
        }
        return (leftLen > rightLen ? leftLen : rightLen) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        checkIsBalanced_Solution(root, 0);
        return isBalancedSolution;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7= new TreeNode(7);

        node1.left = node2;
        node2.left = node4;

        System.out.println(new BM36_判断是不是平衡二叉树().IsBalanced_Solution(node1));
    }
}
