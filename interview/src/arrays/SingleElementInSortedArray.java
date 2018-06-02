package arrays;

/**
 * @author: ryjarvis
 * May 17, 2018
 * 
 */
//LeetCode #540
public class SingleElementInSortedArray {
	
    public int singleNonDuplicate(int[] nums) {
        int lo=0;
        int n=nums.length-1;
        int hi=n;
        int mid;
        while(lo<hi){
        	mid=lo+(hi-lo)/2;
        	if(mid+1<=n&&nums[mid]==nums[mid+1]){
        		if((hi-mid+1)%2==0){
        			hi=mid-1<0?0:mid-1;
        		}
        		else{
        			lo=mid+2;
        		}
        	}
        	else if(mid-1>=0&&nums[mid]==nums[mid-1]){
        		if((hi-mid)%2==0){
        			hi=mid-2<0?0:mid-2;
        		}
        		else{
        			lo=mid+1>n?n:mid+1;
        		}
        	}
        	else{
        		return nums[mid];
        	}
        }
        return nums[lo];
    }
    //cleaner solution
    public int singleNonDuplicateCleaner(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int m = l + (h - l)/2;
            if(m % 2 == 1) m--; 
            if(nums[m] == nums[m + 1]) l = m + 2;
            else h = m;
        }
        return nums[l];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


