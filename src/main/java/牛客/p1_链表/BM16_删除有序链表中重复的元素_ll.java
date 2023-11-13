package 牛客.p1_链表;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 * 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 例如：
 * 给出的链表为1 \to 2\to 3\to 3\to 4\to 4\to51→2→3→3→4→4→5, 返回1\to 2\to51→2→5.
 * 给出的链表为1\to1 \to 1\to 2 \to 31→1→1→2→3, 返回2\to 32→3.
 *
 * 数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中的值满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 示例1
 * 输入：
 * {1,2,2}
 * 返回值：
 * {1}
 * 示例2
 * 输入：
 * {}
 * 返回值：
 * {}
 */
public class BM16_删除有序链表中重复的元素_ll {

    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        Map<Integer, Boolean>map = new HashMap<>();
        ListNode node = head, pHead, nextNode;
        while (node != null){
            map.put(node.val, map.containsKey(node.val) ? true : false);
            node = node.next;
        }
        pHead = node = new ListNode(0);
        while (head != null){
            // 需要提前记录下一个节点，避免下一个记录被覆盖
            nextNode = head.next;
            if(!map.get(head.val)){
                node = node.next = head;
                // 下一个置空，
                node.next = null;
            }
            head = nextNode;
        }
        return pHead.next;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(2);
        ListNode n6 = new ListNode(2, n7);
//        ListNode n5 = new ListNode(1, n6);
//        ListNode n4 = new ListNode(3, n5);
//        ListNode n3 = new ListNode(3, n4);
//        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n6);
        ListNode head = deleteDuplicates(n1);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
