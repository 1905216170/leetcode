package 牛客.p1_链表;

/**
 * 描述
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 *
 * 数据范围：0 \leq n \leq 10^50≤n≤10
 * 5
 *  ，0 \leq a_i \leq 10^90≤a
 * i
 * ​
 *  ≤10
 * 9
 *  ，0 \leq k \leq 10^90≤k≤10
 * 9
 *
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 例如输入{1,2,3,4,5},2时，对应的链表结构如下图所示：
 *
 * 其中蓝色部分为该链表的最后2个结点，所以返回倒数第2个结点（也即结点值为4的结点）即可，系统会打印后面所有的节点来比较。
 */
public class BM8_链表中倒数最后k个结点 {
    public static ListNode findKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode fastNode = pHead, slowNode = pHead;
        int fastStepCount = 1;
        while (fastNode != null){
            if(fastStepCount <= k){
                fastNode = fastNode.next;
                fastStepCount ++;
                continue;
            }
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastStepCount <= k ? null : slowNode;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode node = findKthToTail(n1, 4);
        System.out.println(node == null ? null : node.val);
    }
}
