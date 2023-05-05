package 牛客.p3_二叉树;

public class BM38_在二叉树中找到两个节点的最近公共祖先 {

    TreeNode lowestCommonNode = null;

    public int findLowestCommonAncestor(TreeNode node, int p, int q){
        if(node == null) return 0;
        int type = 0;
        if(node.val == p) type = 1; // 当前节点是p
        if(node.val == q) type = 2; // 当前节点是q

        // 递归到最深处，再从叶子节点往上回退查找
        int type1 = findLowestCommonAncestor(node.left, p, q);
        int type2 = findLowestCommonAncestor(node.right, p, q);

        // 如果(当前节点的左子树和右子树存在p和q) 或 (当前节点是p或q，在子孙节点中找到q或p)，且公共节点为空，那么当前节点为公共节点
        if((type1 + type2 == 3 || type + type1 == 3 || type + type2 == 3) && lowestCommonNode == null){
            lowestCommonNode = node;
        }

        // 如果当前节点或者左右子节点存在p或q，那么把q或p返回给父亲节点，告诉父亲节点当前节点或子孙节点存在q或p
        return type == 0 ? (type1 == 0 ? type2 : type1) : type;
    }

    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        findLowestCommonAncestor(root, p, q);
        return lowestCommonNode.val;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7= new TreeNode(14);
        TreeNode node8= new TreeNode(3);
        TreeNode node9= new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        System.out.println(new BM38_在二叉树中找到两个节点的最近公共祖先().lowestCommonAncestor(node1, 11, 12));
    }

}
