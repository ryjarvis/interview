package linkedlist;

/**
 * @author: ryjarvis
 * Feb 3, 2018
 * 
 */
//LeetCode #328
public class OddEvenLinkedList {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){val=x;}
	}
	
	public ListNode oddEvenList(ListNode head){
		if(head==null||head.next==null)return head;
		ListNode odd=head.next;
		ListNode odd_temp=odd;
		ListNode even=head;
		while(odd_temp!=null&&odd_temp.next!=null){
			even.next=odd_temp.next;
			even=even.next;
			odd_temp.next=even.next;
			odd_temp=odd_temp.next;
		}
		even.next=odd;
		return head;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


