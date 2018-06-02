package tree;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ryjarvis
 * Feb 20, 2018
 * 
 */

public class CourseScheduleII {
 
	//Learn this technique of array of array
	//List<Integer>[] adj=(List<Integer>[])List[num];
	public int[] findOrder(int num, int[][] p) {
		if(num==0){
			return null;
		}
		int[] res=new int[num];
		List<Integer>[] adj=(List<Integer>[])new List[num];
		getAdjacencyList(p,adj);
		Set<Integer> visited=new LinkedHashSet<>();
		boolean[] onStack=new boolean[num];
		for(int i=0;i<num;i++){
			if(visited.contains(i)){
				continue;
			}
			if(dfs(i,adj,onStack,visited)){
				continue;
			}
			else{
				return null;
			}
		}
		int i=num-1;
		visited.forEach((key)->{
			res[i--]=key;
		});
		return res;
		
    } 
	
	public void getAdjacencyList(int [][]p,List<Integer>[] adj){
		for(int[]ar:p){
			adj[ar[1]].add(ar[0]);
		}
	}
	
	public boolean dfs(int root,List<Integer>[] adj,boolean[] onStack,Set<Integer>visited){
		if(onStack[root]&&!visited.contains(root)){
			return false;
		}
		onStack[root]=true;
		for(int i:adj[root]){
			if(dfs(i,adj,onStack,visited)){
				continue;
			}
			else{
				return false;
			}
		}
		visited.add(root);
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
