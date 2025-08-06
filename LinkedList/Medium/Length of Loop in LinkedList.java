class Solution {
    public int countNodesInLoop(ListNode head) {
        ListNode slow = head, fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Count loop length
                return countLoopLength(slow);
            }
        }

        return 0; // No loop
    }

    private int countLoopLength(ListNode nodeInLoop) {
        ListNode temp = nodeInLoop;
        int count = 1;

        while (temp.next != nodeInLoop) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
