//package tmp;
//
//import sun.reflect.generics.tree.Tree;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.locks.ReentrantLock;
//
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
//
//public class Test2 {
//
//    Integer depth1 = null;
//    Integer depth2 = null;
//    boolean isBalancedTree = true;
//
//    public void checkIsBalanced_Solution(TreeNode node, int depth){
//        if(node == null){
//            if(depth1 == null){
//                depth1 = depth;
//            }else {
//                if(depth1 != depth){
//                    if(depth2 == null){
//                        isBalancedTree = false;
//                        return;
//                    }else if(){
//
//                    }
//                }
//            }
//            if(depth1 == null){
//                depth1 = depth;
//            }else if(depth2 == null){
//                depth2 = depth;
//            }else if(depth != depth1 && depth != depth2){
//                isBalancedTree = false;
//                return;
//            }
//        }
//        depth ++;
//        checkIsBalanced_Solution(node.left, depth);
//        checkIsBalanced_Solution(node.right, depth);
//    }
//
//    public boolean IsBalanced_Solution (TreeNode pRoot) {
//        // write code here
//        checkIsBalanced_Solution(pRoot, 0);
//        return isBalancedTree;
//    }
//
//    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7= new TreeNode(7);
//
//        node1.left = node2;
//        node2.left = node4;
//
//    }
//
//}