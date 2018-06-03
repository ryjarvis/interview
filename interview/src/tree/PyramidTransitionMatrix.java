package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ryjarvis Jun 2, 2018
 * 
 */
// LeetCode 756
public class PyramidTransitionMatrix {
	// this question can be solved using dfs
	//O(A^n) A is the alphabet size and n is the bottom length
	public static boolean pyramidTransition(String bottom, List<String> allowed) {
		Map<String, List<Character>> map = new HashMap<>();
		for (String s : allowed) {
			if (!map.containsKey(s.substring(0, 2))) {
				map.put(s.substring(0, 2), new ArrayList<Character>());
			}
			map.get(s.substring(0, 2)).add(s.charAt(2));
		}
		return dfs(map, bottom);
	}

	public static boolean dfs(Map<String, List<Character>> map, String bottom) {
		if (bottom.length() == 1) {
			return true;
		}
		List<String> res = new ArrayList<>();
		getList(map, "", bottom, res);
		if (res.size() == 0) {
			return false;
		}
		for (String st : res) {
			if (dfs(map, st)) {
				return true;
			}
		}
		return false;

	}

	public static void getList(Map<String, List<Character>> map, String cur, String bottom, List<String> res) {
		if (cur.length() == bottom.length() - 1) {
			res.add(cur);
			return;
		}
		int i = cur.length();
		List<Character> key = map.get(bottom.substring(i, i + 2));
		if (key==null)
			return;
		for (char c : key) {
			getList(map, new String(cur + c), bottom, res);
		}

	}
	
	//another way of solving this using bit manipulation to hold the values
	public boolean pyramidTransitionBitManipulation(String bottom,List<String>allowed){
		int[][]t=new int[7][7];
		//this set is only used for cache purpose to avoid checking similar rows
		Set<Long> seen=new HashSet<>();
		int n=bottom.length();
		for(String s:allowed){
			t[s.charAt(0)-'A'][s.charAt(1)-'A']|=s.charAt(2)-'A'<<1;
		}
		return dfs(t,bottom.toCharArray(),new char[n],0,n-1);
	}
	
	public boolean dfs(int[][]t,char[]cur,char[]next,int i,int level){
		if(level==1) return true;
		if(i==cur.length-1) return dfs(t,next,new char[level],0,level-1);
		int bit=t[cur[i]-'A'][cur[i+1]-'A'];
		for(int j=0;j<7;j++){
			if((bit>>j&1)!=0){
				next[i]=(char)(j+'A');
				if(dfs(t,cur,next,i+1,level)){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bottom = "XXYX";
		String[] ar = { "XXX", "XXY", "XYX", "XYY", "YXZ" };
		List<String> allowed = Arrays.asList(ar);
		pyramidTransition(bottom, allowed);

	}

}
