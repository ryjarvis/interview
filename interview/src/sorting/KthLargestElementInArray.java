package sorting;

import java.util.Random;

/**
 * @author: ryjarvis
 * Jan 16, 2018
 * 
 */
//LeetCode #215
public class KthLargestElementInArray {
	
	public static int findKthLargest(int[] nums, int k) {
        quickSort(nums,nums.length-k);
        return nums[nums.length-k];
    }
    
    public static void quickSort(int []ar,int k){
		quickSort(ar,0,ar.length-1,k);
	}
	
	public static void quickSort(int[]a,int lo,int hi,int k){
		if(lo>=hi){
			return;
		}
        if(hi<k){
            return;
        }
		int partition=partition(a, lo, hi);
        if(partition==k){
            return;
        }
        else{
            quickSort(a,lo,partition-1,k);
		    quickSort(a,partition+1,hi,k);
        }
	}
	
	public static int partition(int[]a,int lo,int hi){
		Random r=new Random();
		int rand=r.nextInt(hi-lo+1);
		swap(a,lo+rand,lo);
		int c=lo+1;
		int p=lo;
		while(c<=hi){
			if(a[c]<a[lo]){
				p++;
				swap(a,p,c);
			}
			c++;
		}
		swap(a,lo,p);
		return p;
	}
	
	public static void swap(int []a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar={3,2,1,5,6,4};
		findKthLargest(ar, 3);

	}

}


