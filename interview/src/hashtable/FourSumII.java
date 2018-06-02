package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Jan 25, 2018
 * 
 */
//LeetCode #454
public class FourSumII {	
    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer,Integer> map=new HashMap<>();
        int total=0;
        for(int i:a){
        	for(int j:b){
        		Integer key=i+j;
        		Integer count=map.get(key);
        		if(count==null){
        			map.put(key, 1);
        		}
        		else{
        			map.put(key, count+1);
        		}
        	}
        }
        for(int i:c){
        	for(int j:d){
        		Integer key=-(i+j);
        		Integer count=map.get(key);
        		if(count==null||count<1)continue;
        		else{
        			total+=count;      			
        		}
        	}
        }
        return total;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


