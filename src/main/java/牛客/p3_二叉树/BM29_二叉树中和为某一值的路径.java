package 牛客.p3_二叉树;

/**
 * 描述
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 *
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 *
 * 返回true，因为存在一条路径 5\to 4\to 11\to 25→4→11→2的节点值之和为 22
 *
 * 数据范围：
 * 1.树上的节点数满足 0 \le n \le 100000≤n≤10000
 * 2.每 个节点的值都满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(树的高度)O(树的高度)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {5,4,8,1,11,#,9,#,#,2,7},22
 * 返回值：
 * true
 * 示例2
 * 输入：
 * {1,2},0
 * 返回值：
 * false
 * 示例3
 * 输入：
 * {1,2},3
 * 返回值：
 * true
 * 示例4
 * 输入：
 * {},0
 * 返回值：
 * false
 */
public class BM29_二叉树中和为某一值的路径 {

    boolean flag = false;

    public void calRootToLeftLength(TreeNode root, int sum, int val){
        if(flag) return;
        if(root == null) {
            if(sum == val) flag = true;
            return;
        }

        // 左节点不为空或者 “左节点为空，右节点也是空,即节点是叶子节点”  左节点才有遍历下去的必要
        if(root.left != null || (root.left == null && root.right == null)){
            calRootToLeftLength(root.left, sum, val + root.val);
        }
        // 同理
        if(root.right != null || (root.right == null && root.left == null)){
            calRootToLeftLength(root.right, sum, val + root.val);
        }
    }


    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null) return false;
        calRootToLeftLength(root, sum, 0);
        return flag;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;

        BM29_二叉树中和为某一值的路径 t1 = new BM29_二叉树中和为某一值的路径();
        System.out.println(t1.hasPathSum(node1, 1));
    }
}
