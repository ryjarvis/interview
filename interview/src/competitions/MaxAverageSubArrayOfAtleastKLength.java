package competitions;

public class MaxAverageSubArrayOfAtleastKLength {
	 public double findMaxAverage(int[] nums, int k) {
	        int result=maxSumSubArrayOfK(nums,nums.length,k);
	        return (double)result/(double)k;
	 }
	   public static int maxSumSubArrayOfK(int a[], int n, int k)
	    {
	        int maxSum[] = new int [n];
	        maxSum[0] = a[0];
	 
	        int currentMax = a[0];
	        for (int i = 1; i < n; i++)
	        {
	            currentMax = Math.max(a[i], currentMax+a[i]);
	            maxSum[i] = currentMax;
	        }
	 
	        int sum = 0;
	        for (int i = 0; i < k; i++)
	            sum += a[i];
	 
	        int result = sum;
	        for (int i = k; i < n; i++)
	        {

	            sum = sum + a[i] - a[i-k];
	 
	            result = Math.max(result, sum);

	            result = Math.max(result, sum + maxSum[i-k]);
	        }
	        return result;
	    }
	   public class SolutionNew{
		    public double findMaxAverageNew(int[] nums, int k) {
		    	double low = -12345, high = 12345;
		    	for(int rep = 0;rep < 100;rep++){
		    		double h = (low+high)/2;
		    		if(ok(h, nums, k)){
		    			low = h;
		    		}else{
		    			high = h;
		    		}
		    	}
		    	return low;
		    }
		    
		    boolean ok(double h, int[] nums, int k){
		    	int n = nums.length;
		        double[] cum = new double[n+1];
		        for(int i = 0;i < n;i++){
		        	cum[i+1] = cum[i] + nums[i] - h;
		        }
		        double min = Double.POSITIVE_INFINITY;
		        for(int i = k-1;i < n;i++){
		        	min = Math.min(min, cum[i-(k-1)]);
		        	if(cum[i+1] - min >= 0)return true;
		        }
		        return false;
		    }
	   }
	   public class Solution {
		    public double findMaxAverage(int[] nums, int k) {
		        int[] sums = new int[nums.length + 1];
		        for(int i = 0; i < nums.length; ++ i) {
		            sums[i+1] = sums[i] + nums[i];
		        }
		        double lower = -10000, upper = 10000;
		        while (upper - lower >= 1e-6) {
		            double mid = (lower + upper) / 2;
		            if(check(sums, k, mid)) {
		                upper = mid;
		            }
		            else {
		                lower = mid;
		            }
		        }
		        return Math.abs(upper) < 1e-6 ? 0 : upper;
		    }

		    boolean check(int[] sums, int k, double avg) {
		        double[] t = new double[sums.length];
		        for(int i = 0; i < sums.length; ++ i) {
		            t[i] = sums[i] - avg * i;
		        }
		        double min = 0;
		        for (int i = k; i < t.length; ++ i) {
		            if(t[i - k] < min) {
		                min = t[i - k];
		            }
		            if(t[i] > min) {
		                return false;
		            }
		        }
		        return true;
		    }
		}
	 
}
