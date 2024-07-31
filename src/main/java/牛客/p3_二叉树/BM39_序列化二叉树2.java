package 牛客.p3_二叉树;

public class BM39_序列化二叉树2 {

    StringBuilder doSerialize(TreeNode root, StringBuilder sb) {
        if(root == null){
            return sb.append("#" + ",");
        }
        // 先序遍历法
        sb.append(root.val + ",");
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
        return sb;
    }

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        // 去掉字符串最后的 “,”
        return sb.toString().substring(0, sb.length() - 1);

    }

    int index = 0;

    TreeNode doDeserialize(String[] arr) {
        // 如果到达数组尾部或者当前节点是空，那么停止向下延迟
        if(arr.length == index || arr[index].equals("#")){
            index++;
            return null;
        }
        // 先序遍历法
        TreeNode curNode = new TreeNode(Integer.parseInt(arr[index++]));

        TreeNode leftChildNode = doDeserialize(arr);
        TreeNode rightChildNode = doDeserialize(arr);

        curNode.left = leftChildNode;
        curNode.right = rightChildNode;
        return curNode;
    }

    TreeNode Deserialize(String str) {
        index = 0;
        String[] arr = str.split(",");
        return doDeserialize(arr);
    }

    public static void main(String[] args) {
        BM39_序列化二叉树2 test = new BM39_序列化二叉树2();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        String serialize = test.Serialize(node1);
        System.out.println(serialize);
        TreeNode treeNode = test.Deserialize(serialize);
        String reSerialize = test.Serialize(treeNode);
        System.out.println(reSerialize);
    }
}
