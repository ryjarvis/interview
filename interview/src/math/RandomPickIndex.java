package math;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #398
public class RandomPickIndex {
	
    private int[] num;

    public RandomPickIndex(int[] nums) {
        num=nums;
    }
    
    public int pick(int target) {
        int count=0;
        int chosen=-1;
        for(int i=0;i<num.length;i++){
            if(num[i]==target){
                int rand=(int)(Math.random()*(count+1))+1;
                if(rand==count+1){
                    chosen=i;
                }
                count++;
            }
        }
        return chosen;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


