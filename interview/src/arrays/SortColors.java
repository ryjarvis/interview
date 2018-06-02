package arrays;

/**
 * @author: ryjarvis
 * Nov 29, 2017
 * 
 */

public class SortColors {
	
    public static void sortColors(int[] nums) {
        int l=nums.length;
        int zeroInd=0;
        int oneInd=0;
        //int twoInd=l-1;
        for(int i=0;i<l;i++){
        	if(nums[i]==0){
        		swap(nums,zeroInd++,i);
        		if(nums[i]!=1){
        			oneInd++;
        		}
        		
        	}
        	if(nums[i]==1){
        		swap(nums,oneInd++,i);
        	}
        	if(nums[i]==2){
        		swap(nums,oneInd,i);
        	}
        }
        if(l>=2&&nums[l-1]<nums[l-2]){
        	swap(nums,l-1,l-2);
        }
    }
    
    public static void swap(int[]nums,int i,int j){
    	if(i!=j){
        	int temp=nums[i];
        	nums[i]=nums[j];
        	nums[j]=temp;
    	}

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


