package math;

//LeetCode #43
public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		int m=num1.length();
		int n=num2.length();
		if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
			return "0";
		}
		int[]res=new int[m+n];
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				int sum=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				res[i+j]+=sum/10;
				res[i+j+1]+=sum%10;
				if(res[i+j+1]>9){
					res[i+j]+=res[i+j+1]/10;
					res[i+j+1]=res[i+j+1]%10;
				}
				if(i+j>=1&&res[i+j]>9){
					res[i+j-1]+=res[i+j]/10;
					res[i+j]=res[i+j]%10;
				}				
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i:res){
			sb.append(i);
		}
		if(sb.length()>0&&sb.charAt(0)=='0'){
			return sb.substring(1).toString();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
