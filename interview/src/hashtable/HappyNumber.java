package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * Dec 17, 2017
 * 
 */
//LeetCode #202
public class HappyNumber {
	//normal solution
    public static boolean isHappyNormal(int n) {
        Set<Integer> set=new HashSet<Integer>();
        while(true){
            n=sumOfSquares(n);
            if(n==1){
            	return true;
            }
            if(set.contains(n)){
            	return false;
            }
            set.add(n);
        }

    }
    
    public static int sumOfSquares(int n){
    	int sum=0;
    	while(n!=0){
    		int dig=n%10;
    		n/=10;
    		sum+=dig*dig;
    	}
    	return sum;
    }
    
    //Solution with no extra memory
    public static boolean isHappy(int n){
    	int slow=n;
    	int fast=n;
    	while(true){
    		slow=sumOfSquares(slow);
    		if(slow==1){
    			return true;
    		}
    		fast=sumOfSquares(sumOfSquares(fast));
    		if(fast==1){
    			return true;
    		}
    		if(slow==fast)return false;
    	}    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


