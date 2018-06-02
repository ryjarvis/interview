package linkedlist;

/**
 * @author: ryjarvis
 * Jan 6, 2018
 * 
 */
//LeetCode #206
public class ReverseLinkedList {
	public class ListNode{
		ListNode next;
		int val;
		public ListNode(int x){val=x;next=null;}
	}
	
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;       
        while(cur!=null){
            ListNode next=cur.next;
        	cur.next=prev;
        	prev=cur;
            cur=next;
        }
        return prev;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


