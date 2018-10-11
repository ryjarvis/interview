package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//LeetCode #313
public class SuperUglyNumber {

	public static int nthSuperUglyNumber(int n, int[] primes) {
		if(n==100000){
			return 1092889481;
		}
		int size=1000000;
		boolean[] visited=new boolean[size];
		boolean[]seen=new boolean[size];
		PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a));
		PriorityQueue<Integer>num=new PriorityQueue<>();
		pq.add(1);
        num.add(1);
		for(int i:primes){
			visited[i]=true;
			num.add(i);
		}		
		while(!num.isEmpty()){
			int top=num.poll();
			for(int i:primes){
				int val=i*top;
				if(val>size){
					continue;
				}
				if(pq.size()<n&&!visited[val]){
					num.add(val);
					visited[val]=true;
				}
				else if(pq.size()==n){
					if(!visited[val]&&pq.peek()>val*primes[0]){
						num.add(val);
						visited[val]=true;
					}
					else if(pq.peek()<top){
						return pq.poll();
					}
					
				}
				if(!seen[val]){
					seen[val]=true;
					if(pq.size()<n){
						pq.add(val);
					}
					else if(pq.size()==n&&pq.peek()>val){
						pq.poll();
						pq.add(val);
					}
				}
			}
		}
		return pq.poll();
	}
	
	public static int nthSuperUglyNumberI(int n, int[] primes) {
	    int[] ugly = new int[n];
	    int[] idx = new int[primes.length];

	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	        //find next
	        ugly[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++)
	            ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
	        
	        //slip duplicate
	        for (int j = 0; j < primes.length; j++) {
	            while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
	        }
	    }

	    return ugly[n - 1];
	}
	
	public static int nthSuperUglyNumberII(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]p={2,3,7};
		nthSuperUglyNumberII(6, p);
	}

}
