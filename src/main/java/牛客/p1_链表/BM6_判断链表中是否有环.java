package 牛客.p1_链表;

/**
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=295&tqId=605&ru=%2Fpractice%2Fd8b6b4358f774294a89de2a6ac4d9337&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
 * 描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *
 *
 * 数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中任意节点的值满足 |val| <= 100000∣val∣<=100000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 输入分为两部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。-1代表无环，其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点。
 *
 * 例如输入{3,2,0,-4},1时，对应的链表结构如下图所示：
 *
 * 可以看出环的入口结点为从头结点开始的第1个结点（注：头结点为第0个结点），所以输出true。
 * 示例1
 * 输入：
 * {3,2,0,-4},1
 * 返回值：
 * true
 * 说明：
 * 第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1（注：头结点为位置0），即-4->2存在一个链接，组成传入的head为一个带环的链表，返回true
 * 示例2
 * 输入：
 * {1},-1
 * 返回值：
 * false
 * 说明：
 * 第一部分{1}代表一个链表，-1代表无环，组成传入head为一个无环的单链表，返回false
 * 示例3
 * 输入：
 * {-1,-7,7,-4,19,6,-9,-5,-2,-5},6
 * 返回值：
 * true
 */
public class BM6_判断链表中是否有环 {

    public static boolean hasCycle(ListNode head) {
        ListNode fastNode, slowNode;
        fastNode = slowNode = head;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n7.next = n4;
        System.out.println(hasCycle(n1));
    }
}
