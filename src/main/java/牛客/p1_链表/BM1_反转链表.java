package 牛客.p1_链表;

public class BM1_反转链表 {


    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode node = head;
        ListNode nextNode = node == null ? null : node.next;
        ListNode nextNextNode;
        while (node != null && nextNode != null){
            nextNextNode = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = nextNextNode;
        }
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6, null);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = reverseList(n1);

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}