package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2021/6/28 23:34
 */
public class HasCycle {


    // 给定一个链表，判断链表中是否有环。
    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        hasCycle(node);

    }

    private static boolean hasCycle(ListNode node) {
        ListNode p = node;
        ListNode pp = node;
        while (pp != null && pp.next != null) {
            p = p.next;
            pp = p.next.next;
            if (p == pp) {
                return true;
            }
        }
        return false;
    }




     //  Definition for singly-linked list.
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

}
