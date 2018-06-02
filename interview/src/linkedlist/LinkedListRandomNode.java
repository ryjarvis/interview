package linkedlist;


/**
 * @author: ryjarvis May 6, 2018
 * 
 */
// LeetCode #382
public class LinkedListRandomNode {

	public class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	ListNode root;

	public LinkedListRandomNode(ListNode head) {
		root = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode cur = root;
		Integer chosen = cur.val;
		int count = 1;
		while (cur != null) {
			cur = cur.next;
			count++;
			if (((int) (Math.random() * count) + 1) == 1) {
				chosen = cur == null ? chosen : cur.val;
			}
		}
		return chosen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
