package linkedlist;
import java.util.Map;
import java.util.HashMap;

/**
 * @author: ryjarvis
 * Jan 23, 2018
 * 
 */
//LeetCode #138
public class CopyListWithRandomPointer {
	public class RandomListNode{
		int label;
		RandomListNode next,random;
		public RandomListNode(int x){label=x;}
	}
	//not optimized solution O(n) time O(n) space
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null){
    		return null;
    	}
    	Map<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode iter=head;
        RandomListNode iter2=new RandomListNode(head.label);
        RandomListNode temp=iter2;
        RandomListNode save=temp;
        if(iter.random!=null){
        	map.put(iter, iter.random);
        }
        iter.random=iter2;
        iter2.random=iter;
        iter=iter.next;       
        while(iter!=null){
        	RandomListNode fresh=new RandomListNode(iter.label);
        	iter2.next=fresh;
        	if(iter.random!=null){
        		map.put(iter, iter.random);
        	}
        	if(iter.random!=null){
        		map.put(iter, iter.random);
        	}
        	iter2=iter2.next;
        	iter.random=iter2;
        	iter2.random=iter;
        	iter=iter.next;
        }
        while(temp!=null){
        	if(map.containsKey(temp.random)){
        		RandomListNode val=map.get(temp.random);
        		temp.random=val.random;
        	}
        	else{
        		temp.random=null;
        	}
        	temp=temp.next;
        }
        
        while(head!=null){
        	if(map.containsKey(head)){
        		RandomListNode val=map.get(head);
        		head.random=val;
        	}
        	else{
        		head.random=null;
        	}
        	head=head.next;
        }
        
        return save;
        
    }
    //short Hashmap solution
    public RandomListNode copyRandomListHashMap(RandomListNode head) {
    	if(head==null){
    		return null;
    	}
    	RandomListNode iter=head;
    	Map<RandomListNode,RandomListNode> map=new HashMap<>();
    	while(iter!=null){
    		map.put(iter, new RandomListNode(iter.label));
    		iter=iter.next;
    	}
    	iter=head;
    	while(head!=null){
    		map.get(head).next=map.get(head.next);
    		map.get(head).random=head.random==null?null:map.get(head.random);
    		head=head.next;
    	}
    	return map.get(iter);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyListWithRandomPointer cp=new CopyListWithRandomPointer();
		RandomListNode rn=cp.new RandomListNode(1);
		rn.next=cp.new RandomListNode(2);
		rn.next.next=cp.new RandomListNode(3);
		rn.next.next.next=cp.new RandomListNode(1);
		rn.random=rn.next.next;
		rn.next.random=rn.next.next.next;
		rn.next.next.random=rn.next;
		rn.next.next.next.random=rn;
		RandomListNode res=cp.copyRandomList(rn);
		

	}

}


