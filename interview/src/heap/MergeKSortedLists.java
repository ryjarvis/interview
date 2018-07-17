package heap;

import java.util.PriorityQueue;

//LeetCode #23
public class MergeKSortedLists {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val=x;
		}
	}
	 public ListNode mergeKLists(ListNode[] lists) {
	    	if(lists.length==0){
	    		return null;
	    	}
	        ListNode head=null;
	        ListNode temp=null;
	        ListNode next=null;
	         ListNode[]min=null;
	        PriorityQueue<ListNode[]> pq=new PriorityQueue<>((a,b)->(a[0].val-b[0].val));
	        for(ListNode n:lists){
	            if(n!=null){
	               	ListNode cur=n;
	        	next=cur.next;
	        	cur.next=null;
	        	pq.add(new ListNode[]{cur,next}); 
	            }
	        
	        }
	         if(!pq.isEmpty()){
	              min=pq.poll();
	        head=min[0];
	        temp=head;

	                   
	        if(min[1]!=null){
	                    next=min[1].next;
	        min[1].next=null;
	        	pq.add(new ListNode[]{min[1],next});
	        }
	         }

	        while(!pq.isEmpty()){
	        	min=pq.poll();
	        	temp.next=min[0];
	            if(min[1]!=null){
	                next=min[1].next;
	            min[1].next=null;
	            	pq.add(new ListNode[]{min[1],next});
	            }
	        	temp=temp.next;
	        }
	        return head;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
