package string;

/**
 * @author: ryjarvis
 * Apr 24, 2018
 * 
 */
//LeetCode #520
public class DetectCapital {
	
    public boolean detectCapitalUse(String w) {
        int count=0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i)-'A'<=25){
                count++;
            }                         
        }
        if(count==0||count==w.length()||(count==1)&&(w.charAt(0)-'A')<=25){
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


