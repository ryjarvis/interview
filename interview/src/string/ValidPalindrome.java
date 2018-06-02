package string;

/**
 * @author: ryjarvis
 * Dec 17, 2017
 * 
 */
//LeetCode #125
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String clean=s.replaceAll("[^A-Za-z0-9]", "");
        int i=0;
        int j=clean.length()-1;
        while(i<j){
        	int lo;
        	int hi;
        	lo=clean.charAt(i)-'A'>25?clean.charAt(i)-'a':clean.charAt(i)-'A';
        	hi=clean.charAt(j)-'A'>25?clean.charAt(j)-'a':clean.charAt(j)-'A';
        	if(lo!=hi){
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="A man, a plan, a canal: Panama 9";
		isPalindrome(s);
	}

}


