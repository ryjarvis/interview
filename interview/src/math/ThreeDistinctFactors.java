package math;
//LintCode #728
public class ThreeDistinctFactors {
	
    public boolean isThreeDisctFactors(long n) {
        long sq=(long)Math.sqrt(n);
        return sq*sq==n&&isPrime(sq);
    }
    
    public boolean isPrime(long n){  
        for(long i=2;i*i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
