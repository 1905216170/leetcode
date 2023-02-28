package 牛客.p1_链表;

public class BM2_链表内指定区间反转 {

//    static class ListNode {
//        int val;
//        ListNode next = null;
//
//        public ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

//        1,2,3,4,5,6,7    2-4
        ListNode node = new ListNode(0, null);
        node.next = head;
        head = node;

        ListNode reversePreNode = head,reverseEndNode,nextNode, nextNextNode;

        // m-1所在的那个节点,即反转节点的前一个节点
        int i = 0;
        while (i < m-1){
            i++;
            reversePreNode = reversePreNode.next;
        }
        // 反转前反转节点里面的第一个节点，此节点会成为 反转后反转节点里面的最后一个节点
        node = reversePreNode.next;
        reverseEndNode = node;
        nextNode = node.next;
        int needReverseCount = n - m;
        while (node != null && nextNode != null && needReverseCount > 0){
            nextNextNode = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = nextNextNode;
            needReverseCount--;
        }

        reversePreNode.next = node;
        reverseEndNode.next = nextNode;

        return head.next;
    }


    public static void main(String[] args) {
        ListNode n7 = new ListNode(7, null);
//        ListNode n6 = new ListNode(6, n7);
//        ListNode n5 = new ListNode(5, n6);
//        ListNode n4 = new ListNode(4, n5);
//        ListNode n3 = new ListNode(3, n4);
//        ListNode n2 = new ListNode(2, n3);
//        ListNode n1 = new ListNode(1, n2);

        ListNode head = new BM2_链表内指定区间反转().reverseBetween(n7, 1, 1);

        while (head != null){
            System.out.println(head.val);
            head  = head.next;
        }

    }
}
