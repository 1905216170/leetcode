package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一个二叉树，返回他的后序遍历的序列。
 *
 * 后序遍历是值按照 左节点->右节点->根节点 的顺序的遍历。
 *
 * 数据范围：二叉树的节点数量满足 1 \le n \le 100 \1≤n≤100  ，二叉树节点的值满足 1 \le val \le 100 \1≤val≤100  ，树的各节点的值各不相同
 *
 * 样例图
 *
 *
 * 示例1
 * 输入：
 * {1,#,2,3}
 * 返回值：
 * [3,2,1]
 * 说明：
 * 如题面图
 * 示例2
 * 输入：
 * {1}
 * 返回值：
 * [1]
 */


public class BM23_二叉树的后序遍历 {

    static List<Integer> list = new ArrayList<Integer>();

    public static void postorderCircle(TreeNode root) {
        if(root == null) return ;
        postorderCircle(root.left);
        postorderCircle(root.right);
        list.add(root.val);
    }

    public static int[] postorderTraversal (TreeNode root) {
        // write code here
        postorderCircle(root);
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

        int[] arr = postorderTraversal(rootNode);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
