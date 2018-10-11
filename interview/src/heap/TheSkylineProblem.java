package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

//LeetCode #218
public class TheSkylineProblem {
	
    public List<int[]> getSkyline(int[][] buildings) {
    	List<int[]> res=new ArrayList<>();
    	List<int[]> points=new ArrayList<>();
    	for(int[]b:buildings){
    		points.add(new int[]{b[0],-b[2]});
    		points.add(new int[]{b[1],b[2]});
    	}
    	Collections.sort(points,(a,b)->{
    		if(a[0]!=b[0]){
    			return a[0]-b[0];
    		}
    		else{
    			return a[1]-b[1];
    		}
    	});
    	TreeMap<Integer,Integer> set=new TreeMap<>((a,b)->b-a);
    	int prev=0;
    	set.put(0,1);
    	for(int[] p:points){
    		if(p[1]<0){
    			set.put(-p[1],set.getOrDefault(-p[1], 0)+1);
    		}
    		else{
    			int val=set.get(p[1]);
    			if(val==1){
    				set.remove(p[1]);
    			}
    			else{
    				set.put(p[1],val-1);
    			}
    		}
    		int cur=set.firstKey();
    		if(cur!=prev){
    			res.add(new int[]{p[0],cur});
    			prev=cur;
    		}
    	}
    	return res;
        
    }
    
    //make sure to solvd this using divide and conquer

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
