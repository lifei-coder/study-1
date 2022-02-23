package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2021/11/24 16:22
 */
public class ListNodeExample {
    private  static ListNode root = new ListNode(0);


    static {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node3_ = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node3_;
        node3_.next = node4;
    }

    public static void main(String[] args) {
        ListNode listNode = deleteDuplicateNode(root);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


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

    // 有序链表，删除重复元素，保留一个重复元素{1,2,3,3,3,4} -> {1,2,3,4}
    public static ListNode deleteDuplicateNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        dummy.next = pre;
        ListNode cur = head;

        while (cur != null) {
            int repeatedValue = cur.val;
            ListNode next = cur.next;
            while (next != null && repeatedValue == next.val) {
                next = next.next;
            }
            pre.next = next;
            cur = next;
            pre = next;
        }

        return dummy.next;
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

    // 反转链表1
    static ListNode reverseListNode1(ListNode list) {
        // 要点1：pre移动到最后之后，就是反转后的链表的头指针
        ListNode pre = null;
        ListNode cur = list;
        while (cur != null) {
            // 要点2：使用临时指针temp保存cur.next的值
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 要点3: 这里得返回pre，pre此时是反转后的头指针
        return pre;
    }

    // 反转链表2
    void reverseListNode2(ListNode list) {

    }




    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int i) {
            this.val = i;
        }
    }



}
