package competitions;

/**
 * @author: ryjarvis
 * Dec 30, 2017
 * 
 */

public class Question651 {
    public int reachNumber(int target) {
    	int s = 0;
        for(int i = 1;;i++){
        	s += i;
        	if(Math.abs(target) <= s && Math.abs(target) % 2 == s % 2){
        		return i;
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


