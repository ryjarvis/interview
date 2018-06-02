package arrays;

public class JumpGame {
	
	
	//LeetCode #55
	//O(n) solution results of optimization over a bottom-up dynamic programming approach 
	public static boolean canJump(int[]nums){
		int length=nums.length;
		int prev=length-1;
		for(int i=length-2;i>=0;i--){
			if(nums[i]+i>=prev){
				prev=i;
			}
		}
		return prev==0;
	}
	
	
    public static boolean canJumpOverFlow(int[] nums) {
        return jumpHelper(nums,0);
    }
    
    
    // Backtracking solution stack overflow solution because of all the recursive calls 
    public static boolean jumpHelper(int[]nums,int idx){
    	if(idx>=nums.length-1){
    		return true;
    	}
    	int next=idx+nums[idx];
    	if(next>=nums.length-1){
    		return true;
    	}
    	for(int i=idx+1;i<=idx+nums[idx];i++){
    		if((i-idx)+nums[i]>next){
    			next=(i-idx)+nums[i];
    		}
    	}
    	if(idx==next){
    		return false;
    	}
    	return jumpHelper(nums,next);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,0,1,5};
		boolean res=canJump(nums);
		System.out.println(res);

	}

}
