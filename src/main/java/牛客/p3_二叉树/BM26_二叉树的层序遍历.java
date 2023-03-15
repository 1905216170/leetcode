package 牛客.p3_二叉树;

import java.util.ArrayList;

/**
 * 描述
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 *
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 提示:
 * 0 <= 二叉树的结点数 <= 1500
 *
 * 示例1
 * 输入：
 * {1,2}
 * 返回值：
 * [[1],[2]]
 * 示例2
 * 输入：
 * {1,2,3,4,#,#,5}
 * 返回值：
 * [[1],[2,3],[4,5]]
 */
public class BM26_二叉树的层序遍历 {


    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();
        if(root == null) return outerList;
        treeNodes.add(root);
        while (treeNodes.size() > 0){
            ArrayList<TreeNode> childTreeNodes = new ArrayList<TreeNode>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (TreeNode treeNode : treeNodes) {
                list.add(treeNode.val);
                if(treeNode.left != null) childTreeNodes.add(treeNode.left);
                if(treeNode.right != null) childTreeNodes.add(treeNode.right);
            }
            treeNodes = childTreeNodes;
            outerList.add(list);
        }
        return outerList;
    }

    public static void main(String[] args) {
//        3,9,20,#,#,15,7
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        ArrayList<ArrayList<Integer>> lists = levelOrder(node1);
        System.out.println(lists);
    }

}
