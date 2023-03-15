package 牛客.p3_二叉树;

/**
 *
 数据范围：0 \le n \le 1000000≤n≤100000，树上每个节点的val满足 |val| \le 100∣val∣≤100
 要求： 空间复杂度 O(1)O(1),时间复杂度 O(n)O(n)
 示例1
 输入：
 {1,2}
 返回值：
 2
 示例2
 输入：
 {1,2,3,4,#,#,5}
 返回值：
 3
 */
public class BM28_二叉树的最大深度 {
    public static int maxDepth (TreeNode root) {
        // write code here
        if(root == null) return 0;
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(maxDepth(node1));
    }
}
