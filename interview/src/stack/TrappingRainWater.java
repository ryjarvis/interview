package stack;

//LeetCode #42
public class TrappingRainWater {
	//this is dynamic programming kind of solution
	//the important part of solving this problem is to know that how water trapped. It is trapped when the height of that point is smaller than min(maxLeftHeight,maxRightHeight)
	public static int trap(int[] h) {
		int n=h.length;
		int[]maxLeft=new int[n];
		int[]maxRight=new int[n];
		int res=0;
		for(int i=1;i<n;i++){
			maxLeft[i]=Math.max(maxLeft[i-1],h[i-1]);
		}
		for(int i=n-2;i>=0;i--){
			maxRight[i]=Math.max(h[i+1], maxRight[i+1]);
		}
		for(int i=1;i<n-1;i++){
			res+=Math.min(maxLeft[i], maxRight[i])-h[i]>0?Math.min(maxLeft[i], maxRight[i])-h[i]:0;
		}
		return res;
		
	}
	
	public static int trapTwoPointer(int[]h){
		int n=h.length;
		int left=0;
		int right=n-1;
		int rightMax=0;
		int leftMax=0;
		int res=0;
		while(left<right){
			if(h[left]<h[right]){
				res+=leftMax-h[left]>0?leftMax-h[left]:0;
				leftMax=Math.max(leftMax, h[left]);
				left++;
			}
			else{
				res+=rightMax-h[right]>0?rightMax-h[right]:0;
				rightMax=Math.max(rightMax,h[right]);
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]ar={0,1,0,2,1,0,1,3,2,1,2,1};
		int res=trapTwoPointer(ar);
		System.out.println(res);

	}

}
