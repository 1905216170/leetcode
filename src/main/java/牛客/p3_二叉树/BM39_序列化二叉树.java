package 牛客.p3_二叉树;

import java.util.ArrayList;
import java.util.List;

public class BM39_序列化二叉树 {

    String Serialize(TreeNode root) {
        if(root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> newList;
        list.add(root);
        StringBuilder sb = new StringBuilder();
        while (list.size() > 0){
            newList = new ArrayList<>();
            boolean isAllEmptyNode = true;
            for (TreeNode treeNode : list) {
                if(treeNode.left != null || treeNode.right != null) isAllEmptyNode = false;
                sb.append(treeNode.val == -1 ? "#" : treeNode.val).append(",");
                newList.add(treeNode.left == null ? new TreeNode(-1) : treeNode.left);
                newList.add(treeNode.right == null ? new TreeNode(-1) : treeNode.right);
            }
            // 下一层都是空节点，跳出循环
            if(isAllEmptyNode) break;
            list = newList;
        }
        String val = sb.toString();
        int lastIndex = 0;
        for (int i = 0; i < val.length(); i++) {
            lastIndex = val.length() - i - 1;
            char c = sb.charAt(lastIndex);
            if(c >= '0' && c <= '9') break;
        }
        return val.substring(0, lastIndex + 1);
    }
    TreeNode Deserialize(String str) {
        if(str == null) return null;
        TreeNode root = null;
        String[] strArr = str.split(",");
        List<TreeNode> list = new ArrayList<TreeNode>();
        for (int i = 0; i <= (strArr.length - 1)/2; i++) {
            String val = strArr[i];
            if(val == "#"){
                list.add(null); // 将空节点作为 左右子节点添加到集合里面
                list.add(null);
                continue;
            }
            // 根节点不存在父节点，需要自己new；非根节点存在父节点，当前节点以被父亲节点创建过了，从缓存拿。
            TreeNode node = null;
            if(i == 0) {
                node = new TreeNode(Integer.parseInt(val));
                list.add(node);
                root = node;
            }else {
                // 取出list取出父亲已经好的当前节点
                node = list.get(i);
            }
            if(node == null) {
                list.add(null);
                list.add(null);
            }else {
                // 注意数组越界问题
                String leftChildVal = strArr.length <= i * 2 + 1 ? "#" : strArr[i * 2 + 1];
                String rightChildVal = strArr.length <= i * 2 + 2 ? "#" : strArr[i * 2 + 2];
                if(leftChildVal.equals("#")){
                    list.add(null); // 将空节点作为 左子节点添加到集合里面
                }else {
                    list.add(node.left = new TreeNode(Integer.parseInt(leftChildVal)));
                }
                if(rightChildVal.equals("#")){
                    list.add(null); // 将空节点作为 右子节点添加到集合里面
                }else {
                    list.add(node.right = new TreeNode(Integer.parseInt(rightChildVal)));
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new BM39_序列化二叉树().Deserialize("100,50,#,#,150");
        System.out.println(BM26_二叉树的层序遍历.levelOrder(treeNode));
        System.out.println(new BM39_序列化二叉树().Serialize(treeNode));
    }
}
