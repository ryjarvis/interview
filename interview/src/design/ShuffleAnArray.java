package design;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: ryjarvis
 * Jan 13, 2018
 * 
 */
//LeetCode #384
public class ShuffleAnArray {
	
    private int[] num;
    private int[] original;

    public ShuffleAnArray(int[] nums) {
        original=nums;
        num=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        num=Arrays.copyOf(original,original.length);
        for(int i=0;i<num.length;i++){
            Random rand=new Random();
            int r=rand.nextInt(i+1);
            swap(num,i,r);
        }
        return num;
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


