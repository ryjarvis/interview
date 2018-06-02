package linkedlist;

/**
 * @author: ryjarvis
 * Dec 25, 2017
 * 
 */
//LeetCode #160
public class IntersectionOfTwoLinkedLists {
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val=x;
			next=null;
		}
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int la=length(headA);
        int lb=length(headB);
        int dif=la-lb;
        if(dif>0){
            while(dif>0){
                headA=headA.next;
                dif--;
            }
        }
        else{
            dif=-dif;
            while(dif>0){
                headB=headB.next;
                dif--;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    public static int length(ListNode n){
        int i=0;
        while(n.next!=null){
            n=n.next;
            i++;
        }
        return i;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


