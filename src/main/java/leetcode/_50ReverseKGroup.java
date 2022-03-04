package leetcode;

import leetcode.ListNodeExample.ListNode;

/**
 * @author lifei1@songguo7.com
 * @date 2022/2/23 上午12:53
 */
public class _50ReverseKGroup {

    public ListNode reverseKByGroup (ListNode head, int k){

        ListNode result = new ListNode(-1);
        ListNode index = result;

        ListNode cur = head;
        int length = getLength(head);

        int blocks = length/k;
        for (int i = 0; i < blocks; i++) {
            ListNode pre = null;
            for (int j = 0; j < k; j++) {
                // 反转k个节点
                ListNode p = cur.next;
                cur.next = pre;
                pre = cur;
                cur = p;
            }
            index.next = pre;
            while (index.next != null) {
                index = index.next;
            }
        }
        index.next = cur;

        return result.next;
    }


    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
