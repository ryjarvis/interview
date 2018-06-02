package arrays;

//LeetCode #33
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
    	if(nums.length==0){
    		return -1;
    	}
    	int pivot=findPivot(nums, 0, nums.length-1);
    	if(pivot==nums.length-1){
    		return binarySearch(nums,0,pivot,target);
    	}
    	if(target>nums[pivot]){
    		return -1;
    	}
    	if(target>=nums[0]){
    		return binarySearch(nums,0,pivot,target);
    	}
    	return binarySearch(nums, pivot+1, nums.length-1, target);
        
    }
    
    public static int findPivot(int[]nums,int left,int right){
    	if(nums.length==1){
    		return left;
    	}
    	if(right==left+1){
    		return nums[left]>nums[right]?left:right;
    	}
    	int mid=(left+right)/2;
    	if(nums[left]>nums[mid]){
    		return findPivot(nums,left,mid);
    	}
    	else{
    		return findPivot(nums, mid, right);
    	}
    }
    
    public static int binarySearch(int nums[], int left,int right, int target){
    	while(left<=right){
    		int mid=(left+right)/2;
    		if(target==nums[mid]){
    			return mid;
    		}
    		else if(target<nums[mid]){
    			right=mid-1;
    		}
    		else{
    			left=mid+1;
    		}
    	}
    	return -1;
    }
    
    public static int binarySearch(int[]nums,int target){
    	int left=0;
    	int right=nums.length-1;
    	while(left<=right){
        	int mid=(left+right)/2;
    		if(target==nums[mid]){
    			return mid;
    		}
    		else if(target<nums[mid]){
    			right=mid-1;
    		}
    		else{
    			left=mid+1;
    		}
    	}
    	return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={11,0,8,9,10};
		int[]nums2={1};
		int[] sorted={1,2,3,4,5,12};
		int num=search(nums2,0);
		int res=findPivot(nums,0,nums.length-1);
		int index= binarySearch(sorted,8);
		System.out.println(res);
		System.out.println(index);
		System.out.println(num);

	}

}
