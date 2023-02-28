package 牛客.p1_链表;

/**
 *https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=295&tqId=722&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * 描述
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 *
 * 数据范围： \ 0 \le n \le 2000 0≤n≤2000 ， 1 \le k \le 20001≤k≤2000 ，链表中每个元素都满足 0 \le val \le 10000≤val≤1000
 * 要求空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 例如：
 * 给定的链表是 1→2→3→4→5
 * 对于 k = 2 , 你应该返回 2→1→4→3→5
 * 对于 k = 3 , 你应该返回 3→2→1→4→5
 *
 * 示例1
 * 输入：
 * {1,2,3,4,5},2
 * 返回值：
 * {2,1,4,3,5}
 * 示例2
 * 输入：
 * {},1
 * 返回值：
 * {}
 */
public class BM3_链表中的节点每k个一组翻转 {

//    static class ListNode {
//        int val;
//        BM1_反转链表.ListNode next = null;
//
//        public ListNode(int val) {
//            this.val = val;
//        }
//
//        public ListNode(int val, BM1_反转链表.ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        int len = 0;
        ListNode node = head, nextNode, nextNextNode;
        while (node != null){
            len ++;
            node = node.next;
        }
        if(len < k)return head;

        node = head;
        nextNode = node.next;
        int needReverseCount = k - 1;
        while (node != null && nextNode != null && needReverseCount > 0){
            nextNextNode = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = nextNextNode;
            needReverseCount --;
        }
        head.next = reverseKGroup(nextNode, k);
        return node;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7, null);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = reverseKGroup(n1, 2);

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


}
