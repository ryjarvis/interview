package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #452
public class MinimumNumberofArrowstoBurstBalloons {
	//O(log(n))
    public int findMinArrowShots(int[][] points) {
    	if(points.length==0) return 0;
    	int ans=1;
    	Arrays.sort(points,(a,b)->a[0]-b[0]);
    	int[]prev=new int[2];
    	prev=points[0];
    	for(int[]p:points){
    		if(p[0]>prev[1]){
    			ans++;
    			prev=p;
    		}
    		else{
    			prev=new int[]{p[0],Math.min(prev[1], p[1])};
    		}
    		
    	}
    	return ans;
        
    }
    
    public int findMinArrowShotsOptimized(int[][] points) {
        if(points.length == 0)
            return 0;
        
        Arrays.sort(points, new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               if(a[1] == b[1])
                   return a[0] - b[0];
               
               return a[1] - b[1];
           } 
        });
        
        int res = 1, endPoint = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > endPoint) {
                res++;
                endPoint = points[i][1];
            }
        }
        
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


