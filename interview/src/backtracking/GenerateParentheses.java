package backtracking;
import java.util.List;
import java.util.ArrayList;

//leetCode 22
public class GenerateParentheses {
	
	public static List<String> generateParenthesis(int n){
		List<String> result=new ArrayList<String>();
		char[] c=new char[2*n];
		generateParenthesisHelper(0,0,0,result,c,n);
		return result;
	}
	public static void  generateParenthesisHelper(int left,int right,int pos,List<String>res,char[]c,int n){
		if(right==n){
			res.add(String.valueOf(c));
		}
		if(left<n){
			c[pos]='(';
			generateParenthesisHelper(left+1, right, pos+1, res, c, n);
		}
		if(right<left){
			c[pos]=')';
			generateParenthesisHelper(left, right+1, pos+1, res, c, n);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(5);
	}

}
