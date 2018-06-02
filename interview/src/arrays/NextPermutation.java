package arrays;

/**
 * @author: ryjarvis
 * Apr 13, 2018
 * 
 */
//LeetCode #31
public class NextPermutation {
	//this solution is very optimized solution because of searching for the swap position in O(logn)
    public static void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-1;
        int prev=Integer.MIN_VALUE;
        while(i>=0){
        	if(nums[i]<prev){
        		break;
        	}
        	prev=nums[i];
        	i--;
        }
        if(i<0){
        	reverse(0,n-1,nums);
        }
        else{
        	int pos=insert(nums, nums[i],n-1,i+1);
        	swap(nums,i,pos);
        	reverse(i+1,n-1,nums);
        }
    }
    
    public static void reverse(int lo,int hi,int[]ar){
    	while(lo<hi){
    		swap(ar,hi,lo);
    		hi--;
    		lo++;
    	}
    }
    
    public static void swap(int[]ar,int i,int j){
    	int aux=ar[i];
    	ar[i]=ar[j];
    	ar[j]=aux;
    }
    
    public static int insert(int[]ar, int v,int hi,int lo){
    	if(lo==hi) return lo;
    	int mid=0;
    	while(lo<hi){
    		mid=(hi+lo)%2==0?lo+(hi-lo)/2:lo+(hi+1-lo)/2;
    		if(ar[mid]<=v){
    			hi=mid-1;
    		}
    		else{
    			lo=mid;
    		}
    	}
    	return lo;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar={1,5,1};
		//int pos=insert(ar,6, 3,1);
		nextPermutation(ar);
		//System.out.println(pos);

	}

}


