package string;

/**
 * @author: ryjarvis
 * May 1, 2018
 * 
 */
//LeetCode #696
public class CountBinarySubstrings {
	//the idea here is to keep track of all the changes between 0 to 1 each transition we 
	//increment the counter also we increment the counter when the current length of subsequent
	//similar chars are >= of previous ones.
    public static int countBinarySubstrings(String s) {
        int prev=0; int cur=1;
        char before=s.charAt(0);
        int count=0;
        for(int i=1;i<s.length();i++){
        	if(s.charAt(i)==before){     		
        		cur++;
        		if(cur>1&&cur<=prev) count++;
        		continue;
        	}
        	else{             
                before=s.charAt(i);
        		count++;
        		prev=cur;
        		cur=1;
        	}       	
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String s="00110";
		countBinarySubstrings(s);
	}

}


