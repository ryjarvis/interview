package linkedlist;

//leetCode 19
public class RemoveNthNodeFromEndOfList {
	
	public class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			this.val=x;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null){
			return null;
		}
        int depth=removeHelper(head,n);
        head=depth>n?head:head.next;
        return head;
 
    }

	public static int removeHelper(ListNode head,int n){
		if(head.next==null){
			return 1;
		}
		int cur=1+removeHelper(head.next, n);
		if(cur==n+1){
			head.next=head.next==null?null:head.next.next;
		}
		return cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
