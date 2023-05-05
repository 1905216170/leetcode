package 牛客.p3_二叉树;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 *描述
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。例如：
 * 两颗二叉树是:
 *                                                                     Tree 1
 *
 *
 *                                                                         Tree 2
 *
 *                                                                     合并后的树为
 *
 * 数据范围：树上节点数量满足 0 \le n \le 5000≤n≤500，树上节点的值一定在32位整型范围内。
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,3,2,5},{2,1,3,#,4,#,7}
 * 返回值：
 * {3,4,5,5,4,#,7}
 * 说明：
 * 如题面图
 * 示例2
 * 输入：
 * {1},{}
 * 返回值：
 * {1}
 */
public class BM32_合并二叉树 {


    public void doMergeTrees (TreeNode t1, TreeNode t2) {
        if(t2 == null) return ;
        t1.val += t2.val;
        if(t1.left == null){
            t1.left = t2.left;
        }else {
            doMergeTrees(t1.left, t2.left);
        }
        if(t1.right == null){
            t1.right = t2.right;
        }else {
            doMergeTrees(t1.right, t2.right);
        }


    }
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1 == null) return t2;
        doMergeTrees(t1, t2);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node1_2 = new TreeNode(3);
        TreeNode node1_3 = new TreeNode(2);
        TreeNode node1_4 = new TreeNode(5);
        node1_1.left = node1_2;
        node1_1.right = node1_3;
        node1_2.left = node1_4;

        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(1);
        TreeNode node2_3 = new TreeNode(3);
        TreeNode node2_4 = new TreeNode(4);
        TreeNode node2_5 = new TreeNode(7);
        node2_1.left = node2_2;
        node2_1.right = node2_3;
        node2_2.right = node2_4;
        node2_3.right = node2_5;

        TreeNode treeNode = new BM32_合并二叉树().mergeTrees(node1_1, node2_1);
        ArrayList<ArrayList<Integer>> lists = BM26_二叉树的层序遍历.levelOrder(treeNode);
        for (ArrayList<Integer> list : lists) {
            System.out.println(JSONUtil.toJsonStr(list));
        }


    }


}
