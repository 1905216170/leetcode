package 牛客.p1_链表;

import java.util.Queue;
import java.util.Stack;

public class BM11_链表相加 {

    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        Stack<ListNode>stack1 = new Stack<ListNode>();
        Stack<ListNode>stack2 = new Stack<ListNode>();

       ListNode p1 = head1, p2 = head2 ,head = null;
        while (p1 != null){
            stack1.add(p1);
            p1 = p1.next;
        }
        while (p2 != null){
            stack2.add(p2);
            p2 = p2.next;
        }
        boolean needAddOne = false;
        ListNode zeroNode = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            ListNode n1 = stack1.isEmpty() ? zeroNode : stack1.pop();
            ListNode n2 = stack2.isEmpty() ? zeroNode : stack2.pop();
            int num = n1.val + n2.val + (needAddOne ? 1 : 0);
            needAddOne = false;
            if(num >= 10) {
                needAddOne = true;
                num = num % 10;
            }
            ListNode node = new ListNode(num);
            if(head == null){
                head = node;
            }else {
                node.next = head;
                head = node;
            }
        }

        if(needAddOne){
            ListNode node = new ListNode(1);
            node.next = head;
            head = node;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6, null);
        ListNode n4 = new ListNode(4, n6);
        ListNode n2 = new ListNode(2, n4);

        ListNode n7 = new ListNode(7, null);
        ListNode n5 = new ListNode(5, n7);
        ListNode n3 = new ListNode(3, n5);
        ListNode n1 = new ListNode(1, n3);

        ListNode head = addInList(n1, n2);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
