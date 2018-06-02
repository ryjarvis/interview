package arrays;

/**
 * @author: ryjarvis
 * Apr 29, 2018
 * 
 */
//LeetCode #495
public class TeemoAttacking {
    public int findPoisonedDuration(int[] series, int duration) {
    	if(series.length==0) return 0;
    	int count=0;
        for(int i=0;i<series.length-1;i++){
        	count+=Math.min(series[i]+duration,series[i+1])-series[i];
        }
        count+=duration;
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


