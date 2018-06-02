package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Feb 20, 2018
 * 
 */
//Solution to the topological sorting
public class CourseSchedule {
	
	 public static boolean canFinish(int numCourses, int[][] pre) {
	    	List<Integer>[] adj=(List<Integer>[])new List[numCourses];
	    	boolean[] ancestor=new boolean[numCourses];
	    	boolean[] visited=new boolean[numCourses];
	    	boolean possible=true;
	        for(int i=0;i<pre.length;i++){
	        		if(adj[pre[i][0]]==null){
	        			adj[pre[i][0]]=new ArrayList<Integer>();
	        		}
	        		adj[pre[i][0]].add(pre[i][1]);
	        }
	        for(int i=0;i<numCourses;i++){
	        	if(!visited[i]){
	        		if(!dfs(visited,ancestor,adj,i)){
	        			possible=false;
	        			break;
	        		}
	        	}
	        }
	        return possible;
	    }
	    
	    public static boolean dfs(boolean[]visited,boolean[] ancestor,List<Integer>[]adj,int cur){
	        if(adj[cur]==null||adj[cur].isEmpty()){
	            return true;
	        }
	    	ancestor[cur]=true;
	    	for(int i:adj[cur]){
	            if(ancestor[i]){
	                return false;
	            }
	    		if(!visited[i]){
	    			visited[i]=true;
	    			if(!dfs(visited,ancestor,adj,i)){
	    				return false;
	    			}
	    		}    		
	    	}
	    	ancestor[cur]=false;
	    	
	    	return true;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


