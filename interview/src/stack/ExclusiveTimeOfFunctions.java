package stack;

import java.util.List;
import java.util.Stack;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #636
public class ExclusiveTimeOfFunctions {
	//O(n)
	 public static int[] exclusiveTime(int n, List<String> logs) {
	       int[] num=new int[n];
	       Stack<int[]> stk=new Stack<>();
	       for(String s:logs){
	    	   String[] st=s.split(":");
	    	   int id=Integer.valueOf(st[0]);
	    	   int time=Integer.valueOf(st[2]);
	    	   if(st[1].equals("start")){
	    		  stk.push(new int[]{id,time});
	    	   }else{
	    		   int val=time-stk.pop()[1]+1;
	    		   num[id]+=val;
	    		   if(!stk.isEmpty()) num[stk.peek()[0]]-=val;
	    	   }    	   
	       }
	       return num;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


