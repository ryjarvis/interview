package competitions;

/**
 * @author: ryjarvis
 * Dec 16, 2017
 * 
 */

public class Question631 {
    public static int minCostClimbingStairs(int[] cost) {
       for(int i=2;i<cost.length;i++){
    	   cost[i]=Math.min(cost[i-1], cost[i-2])+cost[i];
       }
       return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
    
    public static int helper(int[]c,int i,int tot){
    	if(i<2){
    		return tot;
    	}
    	else{
    		return Math.min(helper(c,i-1,tot+c[i-1]), helper(c,i-1,tot+c[i-2]));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]c={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		minCostClimbingStairs(c);
	}

}


