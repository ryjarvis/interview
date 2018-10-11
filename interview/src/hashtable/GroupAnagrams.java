package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//LeetCode #49
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		int pos = 0;
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!map.containsKey(key)) {
				map.put(key, pos++);
				List<String> list = new ArrayList<String>();
				list.add(s);
				res.add(list);
			} else {
				res.get(map.get(key)).add(s);
			}

		}
		return res;
	}

	// interesting idea using hash code not sort
	public static List<List<String>> groupAnagramsImproved(String[] strs) {
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };

		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}
	
    public static List<List<String>> groupAnagramsTest(String[] strs) {
        // write your code here
        List<List<String>> res=new ArrayList<>();
        Map<String,Integer>map=new HashMap<>();
        for(String s:strs){
                char[]c=s.toCharArray();
                Arrays.sort(c);
                String key=String.valueOf(c);
                Integer val=map.get(key);
                if(val==null){
                    map.put(key,res.size());
                    List<String> list=new ArrayList<>();
                    list.add(s);
                    res.add(list);
                }
                else{
                    res.get(val).add(s);
                }
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]strs={"",""};
		List<List<String>>res=groupAnagramsTest(strs);
		List<List<String>>res2=groupAnagrams(strs);
	}

}
