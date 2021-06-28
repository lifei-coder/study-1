package leetcode;

import lombok.val;

/**
 * @author lifei1@songguo7.com
 * @date 2021/6/27 16:46
 */
public class MergeTwoList {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode myNode = new ListNode(0);
        ListNode current = myNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return myNode.next;
    }

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int i) {
            this.val = i;
        }
    }


}
