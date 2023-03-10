package 牛客.p1_链表;

import java.util.Stack;

/**
 * 描述
 * 给定一个链表，请判断该链表是否为回文结构。
 * 回文是指该字符串正序逆序完全一致。
 * 数据范围： 链表节点数 0 \le n \le 10^50≤n≤10
 * 5
 *  ，链表中每个节点的值满足 |val| \le 10^7∣val∣≤10
 * 7
 *
 * 示例1
 * 输入：
 * {1}
 * 返回值：
 * true
 * 示例2
 * 输入：
 * {2,1}
 * 返回值：
 * false
 * 说明：
 * 2->1
 * 示例3
 * 输入：
 * {1,2,2,1}
 * 返回值：
 * true
 * 说明：
 * 1->2->2->1
 */
public class BM13_判断一个链表是否为回文结构 {

    public static boolean isPail (ListNode head) {
        // write code here
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.add(node);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()){
            if(stack.pop().val != node.val) return false;
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(1, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        System.out.println(isPail(n1));
    }
}
