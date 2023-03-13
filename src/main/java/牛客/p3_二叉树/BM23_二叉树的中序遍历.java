package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一个二叉树的根节点root，返回它的中序遍历结果。
 *
 * 数据范围：树上节点数满足 0 \le n \le 10000≤n≤1000，树上每个节点的值满足 -1000 \le val \le 1000−1000≤val≤1000
 * 进阶：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,#,#,3}
 * 返回值：
 * [2,3,1]
 * 说明：
 *
 * 示例2
 * 输入：
 * {}
 * 返回值：
 * []
 * 示例3
 * 输入：
 * {1,2}
 * 返回值：
 * [2,1]
 * 说明：
 *
 * 示例4
 * 输入：
 * {1,#,2}
 * 返回值：
 * [1,2]
 * 说明：
 *
 * 备注：
 * 树中节点数目在范围 [0, 100] 内
 * 树中的节点的值在[-100,100]以内
 */


public class BM23_二叉树的中序遍历 {

    static List<Integer> list = new ArrayList<Integer>();

    public static void inorderCircle(TreeNode root) {
        if(root == null) return ;
        inorderCircle(root.left);
        list.add(root.val);
        inorderCircle(root.right);
    }

    public static int[] inorderTraversal (TreeNode root) {
        // write code here
        inorderCircle(root);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode rootRightNode = new TreeNode(2);
        TreeNode rootRightLeftNode = new TreeNode(3);
        rootNode.right = rootRightNode;
        rootRightNode.left = rootRightLeftNode;

        int[] arr = inorderTraversal(rootNode);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
