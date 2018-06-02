package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author: ryjarvis
 * Feb 20, 2018
 * 
 */

public class CourseScheduleII {
 
	//Learn this technique of array of array
	//List<Integer>[] adj=(List<Integer>[])List[num];
	public static int[] findOrder(int numCourses, int[][] pre) {
		Set<Integer> interim = new HashSet<>();
		Set<Integer> seen = new HashSet<>();
		Set<Integer> finished = new HashSet<>();
		int[]result=new int[numCourses];
		Stack<Integer> st = new Stack<>();
		List<Integer>[]preq=helper(pre, numCourses);
		for (int i = 0; i < numCourses; i++) {
			if(seen.contains(i)){
				continue;
			}
			seen.add(i);
			interim.add(i);
			boolean res=dfs(preq,i,interim,finished,seen,st);
			if(!res){
				return new int[]{};
			}
		}
		int i=0;
		while(!st.isEmpty()){
			result[i++]=st.pop();
		}
		return result;
	}

	public static boolean dfs(List<Integer>[] pre, int idx, Set<Integer> interim,
			Set<Integer> finished, Set<Integer> seen, Stack<Integer> st) {
		if(pre[idx]==null){
			finished.add(idx);
			interim.remove(idx);
			st.push(idx);
			return true;
		}
		for (int i = 0; i < pre[idx].size(); i++) {
			if (seen.contains(pre[idx].get(i))) {
				if (interim.contains(pre[idx].get(i))) {
					return false;
				} else {
					continue;
				}
			} else {
				seen.add(pre[idx].get(i));
				interim.add(pre[idx].get(i));
				boolean res = dfs(pre, pre[idx].get(i), interim, finished, seen, st);
				if (!res) {
					return false;
				}
			}
		}
		interim.remove(idx);
		finished.add(idx);
		st.push(idx);
		return true;
	}
	
	public static List<Integer>[] helper(int[][]pre,int num){
		List<Integer>[] res=(List<Integer>[])new List[num];
		for(int i=0;i<pre.length;i++){
			if(res[pre[i][1]]==null){
				res[pre[i][1]]=new ArrayList<>();
			}
			res[pre[i][1]].add(pre[i][0]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
