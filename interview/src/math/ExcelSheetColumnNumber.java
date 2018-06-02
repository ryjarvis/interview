package math;

/**
 * @author: ryjarvis
 * Jan 5, 2018
 * 
 */
//LeetCode #171
public class ExcelSheetColumnNumber {
	
    public static int titleToNumberOriginal(String s) {
        int mod=1;
        int res=0;
        for(int i=s.length()-1;i>=0;i--){      	
        	int m=(s.charAt(i)-'A')+1;
        	res+=m*mod;
        	mod*=26;
        }
        return res;
    }
    //when ever you need to go over the string chars make a char array and then do it
    //it leads to a better performance
    public static int titleToNumber(String s){
    	int mod=1;
    	int res=0;
    	char[]c=s.toCharArray();
    	for(int i=c.length-1;i>=0;i--){
    		int m=c[i]-'A'+1;
    		res+=m*mod;
    		mod*=26;
    	}
    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=titleToNumber("BST");
		System.out.println(res);

	}

}


