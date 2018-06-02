package string;

//LeetCode #
public class ImplementStrStr {
	
    public static int strStr(String haystack, String needle) {
        int size=needle.length();
        int end=size-1;
        int start=0;
        if(needle.length()==0){
        	return 0;
        }
        if(haystack.length()==0||needle.length()>haystack.length()){
        	return -1;
        }
        while(start+end<haystack.length()){
        	if(haystack.charAt(start)==needle.charAt(0)){
        		if(haystack.substring(start, start+size).equals(needle)){
        			return start;
        		}
        	}
        	else{
        		start++;
        	}
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
