package competitions;

/**
 * @author: ryjarvis Dec 23, 2017
 * 
 */

public class Question644 {

	public String crackSafe(int n, int k) {
		StringBuilder sequence = new StringBuilder();
		generateLyndonWords(1, 1, k, new int[n + 1], sequence);
		if(k==1&&n>1){
			for(int i=0;i<k-1;i++){
				sequence.append(sequence.substring(0,1));
			}
		}
		if(k>1&&n>1){
			sequence.append(sequence.substring(0,n-1));
		}

		return sequence.toString();
	}

	private void generateLyndonWords(int t, int p, int k, int[] a, StringBuilder sequence) {
		if (t > a.length - 1) {
			if ((a.length - 1) % p == 0) {
				for (int i = 1; i < p + 1; i++) {
					sequence.append(a[i]);
				}
			}
		} else {
			a[t] = a[t - p];
			generateLyndonWords(t + 1, p, k, a, sequence);
			for (int j = a[t - p] + 1; j <= k - 1; j++) {
				a[t] = j;
				generateLyndonWords(t + 1, t, k, a, sequence);
			}
		}
	}
	
	int n, k;
	int[] a;
	StringBuilder sb = new StringBuilder();
	
	void db(int t, int p)
	{
        if(t > n){
        	if(n % p == 0){
        		for(int i = 1;i <= p;i++){
        			sb.append(a[i]);
        		}
        	}
        }else{
    		a[t] = a[t-p];
    		db(t+1, p);
    		for(int j = a[t-p] + 1;j < k;j++){
    			a[t] = j;
        		db(t+1, t);
    		}
    	}
	}
	
    public String crackSafe2(int n, int k) {
    	a = new int[n*k];
    	this.n = n; this.k = k;
    	if(k == 1){
    		sb.append("0");
    	}else{
    		db(1, 1);
    	}
    	for(int i = 0;i < n-1;i++){
    		sb.append(0);
    	}

    	return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
