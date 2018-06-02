package linkedlist;

/**
 * @author: ryjarvis
 * Feb 6, 2018
 * 
 */

public class DeleteNodeInLinkedList {
	
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val=x;
		}
	}
	
	public void deleteNode(ListNode node){
		if(node==null||node.next==null){
			return;
		}
		int temp=node.next.val;
		node.next.val=node.val;
		node.val=temp;
		node.next=null;
	}
	
	public void deleteNodeOptimized(ListNode node){
		node.val=node.next.val;
		node.next=node.next.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


