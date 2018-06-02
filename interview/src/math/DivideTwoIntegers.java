package math;

public class DivideTwoIntegers {
	
    public static int divide(int dividend, int divisor) {
        long m=dividend;
        long n=divisor;
        long q=0;
        int sign=1;
        if((m<0&&n>0)||(m>0&&n<0)) sign=-1;
        m=Math.abs(m);
        n=Math.abs(n);
        long t=0;
        for(int i=31;i>=0;i--){
        	if(t+(n<<i)<=m){
        		q|=1L<<i;
        		t+=n<<i;
        	}
        }
        q=sign==1?q:-q;
        if(divisor==0||q>=Integer.MAX_VALUE||q<Integer.MIN_VALUE){
        	return Integer.MAX_VALUE;
        }
        return (int)q;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=divide(-2147483648,1);
		System.out.println(res);

	}

}
