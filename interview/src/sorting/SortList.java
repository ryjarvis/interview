package sorting;

/**
 * @author: ryjarvis
 * Jan 22, 2018
 * 
 */
//LeetCode #148
public class SortList {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val=x;
			next=null;
		}
	}
	
    public static ListNode sortList(ListNode head) {
    	if(head==null){
    		return head;
    	}
    	ListNode mid=head;
    	int length=0;
        while(head!=null){
        	head=head.next;
        	length++;
        }
        return mergeSort(mid,length);
        
    }
    
    public static ListNode mergeSort(ListNode node,int len){
    	if(len==1){
    		return node;
    	}
    	ListNode l=node;
    	for(int i=len/2;i>1;i--){
    		node=node.next;
    	}
    	ListNode r=node.next;
    	node.next=null;
    	ListNode left=mergeSort(l,len/2);
    	ListNode right=mergeSort(r,len-len/2);
    	return merge(left,right);
    	
    }
    
    public static ListNode merge(ListNode l,ListNode r){
    	ListNode head;
    	if(l.val<=r.val){
    		head=l;
    		l=l.next;
    	}
    	else{
    		head=r;
    		r=r.next;
    	}
    	ListNode temp=head;
    	while(true){
    		if(l==null){
    			temp.next=r;
    			break;
    		}
    		else if(r==null){
    			temp.next=l;
    			break;
    		}
    		else if(l.val<=r.val){
    			temp.next=l;
    			l=l.next;
    		}
    		else{
    			temp.next=r;
    			r=r.next;
    		}
    		temp=temp.next;
    	}
    	return head;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortList sl=new SortList();
		ListNode head=sl.new ListNode(4);
		ListNode temp=head;
		head.next=sl.new ListNode(2);
		head.next.next=sl.new ListNode(1);
		head.next.next.next=sl.new ListNode(3);
		ListNode ans=sortList(temp);

	}

}


