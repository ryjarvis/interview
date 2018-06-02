package arrays;

/**
 * @author: ryjarvis
 * May 13, 2018
 * 
 */

public class MaxChunksToMakeSorted {
	
    public static int maxChunksToSorted(int[] arr) {
    	int cur=0;
    	int max=Integer.MIN_VALUE;
    	int ans=0;
        while(cur<arr.length){
        	int i=cur;
        	max=Math.max(max, arr[cur]);
        	boolean seen=false;
        	while(i<arr.length){
        		max=Math.max(max, arr[i]);
        		if(arr[i]==cur){
        			seen=true;
        		}
        		if(seen&&max==i){
        			break;
        		}

        		i++;
        	}
        	cur=i+1;
        	ans++;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test={1,0,2,3,4};
		maxChunksToSorted(test);
		
	}

}


