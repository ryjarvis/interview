package string;

/**
 * @author: ryjarvis
 * May 14, 2018
 * 
 */
//LeetCode #791
public class CustomSortString {
	//O(n)
    public String customSortString(String S, String T) {
        boolean[] count=new boolean[26];
        int[] arr=new int[26];
        for(char c:S.toCharArray()){
            count[c-'a']=true;
        }
        StringBuilder sb=new StringBuilder();      
        for(char c:T.toCharArray()){
            if(!count[c-'a']){
                sb.append(c);
            }
            else{
                arr[c-'a']++;
            }
        }
        for(char c:S.toCharArray()){
            for(int i=0;i<arr[c-'a'];i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


