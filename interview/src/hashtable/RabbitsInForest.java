package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Apr 28, 2018
 * 
 */
//LeetCode #781
public class RabbitsInForest {
	
    public int numRabbits(int[] ans) {
        Map<Integer,Integer> map=new HashMap<>();
        int total=0;
        for(int n:ans){
            if(n==0){
                total++;
                continue;
            }
            Integer val=map.get(n);
            if(val==null){
                map.put(n,1);
                total+=n+1;
            }
            else if(val<n){
                map.put(n,val+1);
            }
            else{
                map.remove(n);
            }
        }
        return total;
    }
    
    //since the numbers in the range of 0-999 we can do even better
    public int numRabbitsOptimized(int[]ans){
    	int[]map=new int[1000];
    	int count=0;
    	for(int i:ans){
    		if(map[i]>i||map[i]==0){
    			map[i]=1;
    			count+=i+1;
    		}
    		else{
    			map[i]++;
    		}
    	}
    	return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


