package 牛客.p1_链表;

/**
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=295&tqId=23267&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 *
 * 描述
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
 *
 * 或输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}，转换过程如下图所示：
 *
 * 示例1
 * 输入：
 * {1,3,5},{2,4,6}
 * 返回值：
 * {1,2,3,4,5,6}
 * 示例2
 * 输入：
 * {},{}
 * 复制
 * 返回值：
 * {}
 * 示例3
 * 输入：
 * {-1,2,4},{1,3,4}
 * 返回值：
 * {-1,1,2,3,4,4}
 */
public class BM4_合并两个排序的链表 {

    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null ,cur = null, minNode;

        if(list1 == null) return list2;
        if(list2 == null) return list1;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                minNode = list1;
                list1 = list1.next;
            }else {
                minNode = list2;
                list2 = list2.next;
            }
            if(cur == null){
                head = cur = minNode;
            }else {
                cur.next = minNode;
                cur = minNode;
            }

        }
        if(list1 != null){
            cur.next = list1;
        }
        if(list2 != null){
            cur.next = list2;
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

        ListNode head = Merge(n1, n2);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
