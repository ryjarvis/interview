package string;

/**
 * @author: ryjarvis
 * May 2, 2018
 * 
 */
//LeetCode #537
public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String m, String n) {
        String[]ap=m.split("\\+");
        String[]bp=n.split("\\+");
        int a=Integer.valueOf(ap[0]);
        int b=Integer.valueOf(ap[1].substring(0,ap[1].length()-1));
        int c=Integer.valueOf(bp[0]);
        int d=Integer.valueOf(bp[1].substring(0,bp[1].length()-1));
        int g=(a*c)-(b*d);
        int h=(b*c)+(a*d);
        return g+"+"+h+"i";  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


