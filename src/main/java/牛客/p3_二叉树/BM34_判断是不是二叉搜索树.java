package 牛客.p3_二叉树;

public class BM34_判断是不是二叉搜索树 {

    boolean isValidBST = true;

    int smallVal = Integer.MIN_VALUE;

    void doCheck(TreeNode node){
        if(node == null) return;
        doCheck(node.left);
        if(!isValidBST) return;

        if(node.val <= smallVal){
            isValidBST = false;
            return;
        }
        smallVal = node.val;
        doCheck(node.right);
    }

    public boolean isValidBST (TreeNode root) {
        // write code here
        doCheck(root);
        return isValidBST;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        node1.left = node2;
        node1.right=node3;
//        node3.right=node4;
//        node4.left = node5;


        System.out.println(new BM34_判断是不是二叉搜索树().isValidBST(node1));
    }

}
