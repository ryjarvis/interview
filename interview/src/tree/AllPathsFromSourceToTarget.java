package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * May 14, 2018
 * 
 */
//LeetCode #797
public class AllPathsFromSourceToTarget {
	
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>list=new ArrayList<>();
        list.add(0);
        List<List<Integer>> res=new ArrayList<>();
        dfs(0, graph, list, res);
        return res;
    }
    
    public void dfs(int num,int[][]g,List<Integer> list,List<List<Integer>> res){
        if(num==g.length-1){
        	res.add(new ArrayList<Integer>(list));
        }
        for(int val:g[num]){
        	List<Integer> temp=new ArrayList<>(list);
        	temp.add(val);
        	dfs(val, g, temp, res);
        }
    }
    //improved version this algorithm works in O(n!)
    public List<List<Integer>> allPathsSourceTargetOptimized(int[][] graph) {
        List<Integer>list=new ArrayList<>();
        list.add(0);
        List<List<Integer>> res=new ArrayList<>();
        dfs(0, graph, list, res,graph.length-1);
        return res;
    }
    
    public void dfs(int num,int[][]g,List<Integer> list,List<List<Integer>> res,int end){
        if(num==end){
        	res.add(new ArrayList<Integer>(list));
        }
        for(int val:g[num]){
        	list.add(val);
        	dfs(val, g, list, res,end);
            list.remove(list.size()-1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


