package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * Apr 30, 2018
 * 
 */
//LeetCode #817
public class LinkedListComponents {
	
	class ListNode{
		ListNode next;
		int val;
		public ListNode(int x){
			val=x;
		}
	}
	//you can also make it using an boolean array instead of set
    public int numComponents(ListNode head, int[] g) {
    	Set<Integer> seen=new HashSet<>();
    	for(int i:g){
    		seen.add(i);
    	}
    	int count=0;
    	while(!seen.isEmpty()&&head!=null){
    		if(seen.contains(head.val)){
    			while(!seen.isEmpty()&&seen.contains(head.val)){
        			seen.remove(head.val);
        			head=head.next;			
        		}
                count++;
    		}
    		else{
    			head=head.next;
    		}	
    	}
    	return count;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


