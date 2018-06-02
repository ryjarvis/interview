package linkedlist;

/**
 * @author: ryjarvis
 * May 15, 2018
 * 
 */
class ListNode{
	ListNode next;
	int val;
	public ListNode(int x){
		val=x;
	}
}
//LeetCode #445
public class AddTwoNumbersII {
	

	
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=nodeLength(l1);
        int len2=nodeLength(l2);
        ListNode longer;
        ListNode shorter;
        if(len1>len2){
        	longer=l1;
        	shorter=l2;
        }
        else {
        	longer=l2;
        	shorter=l1;
        }
        int i=Math.abs(len1-len2);
        ListNode cur=add(longer,shorter,i);
        ListNode head;
        if(cur.val>9){
        	cur.val=cur.val%10;
        	head=new ListNode(1);
        	head.next=cur;
        }
        else{
        	head=cur;
        }
        return head;              
    }
    
    public static ListNode add(ListNode l1,ListNode l2,int diff){
    	int carry=0;
    	ListNode cur;
    	if(l1==null){
    		return null;
    	}
    	if(diff>0){
    		ListNode next=add(l1.next,l2,diff-1);
    		if(next.val>9){
    			next.val=next.val%10;
    			carry=1;
    		}
    		cur=new ListNode(l1.val+carry);
    		cur.next=next;   		
    	}
    	else{
    		ListNode next=add(l1.next,l2.next,diff);
    		if(next.val>9){
    			next.val=next.val%10;
    			carry=1;
    		}
    		cur=new ListNode(l1.val+carry+l2.val);
    		cur.next=next;    	
    	}
    	return cur;
    	
    }
    
    public static int nodeLength(ListNode node){
    	int res=0;
    	while(node!=null){
    		res++;
    		node=node.next;
    	}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head1=new ListNode(7);
		head1.next=new ListNode(4);
		head1.next.next=new ListNode(2);
		head1.next.next.next=new ListNode(3);
		ListNode head2=new ListNode(5);
		head2.next=new ListNode(6);
		head2.next.next=new ListNode(4);
		addTwoNumbers(head1, head2);

	}

}


