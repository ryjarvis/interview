package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: ryjarvis Apr 30, 2018
 * 
 */
// LeetCode #819
public class MostCommonWord {

	public String mostCommonWord(String p, String[] banned) {
		String s = p.replaceAll("[!?',;.]", "").toLowerCase();
		Set<String> set = new HashSet<>();
		for (String st : banned) {
			set.add(st);
		}
		String[] sp = s.split("\\s");
		String maxSt = "";
		int max = 0;

		Map<String, Integer> map = new HashMap<>();
		for (String str : sp) {
			if (set.contains(str)) {
				continue;
			}
			Integer val = map.get(str);
			if (val == null) {
				val = 0;
			}
			map.put(str, val + 1);
			if(val+1>max){
				max=val+1;
				maxSt=str;
			}
		}
		return maxSt;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
