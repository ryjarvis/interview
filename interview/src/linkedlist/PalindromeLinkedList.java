package linkedlist;

/**
 * @author: ryjarvis Feb 6, 2018
 * 
 */

public class PalindromeLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode mid;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast == null) {
			mid = slow;
		} else {
			mid = slow.next;
		}
		ListNode half = reverse(mid);
		while (half != null) {
			if (head.val != half.val) {
				return false;
			}
			head = head.next;
			half = half.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode cur = head;
		ListNode prev = null;
		ListNode next;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	// wrong solution
	public boolean isPalindromeWrong(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		boolean isOdd = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null)
			isOdd = true;
		ListNode mid = slow;
		ListNode tail = reverseWrong(slow.next);
		while (head.next != mid) {
			if (tail.val != head.val) {
				return false;
			}
			head = head.next;
			tail = tail.next;
		}
		if (!isOdd) {
			if (head.val != tail.val) {
				return false;
			}
		}
		return true;

	}

	public ListNode reverseWrong(ListNode node) {
		while (node != null && node.next != null) {
			node.next.next = node;
			ListNode temp = node.next;
			node.next = null;
			node = temp;
		}
		return node;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
