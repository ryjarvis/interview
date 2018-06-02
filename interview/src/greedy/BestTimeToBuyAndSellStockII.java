package greedy;

/**
 * @author: ryjarvis
 * Feb 6, 2018
 * 
 */
//LeetCode #122
public class BestTimeToBuyAndSellStockII {
	//one solution
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int buy=prices[0];
        int sum=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>buy){
                sum+=prices[i]-buy;
            }
            buy=prices[i];
        }
        return sum;
        
    }
    //better solution
    public int maxProfitOptimized(int[]p){
    	int sum=0;
    	for(int i=1;i<p.length;i++){
    		if(p[i]>p[i-1]){
    			sum+=p[i]-p[i-1];
    		}
    	}
    	return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


