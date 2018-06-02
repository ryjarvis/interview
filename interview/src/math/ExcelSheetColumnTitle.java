package math;

/**
 * @author: ryjarvis
 * Dec 28, 2017
 * 
 */
//LeetCode #168
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
    	if(n<=0){
    		return "";
    	}
        StringBuilder sb=new StringBuilder();
        while(n>0){
        	int val=n%26==0?26:n%26;
            int temp=val+(int)'A'-1;
            char c=(char)temp;
            n-=val;
            sb.append(c);
            n/=26;
        }
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res=convertToTitle(26);
		System.out.println(res);

	}

}


