package 牛客.p1_链表;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class BM5_合并k个已排序的链表 {

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        Iterator<ListNode> iterator = lists.iterator();
        while (iterator.hasNext()){
            if(iterator.next() == null) iterator.remove();
        }
        ListNode cur = null, headNode = null;
        int minIndex, minVal;
        while (lists.size() > 0){
            minVal = lists.get(0).val;
            minIndex = 0;
            for(int i=1; i<lists.size(); i++){
                if(lists.get(i).val < minVal){
                    minVal = lists.get(i).val;
                    minIndex = i;
                }
            }
            // 已经找到最小节点
            ListNode minNode = lists.get(minIndex);
            if(cur == null){
                headNode = cur = minNode;
            }else {
                cur.next = minNode;
                cur = minNode;
            }
            minNode = minNode.next;
            if(minNode == null) lists.remove(minIndex);
            else lists.set(minIndex, minNode);
        }
        return headNode;
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6, null);
        ListNode n4 = new ListNode(4, n6);
        ListNode n2 = new ListNode(2, n4);

        ListNode n7 = new ListNode(7, null);
        ListNode n5 = new ListNode(5, n7);
        ListNode n3 = new ListNode(3, n5);
        ListNode n1 = new ListNode(1, n3);

        ArrayList<ListNode>list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        ListNode head = mergeKLists(list);
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
