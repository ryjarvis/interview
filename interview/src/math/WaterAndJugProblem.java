package math;

/**
 * @author: ryjarvis
 * May 23, 2018
 * 
 */

public class WaterAndJugProblem {
	
    public boolean canMeasureWater(int x, int y, int z) {
        if(z>x+y) return false;
        else if(z==x+y) return true;
        return z%gcd(x,y)==0?true:false;
    }
    
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


