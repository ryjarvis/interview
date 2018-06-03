package competition87;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ryjarvis
 * Jun 2, 2018
 * 
 */

public class Question3 {
	
    public boolean isNStraightHand(int[] hand, int w) {
    	int n=hand.length;
    	if(n==1&&w==1) return true;
    	if(n%w!=0) return false;
    	Arrays.sort(hand);
    	Map<Integer,Integer> map=new HashMap<>();
    	Map<Integer,Integer> val=new HashMap<>();
    	boolean[]ar=new boolean[n];
    	int j=0;
    	for(int a:hand){
    		if(!map.containsKey(a)){
    			map.put(a, 0);
    		}
    		map.put(a,map.get(a)+1);
    		if(!val.containsKey(a)){
    			val.put(a, j);
    		}
    		j++;
    	}
    	int id=-1;
    	for(int i=0;i<n;i+=w){
    		id=getNext(ar,id );
    		int prev=hand[id];
    		for(int k=i+1;k<i+w;k++){
    			prev++;
    			if(map.containsKey(prev)&&map.get(prev)>0){
    				map.put(prev, map.get(prev)-1);
					ar[val.get(prev)]=true;
    				if(map.get(prev)>0){
    					val.put(prev, val.get(prev)+1);
    				}
    			}
    			else{
    				return false;
    			}
    		}
    	}
    	return true;
    	
        
    }
    
    public int getNext(boolean[]ar,int prev){
    	if(prev==-1){
    		return 0;
    	}
    	for(int i=prev+1;i<ar.length;i++){
    		if(!ar[i]){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public boolean isNStraightHand2(int[] hand, int W) {
		if(hand.length % W != 0) return false;
		TreeMap<Integer, Integer> dp = new TreeMap<Integer, Integer>();
		for(int out: hand) {
			dp.put(out, 1 + dp.getOrDefault(out, 0));
		}
		while(!dp.isEmpty()) {
			int first = dp.firstKey();
			for(int a = 0; a < W; a++) {
				if(dp.getOrDefault(first+a, 0) == 0) return false;
				update(dp, first+a, -1);
			}
		}
		return true;
    }

	private void update(Map<Integer, Integer> m, int k, int v) {
		m.put(k, v + m.getOrDefault(k, 0));
		if(m.get(k) == 0) m.remove(k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


