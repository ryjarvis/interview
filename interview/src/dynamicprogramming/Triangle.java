package dynamicprogramming;

import java.util.List;

/**
 * @author: ryjarvis
 * Dec 28, 2017
 * 
 */
//LeetCode #120
public class Triangle {
    public int minimumTotal(List<List<Integer>> t) {
        int h=t.size();
        if(h==0){
        	return 0;
        }
        for(int i=1;i<h;i++){
        	t.get(i).set(0,t.get(i).get(0)+ t.get(i-1).get(0));
        	t.get(i).set(t.get(i).size()-1, t.get(i).get(t.get(i).size()-1)+t.get(i-1).get(t.get(i-1).size()-1));
        	for(int j=1;j<t.get(i).size()-1;j++){
        		int cur=t.get(i).get(j);
        		int min=Math.min(t.get(i-1).get(j-1),t.get(i-1).get(j));
        		t.get(i).set(j, cur+min);
        	}
        }
        int m=Integer.MAX_VALUE;
        for(int i:t.get(h-1)){
        	if(i<m){
        		m=i;
        	}
        }
        return m;
    }
    
    public int minimumTotal2(List<List<Integer>> triangle) {
        if(triangle.size()==0)
            return 0;
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            List<Integer> path = triangle.get(i);
            dp[i] = dp[i-1]+path.get(path.size()-1);
            for(int j=path.size()-2;j>0;j--){
                dp[j] = Math.min(dp[j],dp[j-1])+path.get(j);
            }
            dp[0] = dp[0]+path.get(0);
        }
        int min = dp[0];
        for(int sum:dp)
            min = Math.min(sum,min);
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


