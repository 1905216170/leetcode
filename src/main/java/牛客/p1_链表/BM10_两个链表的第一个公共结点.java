package 牛客.p1_链表;

import java.util.HashSet;

/**
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=295&tqId=23257&ru=%2Fpractice%2Ff95dcdafbde44b22a6d741baf71653f6&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 *描述
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * 数据范围： n \le 1000n≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 例如，输入{1,2,3},{4,5},{6,7}时，两个无环的单向链表的结构如下图所示：
 *
 * 可以看到它们的第一个公共结点的结点值为6，所以返回结点值为6的结点。
 * 输入描述：
 * 输入分为是3段，第一段是第一个链表的非公共部分，第二段是第二个链表的非公共部分，第三段是第一个链表和第二个链表的公共部分。 后台会将这3个参数组装为两个链表，并将这两个链表对应的头节点传入到函数FindFirstCommonNode里面，用户得到的输入只有pHead1和pHead2。
 * 返回值描述：
 * 返回传入的pHead1和pHead2的第一个公共结点，后台会打印以该节点为头节点的链表。
 * 示例1
 * 输入：
 * {1,2,3},{4,5},{6,7}
 * 返回值：
 * {6,7}
 * 说明：
 * 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
 * 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 * 示例2
 * 输入：
 * {1},{2,3},{}
 * 返回值：
 * {}
 * 说明：
 * 2个链表没有公共节点 ,返回null，后台打印{}
 */
public class BM10_两个链表的第一个公共结点 {

//    1-2-3 0-3      0-3  1-2-3
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1, node2 = pHead2;

        while (node1 != node2){
            node1 = node1 == null ? pHead2 : node1.next;
            node2 = node2 == null ? pHead1 : node2.next;
        }

        return node1;
    }
//    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
//        HashSet<ListNode> set = new HashSet<>();
//        HashSet<ListNode> set2 = new HashSet<>();
//
//        ListNode node1 = pHead1, node2 = pHead2;
//
//        while (node1 != null || node2 != null){
//            if(node1 != null){
//                if(set2.contains(node1)) return node1;
//                set.add(node1);
//                node1 = node1.next;
//            }
//            if(node2 != null){
//                if(set.contains(node2)) return node2;
//                set2.add(node2);
//                node2 = node2.next;
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6, null);
        ListNode n4 = new ListNode(4, n6);
        ListNode n2 = new ListNode(2, n4);

        ListNode n7 = new ListNode(7, null);
        ListNode n5 = new ListNode(5, n7);
        ListNode n3 = new ListNode(3, n5);
        ListNode n1 = new ListNode(1, n3);

        ListNode node = FindFirstCommonNode(n1, n2);
        System.out.println(node == null ? null : node.val);
    }


}
