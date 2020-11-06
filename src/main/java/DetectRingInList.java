import java.util.HashSet;
import java.util.Set;

public class DetectRingInList {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.add(head) == false) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    public boolean hasCycleUsingTwoPointer(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
