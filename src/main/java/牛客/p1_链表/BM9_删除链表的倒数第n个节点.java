package 牛客.p1_链表;

/**
 * 描述
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 *
 * 数据范围： 链表长度 0\le n \le 10000≤n≤1000，链表中任意节点的值满足 0 \le val \le 1000≤val≤100
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 备注：
 * 题目保证 nn 一定是有效的
 * 示例1
 * 输入：
 * {1,2},2
 * 返回值：
 * {2}
 */
public class BM9_删除链表的倒数第n个节点 {


    public static ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode fastNode, slowNode = null ;
        fastNode = head;
        int moveCount = 1;
        // 找到 倒数 第n+1 个节点
        while (fastNode != null){
            if(moveCount-1 == n) slowNode = head;
            if(moveCount <= n+1){
                fastNode = fastNode.next;
                moveCount++;
                continue;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        if(slowNode == null)return head.next;
        slowNode.next = slowNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode head = removeNthFromEnd(n6, 1);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
