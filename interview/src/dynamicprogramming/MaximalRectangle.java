package dynamicprogramming;

import java.util.Stack;

//LeetCode #85
public class MaximalRectangle {
	public static int maximalRectangle(char[][] mat) {
		int m=mat.length;
		if(m==0) return 0;
		int n=mat[0].length;
		int max=0;
		int []row=new int[n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				row[j]=mat[i][j]=='0'?0:row[j]+1;
			}
			int val=histCalculator(row);
			max=Math.max(val,max);
		}
		return max;
		
	}
	
	public static int histCalculator(int[]h){
		int n=h.length;
		int max=0;
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<=n;i++){
			int top=i<n?h[i]:0;
			if(st.isEmpty()||h[st.peek()]<=top){
				st.push(i);
			}
			else{
				while(!st.isEmpty()&&h[st.peek()]>top){
					st.pop();
					int idx=st.peek();
					int val=st.isEmpty()?i*h[idx]:(i-idx-1)*h[idx];
					max=Math.max(max, val);
				}
				st.push(i);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][]mat={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
maximalRectangle(mat);

	}

}
