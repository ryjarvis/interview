package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//LintCode #624

/*You are given a string S and a set of n substrings. You are supposed to remove every instance of those n substrings from S so that S is of the minimum length and output this minimum length. 
Eg: 
S- ccdaabcdbb 
n=2 - substrings-- ab, cd 
Output: 2 
Explanation: 
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length=2) */
//note that this is a backtrack question but since string by default 
//is immutable we dont need to implicitly backtrack
public class RemoveSubstrings {

	public static int minLength(String s, Set<String> dict) {
		Queue<String> q = new LinkedList<>();
		Set<String> seen = new HashSet<>();
		q.add(s);
		seen.add(s);
		int min = s.length();
		while (!q.isEmpty()) {
			String st = q.poll();
			for (String sub : dict) {
				int idx = st.indexOf(sub);
				while (idx != -1) {
					String newStr = st.substring(0, idx) + st.substring(idx + sub.length(), st.length());
					if(!seen.contains(newStr)){
						if(newStr.length()<min){
							min=newStr.length();
						}
						q.add(newStr);
						seen.add(newStr);
					}
					idx=st.indexOf(sub,idx+1);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
