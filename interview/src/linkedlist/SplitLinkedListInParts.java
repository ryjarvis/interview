package linkedlist;

/**
 * @author: ryjarvis
 * May 7, 2018
 * 
 */
//LeetCode #725
public class SplitLinkedListInParts {
	
	class ListNode{
		ListNode next;
		int val;
		public ListNode(int x){
			val=x;
		}
	}
	//works in O(n) n being linked list size
	public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur=root;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        int mod=count%k;
        int div=count/k;
        ListNode[]res=new ListNode[k];
        ListNode curr=root;
        for(int i=0;i<k;i++){
            if(curr==null){
                break;
            }
            int n=mod>0?div+1:div;
            ListNode start=curr;
            while(n-1>0){
                curr=curr.next;
                n--;
            }
            mod--;
            res[i]=start;
            ListNode temp=curr.next;
            curr.next=null;
            curr=temp;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


