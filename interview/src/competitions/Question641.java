package competitions;

/**
 * @author: ryjarvis
 * Dec 23, 2017
 * 
 */

public class Question641 {
    public int dominantIndex(int[] nums) {
    	int sum=nums[0];
    	int ind=0;
    	boolean res=true;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]>sum){
        		ind=i;
        		sum=nums[i];
        	}
        }
        for(int j=0;j<nums.length;j++){
        	if(sum<(2*nums[j])&&j!=ind){
        		res=false;
        	}
        }
        return res==true?ind:-1;
    }
    
    public int dominantIndex2(int[] a) {
        int n = a.length;
        outer:
        for(int i = 0;i < n;i++){
        	for(int j = 0;j < n;j++){
        		if(j != i && a[j] * 2 > a[i]){
        			continue outer;
        		}
        	}
        	return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


