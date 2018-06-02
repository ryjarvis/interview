package linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*You are given two non-empty linked lists representing 
 * two non-negative integers. The digits are stored in reverse 
 * order and each of their nodes contain a single digit. Add the two numbers and
 *  return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/
public class TwoLinkedListSum{
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int l1Value;
        int l2Value;
        //int resValue;
        int sum;
       // l1Value=(l1==null?0:l1.val);
        //l2Value=(l2==null?0:l2.val);
        //sum=l1Value+ l2Value+carry;
        sum=l1.val+l2.val;
        carry=sum/10;
        //resValue=sum>9?sum%10:sum;
        ListNode resultList=new ListNode(sum%10);
            //resultList.value=sum>9?sum%10:sum;
        ListNode head=resultList;
        l1=l1==null?l1:l1.next;
        l2=l2==null?l2:l2.next;
        while(l1!=null||l2!=null){
            l1Value=l1==null?0:l1.val;
            l2Value=l2==null?0:l2.val;
            sum=l1Value+ l2Value+carry;
            carry=sum/10;
            //resultList.value=sum>9?sum%10:sum;
            //resValue=sum>9?sum%10:sum;
            l1=l1==null?l1:l1.next;
            l2=l2==null?l2:l2.next;
            resultList.next=new ListNode(sum%10);
            resultList=resultList.next;
        }
        if(carry==1){
            resultList.next=new ListNode(1);
        }
        return head;
    }
    
}

