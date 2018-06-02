package math;

/**
 * @author: ryjarvis
 * Apr 27, 2018
 * 
 */
//LeetCode #812
public class LargestTriangleArea {
	//this coming from the cross product of any points 
    public double largestTriangleArea(int[][] p) {
    	double max=0.0;
    	int n=p.length;
    	
    	for(int i=0;i<n-2;i++){
    		for(int j=i+1;j<n-1;j++){
    			for(int k=j+1;k<n;k++){
    				int res=((p[j][0]-p[i][0])*(p[k][1]-p[j][1]))-((p[k][0]-p[j][0])*(p[j][1]-p[i][1]));
    				double ans=(double)res/2;
    				max=Math.max(max,Math.abs(ans));
    			}
    		}
    	}
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


