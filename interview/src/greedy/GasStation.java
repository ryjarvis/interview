package greedy;

import java.util.BitSet;

/**
 * @author: ryjarvis
 * Dec 24, 2017
 * 
 */
//LeetCode #134
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalC=0;
        int totalG=0;
        int res=0;
        for(int i=0;i<gas.length;i++){
        	totalG+=gas[i];
        	totalC+=cost[i];
        }
        if(totalG>=totalC){
        	int i=0;
        	outer:
        	while(i<cost.length){
        		int save=0;
        		int j=i;
        		while(true){
        			if(j==cost.length+i){
        				
        				res=i;
        				break outer;
        				
        			}
        			save+=gas[j%cost.length]-cost[j%cost.length];
        			if(save<0){
        				break;
        			}
        			j++;
        		}
        		i=j+1;
        	}
        	return res;
        }
        else{
        	return -1;
        }
    }
    
	public static void main(String[] args) {
		int[]gas={1,2,3,3};
		int[]cost={2,1,5,1};
		int i=canCompleteCircuit(gas, cost);
		System.out.println(i);
		// TODO Auto-generated method stub

	}

}


