package string;

/**
 * @author: ryjarvis
 * Apr 28, 2018
 * 
 */
//LeetCode #796
public class RotateString {
	
    public boolean rotateString(String s, String b) {
        if(s.length()!=b.length()) return false;
        if(s.equals(b)) return true;
        StringBuilder sb=new StringBuilder();
        sb.append(s);
        sb.append(s);
        String t=sb.toString();
        if(t.contains(b)) return true;
        else return false;       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


