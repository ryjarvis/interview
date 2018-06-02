package math;

//leetCode #7
public class ReverseInteger {

	//subOptimal answer
	public static int reverseSubOptimal(int x) {
		boolean isNeg=false;
		if(x<0){
			isNeg=true;
			x=-1*x;
		}
		int length=length(x);
		int res=0;
		for(int i=1;i<=length;i++){
			int lowDigit=x%10;
			x/=10;
			long val=(lowDigit)*(long)Math.pow(10,length-i);
			if((val>>31)==0&&res>=0){
				res+=val;
			}
			else{
				return 0;
			}
		}
		return isNeg==false?res:-1*res;
	}
	
	public static int length(int x){
		int length=0;
		if(x==0){
			return 1;
		}
		while(x!=0){
			x/=10;
			length++;
		}
		return length;
	}
	
	public static int reverse(int x){
		int result=0;
		int temp;
		while(x!=0){
			temp=10*result+x%10;
			if(temp/10!=result){
				return 0;
			}
			result=temp;
			x/=10;
		}
		return result;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int res=reverse(15638474);
		System.out.println(res);
		System.out.println((1<<31)-1);

	}

}
