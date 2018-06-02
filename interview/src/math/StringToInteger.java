package math;

//LeetCode #8
public class StringToInteger {
	
	public static int myAtoi(String s){
		char[] c=s.toCharArray();
		int hi='9';
		int lo='0';
		boolean isNeg=false;
		int result=0;
		int i=0;
		int temp;
		if(c.length!=0&&c[0]==' '){
			i++;
			while(c[i]==' '){
				i++;
			}
		}
		if(i<c.length&&c[i]=='-'){
			isNeg=true;
			i++;
		}
		if(i<c.length&&c[i]=='+'&&!isNeg){
			i++;
		}

		while(i<c.length){
			int dig=c[i];			
			if(dig>hi||dig<lo){
				return isNeg?-1*result:result;
			}
			temp=result*10+(dig-lo);
			if(temp/10!=result){
				return isNeg?-1*((1<<31)-1)-1:(1<<31)-1;
			}
			result=temp;
			i++;
			
		}
		return isNeg?-1*result:result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=myAtoi("  +05a");
		System.out.println(res);
	}

}
