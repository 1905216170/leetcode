package 牛客.p1_链表;

import java.util.ArrayList;
import java.util.List;

public class BM12_单链表的排序 {

    void mergeSort(int[] arr, int start, int end){

    }

    public ListNode sortInList (ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        list.sort((num1, num2)->{
            return num1 - num2;
        });
        node= head;
        for (Integer num : list) {
            node.val = num;
            node = node.next;
        }
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
        ListNode listNode = new BM12_单链表的排序().sortInList(n1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
