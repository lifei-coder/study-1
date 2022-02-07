package leetcode;

/**
 * @author lifei1@songguo7.com
 * @date 2022/1/14 17:27
 */
public class RemoveNthNode {



    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        moveNthNode(root, 3);

    }


    private static void moveNthNode(ListNode root, int n) {
        ListNode slow = root.next;
        ListNode fast = root.next;

        while (n < 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                slow.next = slow.next.next;
            }
        }
    }


    static class ListNode{
        int val;
        RemoveNthNode.ListNode next;

        public ListNode(int i) {
            this.val = i;
        }
    }

}
