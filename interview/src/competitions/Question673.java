package competitions;

/**
 * @author: ryjarvis
 * Jan 13, 2018
 * 
 */

public class Question673 {
	
    public int countPrimeSetBits(int l, int r) {
    	int c=0;
        for(int i=l;i<=r;i++){
        	int t=count(i);
        	if(isPrime(t)){
        		c++;
        	}
        }
        return c;
    }
    
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}
    
    public static int count(int x){
    	int c=0;
    	while(x!=0){
    		x=x&(x-1);
    		c++;
    	}
    	return c;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


