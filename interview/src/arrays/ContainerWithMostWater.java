package arrays;

//LeetCode 11
public class ContainerWithMostWater {
	//brute force solution
	public static int maxAreaSub(int[] height) {
		int max=0;
		for(int i=0;i<height.length;i++){
			for (int j=i+1;j<height.length;j++){
				max=Math.max(max, Math.min(height[i],height[j])*(j-i));
			}
		}

		return max;

	}
	
	public static int maxArea(int[] height){
		int max=0;
		int left=0;
		int right=height.length-1;
		while(left<right){
			//instead using min here its more optimize to that later since we know which one is smaller
			//max=Math.max(max, Math.min(height[left], height[right])*(right-left));
			if(height[left]<height[right]){
				max=Math.max(height[left]*(right-left), max);
				left++;
			}
			else{
				max=Math.max(height[right]*(right-left), max);
				right--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6};
		int res=maxArea(arr);
		System.out.println(res);

	}

}
