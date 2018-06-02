package linkedlist;

/**
 * @author: ryjarvis
 * Dec 26, 2017
 * 
 */
//LeetCode #141
public class LinkedListCycle {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val=x;
			next=null;
		}
	}
	
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
        	slow=slow.next;
            if(fast.next==null){
                return false;
            }
            else{
               fast=fast.next.next; 
            }
        	
            if(slow==fast){
        		return true;
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


