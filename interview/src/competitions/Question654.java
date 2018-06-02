package competitions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @author: ryjarvis
 * Dec 30, 2017
 * 
 */

public class Question654 {
	
    public int intersectionSizeTwo(int[][] rs) {
    	Arrays.sort(rs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});
    	int n = rs.length;
    	int p = 0;
    	int[] xs = new int[n*2+5];
    	for(int[] r : rs){
    		int rem = 2;
    		for(int i = 0;i < p;i++){
    			if(r[0] <= xs[i] && xs[i] <= r[1]){
    				rem--;
    			}
    		}
    		for(int i = 0;i < rem;i++){
    			xs[p++] = r[1] - i;
    		}
    	}
    	return p;
    }
    
    public int intersectionSizeTwo2(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->((a[0]==b[0])?(-a[1]+b[1]):(a[0]-b[0])));
        Stack<int[]> st=new Stack<>();
        for (int[] in:intervals)
        {
            while (!st.isEmpty() && st.peek()[1]>=in[1]) st.pop();
            st.push(in);
        }
        int n=st.size();
        int[][] a=new int[n][2];
        for (int i=n-1;i>=0;i--)
        {
            a[i][0]=st.peek()[0];
            a[i][1]=st.pop()[1];
        }
        int ans=2;
        int p1=a[0][1]-1,p2=a[0][1];
        for (int i=1;i<n;i++)
        {
            boolean bo1=(p1>=a[i][0] && p1<=a[i][1]),bo2=(p2>=a[i][0] && p2<=a[i][1]);
            if (bo1 && bo2) continue;
            if (bo2)
            {
                p1=p2;
                p2=a[i][1];
                ans++;
                continue;
            }
            p1=a[i][1]-1;
            p2=a[i][1];
            ans+=2;
        }
        return ans;
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int res=reachNumber(2);
		//System.out.println(res);
	}

}


