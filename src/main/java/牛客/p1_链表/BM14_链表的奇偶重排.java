package 牛客.p1_链表;

/**
 * 描述
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 *
 * 数据范围：节点数量满足 0 \le n \le 10^50≤n≤10
 * 5
 *  ，节点中的值都满足 0 \le val \le 10000≤val≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,3,4,5,6}
 * 返回值：
 * {1,3,5,2,4,6}
 * 说明：
 * 1->2->3->4->5->6->NULL
 * 重排后为
 * 1->3->5->2->4->6->NULL
 *
 * 示例2
 * 输入：
 * {1,4,6,3,7}
 * 返回值：
 * {1,6,7,4,3}
 * 说明：
 * 1->4->6->3->7->NULL
 * 重排后为
 * 1->6->7->4->3->NULL
 * 奇数位节点有1,6,7，偶数位节点有4,3。重排后为1,6,7,4,3
 */
public class BM14_链表的奇偶重排 {

    public static ListNode oddEvenList (ListNode head) {
        // write code here
        ListNode oddHead = new ListNode(0); // 奇数
        ListNode eventHead = new ListNode(0);   // 偶数
        ListNode oddNode = oddHead, eventNode = eventHead;

        boolean isOddNode = true;
        while (head != null){
            if(isOddNode){
                oddNode = oddNode.next = head;
            }else {
                eventNode = eventNode.next = head;
            }
            isOddNode = !isOddNode;
            head = head.next;
        }
        // 偶数节点的最后一个节点应该指向null
        eventNode.next = null;
        // 奇数最后一个节点 连 偶数链表的第一个节点。注意有哨兵节点
        oddNode.next = eventHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = oddEvenList(n1);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
