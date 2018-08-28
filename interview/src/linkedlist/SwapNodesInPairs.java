package linkedlist;

//LeetCode #24
public class SwapNodesInPairs {
	public class ListNode{
		ListNode next;
		int val;
		public ListNode(int x){
			val=x;
		}
	}
	public ListNode swapPairs(ListNode head) {
		if(head.next==null){
			return head;
		}
		ListNode newHead=head.next;
		ListNode curHead=head.next;
		ListNode rest=head.next.next;
		curHead.next=head;
		head.next=rest;
		while(head.next!=null&&head.next.next!=null){
			curHead=head.next.next;
			rest=curHead.next;
			curHead.next=head.next;
			curHead.next.next=rest;
			head.next=curHead;
			head=curHead.next;
		}
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
