package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2021/11/24 16:22
 */
public class ListNodeExample {

    // 合并两个有序链表
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode myNode = new ListNode(0);
        ListNode current = myNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            // 新链表指针一直往前走
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        } else {
            current.next = l1;
        }
        return myNode.next;
    }

    // 找到倒数第K个节点
    public ListNode findFromEnd(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode targetNode = findFromEnd(dummy, n + 1);
        targetNode.next = targetNode.next.next;
        return dummy.next;
    }

    // 判断链表是否有环
    private static boolean hasCycle(ListNode node) {
        ListNode p = node;
        ListNode pp = node;
        while (pp != null && pp.next != null) {
            p = p.next;
            pp = p.next.next;
            if (p == pp) {
                // 有环
                return true;
            }
        }
        // 不包含环
        return false;
    }

    // 如果两个链表相交点则返回这个相交点，没有则返回null
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1向前走:走完ListNode1再走ListNode2
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            // p2向前走: 走完ListNode2再走ListNode1
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }




    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int i) {
            this.val = i;
        }
    }



}
