package 牛客.p3_二叉树;

import java.util.ArrayList;

public class BM27_按之字形顺序打印二叉树 {

    public static ArrayList<ArrayList<Integer>> Print (TreeNode root) {
        // write code here
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
        ArrayList<ArrayList<Integer>> outerList = new ArrayList<ArrayList<Integer>>();
        if(root == null) return outerList;
        treeNodes.add(root);
        boolean leftToRight = true;
        while (treeNodes.size() > 0){
            ArrayList<TreeNode> childTreeNodes = new ArrayList<TreeNode>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < treeNodes.size(); i++){
                TreeNode treeNode = treeNodes.get(leftToRight ? i : treeNodes.size() - 1 - i);
                list.add(treeNode.val);

                TreeNode node = treeNodes.get(i);
                if(node.left != null) childTreeNodes.add(node.left);
                if(node.right != null) childTreeNodes.add(node.right);

            }
            leftToRight = !leftToRight;
            treeNodes = childTreeNodes;
            outerList.add(list);
        }
        return outerList;
    }

    public static void main(String[] args) {
//        3,9,20,#,#,15,7
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        ArrayList<ArrayList<Integer>> lists = Print(node1);
        System.out.println(lists);
    }
//     1
//    2 3
//    4567

}
