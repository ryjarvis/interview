package math;

//LeetCode #50
public class Power {

    public double myPow(double x, int n) {
        if(n<0){
            return 1/(myPow(x,-(n+1))*x);
        }
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return Math.pow(myPow(x, n / 2), 2);
		} else {
			return x * myPow(x, n - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
