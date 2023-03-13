package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 数据范围：二叉树的节点数量满足 1 \le n \le 100 \1≤n≤100  ，二叉树节点的值满足 1 \le val \le 100 \1≤val≤100  ，树的各节点的值各不相同
 * 示例 1：
 *
 *
 * 示例1
 * 输入：
 * {1,#,2,3}
 * 返回值：
 * [1,2,3]
 */


class TreeNode {
  int val = 0;
  TreeNode left = null;
  TreeNode right = null;
  public TreeNode(int val) {
    this.val = val;
  }
}



public class BM23_二叉树的前序遍历 {

    static List<Integer> list = new ArrayList<Integer>();

    public static void preorderCircle(TreeNode root) {
        if(root == null) return ;
        list.add(root.val);
        preorderCircle(root.left);
        preorderCircle(root.right);
    }

    public static int[] preorderTraversal (TreeNode root) {
        // write code here
        preorderCircle(root);
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

        int[] arr = preorderTraversal(rootNode);
        for (int i : arr) {
            System.out.println(i);
        }


    }

}
