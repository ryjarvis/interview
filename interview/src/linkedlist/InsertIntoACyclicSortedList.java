package linkedlist;

//LintCode #599
public class InsertIntoACyclicSortedList {

	public ListNode insert(ListNode node, int x) {
		if (node == null) {
			ListNode m = new ListNode(x);
			m.next = m;
			return m;
		}
		ListNode cur = node;
		ListNode newNode = new ListNode(x);
		do {
			if (cur.val == x || (cur.val < cur.next.val && x > cur.val && x < cur.next.val)
					|| (cur.val > cur.next.val && (x < cur.next.val || x > cur.val))) {

				return addNode(cur, newNode);
			}
			cur = cur.next;

		} while (cur != node);
		if (newNode.next == null) {
			return addNode(node, newNode);
		}
		return null;
	}

	public ListNode addNode(ListNode cur, ListNode newNode) {
		ListNode aux = cur.next;
		cur.next = newNode;
		newNode.next = aux;
		return newNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
