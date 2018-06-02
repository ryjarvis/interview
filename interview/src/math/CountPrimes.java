package math;

import java.util.BitSet;

/**
 * @author: ryjarvis
 * Dec 27, 2017
 * 
 */
//LeetCode #204
public class CountPrimes {
	
	public static int countPrimes(int n) {
        BitSet set=new BitSet(n+1);
        set.set(0,n+1);
        int i=2;
        while(i<=(Math.sqrt(n))){
        	if(set.get(i)){
        		int j=2*i;
        		while(j<=n){
        			set.clear(j);
        			j+=i;        			
        		}
        	}
    		i++;
        }
        return set.cardinality()-2;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=countPrimes(23);
		System.out.println(res);
		

	}

}


