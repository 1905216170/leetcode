package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM35_判断是不是完全二叉树 {




    public boolean isCompleteTree (TreeNode root) {
        // write code here
        List<TreeNode> list = new ArrayList<>(1);
        List<TreeNode> newList;
        int currentLevelFullCount=1;
        list.add(root);
        while (list.size() != 0){
            newList = new ArrayList<>();
            boolean afterNodeAllowExist = true;
            for (TreeNode node : list) {
                if(node.left != null){
                    if(!afterNodeAllowExist) return false;
                    newList.add(node.left);
                }else if(afterNodeAllowExist) {
                    afterNodeAllowExist = false;
                }
                if(node.right != null){
                    if(!afterNodeAllowExist) return false;
                    newList.add(node.right);
                }else if(afterNodeAllowExist) {
                    afterNodeAllowExist = false;
                }
            }
            // 判断树是否还有下一层
            if(newList.size() != 0){
                // 判断当前这一层的节点数量是否是满的
                if(list.size() == currentLevelFullCount){
                    currentLevelFullCount *= 2;
                }else {
                    // 当前层的节点不是满节点
                    return false;
                }
            }
            list = newList;
        }
        return true;
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
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.left = node6;
        node3.right = node7;
        System.out.println(new BM35_判断是不是完全二叉树().isCompleteTree(node1));
    }

}
