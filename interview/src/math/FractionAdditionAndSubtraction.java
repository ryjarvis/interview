package math;

/**
 * @author: ryjarvis May 22, 2018
 * 
 */
// LeetCode #592

public class FractionAdditionAndSubtraction {
	//O(n) O(1) space solution
	public static  String fractionAddition(String exp) {
		if(exp.isEmpty()) return exp;
		int resNum=0;
		int resDenum=1;
		int nextNum;
		int nextDenum;
		int i=0;
		if(exp.charAt(0)!='-'){
			exp="+"+exp;
		}
		
		while(i<exp.length()){
			boolean sign=exp.charAt(i)=='-'?true:false;
			i++;
			if(exp.charAt(i+1)!='/'){
				nextNum=10;
				i+=3;
			}
			else{
				nextNum=(exp.charAt(i)-'0');
				i+=2;
			}
			
			if(sign) nextNum=-nextNum;
			if(i+1<exp.length()&&(exp.charAt(i+1)!='-'&&exp.charAt(i+1)!='+')){
				nextDenum=10;
				i+=2;
			}
			else{
				nextDenum=(exp.charAt(i)-'0');
				i++;
			}			
			resNum=resNum*nextDenum+resDenum*nextNum;
			resDenum*=nextDenum;
		}
		StringBuilder sb=new StringBuilder();
		boolean neg=resNum>=0?false:true;
		if(neg){
			sb.append("-");
			resNum=-resNum;
		} 
		int gcd=gcd(resNum,resDenum);
		sb.append(String.valueOf(resNum/gcd));
		sb.append("/");
		sb.append(String.valueOf(resDenum/gcd));
		return sb.toString();
	}
	
	public static int gcd(int a,int b){
		if(b==0) return a;
		return gcd(b,a%b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="1/3-1/2";
		String res=fractionAddition(s);
	}

}
