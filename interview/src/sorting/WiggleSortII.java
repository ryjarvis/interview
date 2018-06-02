package sorting;

import java.util.Arrays;

/**
 * @author: ryjarvis May 17, 2018
 * 
 */
// LeetCode #324
public class WiggleSortII {
	
	public static void wiggleSortExtraMemory(int []nums){
		int n=nums.length;
		if(n<2) return;
		int[]copy=Arrays.copyOf(nums, n);
		Arrays.sort(copy);
		int hi=n-1;
		int lo=0;
		int i=1;
		int j=n%2==1?n-1:n-2;
		while(lo<=hi){
            if(i<n){
               nums[i]=copy[hi--];
            }
            if(j>=0){
                nums[j]=copy[lo++];
            }
			
			i+=2;
			j-=2;			
		}
	}
//this solution works for most of the inputs and works based on virtual indexing
	public static void wiggleSort(int[] nums) {
        int n=nums.length;
        if(n<2) return;
        if(n<3){
            Arrays.sort(nums);
            return;
        }
		int mid=partition(nums,(n+1)>>1);
		int i=0;
		int k=n-1;
		int j=0;
		while(j<k){
			if(nums[index(j,n)]>mid){
				swap(index(j,n),index(i++,n),nums);
			}
			else if(nums[index(j,n)]<mid){
				swap(index(k--,n),index(j--,n),nums);
			}
			j++;
		}
	}
	
	public static int index(int idx,int n){
		return ((idx*2)+1)%(n|1);
	}

/*	public static int partition(int val, int[] nums) {
        if(nums.length < 3){
            return Math.min(nums[0],nums[1]);
        }
		int i=0;
		int j=0;
		int k=0;
		int mid=(nums.length)>>1;
		while(j<nums.length){
			if(nums[j]<val){
				i++;
			}
			else if(nums[j]==val){
				k++;
			}
			j++;
		}
		if(mid>=i&&mid<=i+k){
			return val;
		}
		else if(i>mid){
			return partition(nums[i-1],nums);
		}
		else {
			return partition(nums[i+k+1],nums);
		}
		
		
	}*/
	
	public static int partition(int[] nums, int k) {
	    final int R = (1 << 8);
	    final int bitmask = R - 1;
	    int[] aux = new int[nums.length];
	    for (int i = 0; i < 4; i++) {
	        int[] count = new int[R + 1];
	        for (int num : nums) {
	            int c = (num >>> (i * 8)) & bitmask;
	            count[c + 1]++;
	        }
	        for (int r = 0; r < R; r++) count[r + 1] += count[r];
	        if (i == 3) {
	            int shift1 = count[R] - count[R/2];
	            int shift2 = count[R/2];
	            for (int r = 0; r < R/2; r++)
	                count[r] += shift1;
	            for (int r = R/2; r < R; r++)
	                count[r] -= shift2;
	        }
	        for (int num : nums) {
	            int c = (num >>> (i * 8)) & bitmask;
	            aux[count[c]++] = num;
	        }
	        System.arraycopy(aux, 0, nums, 0, nums.length);
	    }
	    return nums[nums.length - k];
	}

	public static void shuffle(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int rand = (int) Math.random() * (i + 1);
			swap(rand, i, nums);
		}
	}

	public static void swap(int i, int j, int[] nums) {
		int aux = nums[i];
		nums[i] = nums[j];
		nums[j] = aux;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums={1,1,2,1,2,2,1};
		wiggleSortExtraMemory(nums);

	}

}
