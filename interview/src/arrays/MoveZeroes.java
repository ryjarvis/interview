package arrays;

/**
 * @author: ryjarvis
 * Feb 6, 2018
 * 
 */
//LeetCode #283
public class MoveZeroes {
	
    public void moveZeroes(int[] nums) {
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&j==-1){
                j=i;
            }
            else if(j>=0&&nums[j]==0&&nums[i]!=0){
                swap(nums,i,j++);
            }
        }
    }
    public void swap(int[]ar,int i,int j){
        int aux=ar[i];
        ar[i]=ar[j];
        ar[j]=aux;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


