package math;
//LeetCode #396
public class RotateFunction {
	
    public int maxRotateFunction(int[] ar) {
        int sum=0;
        int n=ar.length;
        int bk=0;
        for(int i=0;i<n;i++){
            sum+=ar[i];
            bk+=i*ar[i];
        }
        int max=bk;
        for(int i=n-2;i>=0;i--){
            int newBk=bk+sum-ar[i+1]-(n-1)*ar[i+1]; 
            max=Math.max(newBk,max);
            bk=newBk;
        }
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
