package dynamicprogramming;

/**
 * @author: ryjarvis
 * Apr 15, 2018
 * 
 */
//LeetCode #96
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[]mem=new int[n+1];
        mem[0]=1;
        mem[1]=1;
        for(int i=2;i<=n;i++){
        	for(int j=0;j<i;j++){
        		mem[i]+=mem[j]*mem[i-1-j];
        	}
        }
        return mem[n];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


