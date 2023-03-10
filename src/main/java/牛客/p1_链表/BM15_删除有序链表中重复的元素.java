package 牛客.p1_链表;

import java.util.HashSet;
import java.util.Set;

public class BM15_删除有序链表中重复的元素 {

    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        Set<Integer> set = new HashSet<>();
        ListNode node = new ListNode(0);
        node.next = head;
        while (node.next != null){
            if(set.contains(node.next.val)){
                node.next = node.next.next;
            }else {
                set.add(node.next.val);
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(1, n6);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = deleteDuplicates(n1);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
