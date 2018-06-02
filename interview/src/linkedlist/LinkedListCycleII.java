package linkedlist;

/**
 * @author: ryjarvis Dec 30, 2017
 * 
 */
// LeetCode #142
public class LinkedListCycleII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean met = false;
		while (!met && fast != null) {
			slow = slow.next;
			fast = fast.next != null ? fast.next.next : null;
			if (slow == fast) {
				met = true;
			}
		}
		if (!met) {
			return null;
		}
		slow = head;
		while (slow != head) {
			slow = slow.next;
			head = head.next;
		}
		return slow;
	}

	public ListNode detectCycle2(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow = slow.next;
					slow2 = slow2.next;
				}
				return slow;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
