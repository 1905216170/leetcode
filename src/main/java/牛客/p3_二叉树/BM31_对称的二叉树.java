package 牛客.p3_二叉树;

/**
 *
 */
public class BM31_对称的二叉树 {

    boolean isDiff = true;

    public void checkDiff(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return;
        if((node1 != null && node2 == null) || (node1 == null && node2 != null) || node1.val != node2.val) {
            isDiff = false;
            return;
        }
        checkDiff(node1.left, node2.right);
        if(!isDiff) return;
        checkDiff(node1.right, node2.left);

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        checkDiff(pRoot.left, pRoot.right);
        return isDiff;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        System.out.println(new BM31_对称的二叉树().isSymmetrical(node1));
    }

}
