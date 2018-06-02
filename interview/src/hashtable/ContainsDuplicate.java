package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * Dec 24, 2017
 * 
 */
//LeetCode #217
public class ContainsDuplicate {
	
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer>set=new HashSet<Integer>();
    	boolean ans=true;
        for(int i:nums){
        	ans=set.add(i);
        	if(!ans){
        		break;
        	}
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


