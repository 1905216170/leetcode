package 牛客.p3_二叉树;

import java.util.ArrayList;

public class BM33_二叉树的镜像 {

    public void genMirror(TreeNode pRoot){
        if(pRoot == null) return ;
        TreeNode leftNode = pRoot.left;
        TreeNode rightNode = pRoot.right;
        pRoot.left = rightNode;
        pRoot.right = leftNode;
        genMirror(leftNode);
        genMirror(rightNode);
    }

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        genMirror(pRoot);
        return pRoot;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7= new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        node1 = new BM33_二叉树的镜像().Mirror(node1);

        ArrayList<ArrayList<Integer>> lists = BM26_二叉树的层序遍历.levelOrder(node1);
        System.out.println(lists);
    }
}
