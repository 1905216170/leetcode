package 牛客.p3_二叉树;

public class BM30_二叉搜索树与双向链表 {



    public TreeNode midList(TreeNode root, TreeNode resultNode) {
        if(root == null) return null;
        TreeNode treeNode = midList(root.left, resultNode);
        resultNode = treeNode == null ? resultNode :treeNode;

        resultNode.right = root;
        root.left = resultNode;
        resultNode = root;

        treeNode = midList(root.right, resultNode);
        resultNode = treeNode == null ? resultNode :treeNode;
        return resultNode;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode node = new TreeNode(-1);
        // midList第二个参数可以作为全局变量
        midList(pRootOfTree, node);
        node = node.right;
        if(node != null) node.left = null;
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
//        TreeNode node2 = new TreeNode(6);
//        TreeNode node3 = new TreeNode(14);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(8);
//        TreeNode node6 = new TreeNode(12);
//        TreeNode node7 = new TreeNode(16);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;

        BM30_二叉搜索树与双向链表 t1 = new BM30_二叉搜索树与双向链表();
        TreeNode node = t1.Convert(null);
        while (node != null){
            System.out.println(node.val);
            node = node.right;
        }

    }
}
