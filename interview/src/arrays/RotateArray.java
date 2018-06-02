package arrays;

/**
 * @author: ryjarvis
 * Dec 6, 2017
 * 
 */
//LeetCode #189
public class RotateArray {
	public static void rotate(int[]nums,int k){
		int l=nums.length;
		if(k==l||k==0){
			return;
		}
		if(k>l){
			k=k%l;
		}
		int m=gcd(Math.max(l, k),Math.min(l, k));

		for(int i=0;i<m;i++){
			int temp=nums[i];
			int j=l-k+i;
			while(j!=i){
				nums[(j+k)%l]=nums[j];
				j-=k;
				j=j<0?j+l:j;
			}
			nums[(i+k)%l]=temp;
		}
	}
	
	public static int gcd(int a,int b){
		if(b==0){
			return a;
		}
		return gcd(Math.max(a-b, b),Math.min(a-b, b));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]ar={1,2,3,4,5};
		System.out.println(-1%5);
		rotate(ar, 2);
	}

}


