package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Apr 22, 2018
 * 
 */
//LeetCode #337
public class HouseRobberIII {
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			val=x;
		}
	}
	//this solution is wrong
    public int robWrong(TreeNode root) {
    	if(root==null) return 0;
    	int[]mem=new int[2];
    	if(root.val>0)mem[0]+=root.val;
        dfs(root.left,mem,1);
        dfs(root.right,mem,1);
        return Math.max(mem[0], mem[1]);
    }
    
    public void dfs(TreeNode t,int[]mem,int level){
    	if(t==null) return;
    	if(t.val>0){
        	if(level%2==1){
        		mem[1]+=t.val;
        	}
        	else{
        		mem[0]+=t.val;
        	}
    	}
    	dfs(t.left,mem,level++);
    	dfs(t.right,mem,level++);
    }
    //advanced solution with memorization DP (2ms)
    public int robDP(TreeNode root){
    	if(root==null) return 0;
    	int[] res=robSub(root);
    	return Math.max(res[0], res[1]);
    }
    //here index zero means root not included 1 means included
    public int[]robSub(TreeNode t){
    	if(t==null) return new int[2];
    	int[]res=new int[2];
    	int[]left=robSub(t.left);
    	int[]right=robSub(t.right);
    	res[0]=Math.max(left[0], left[1])+Math.max(right[0], right[1]);
    	res[1]=t.val+left[0]+right[0];
    	return res;  	
    }
    
    //naive solution without memorization
    public int rob(TreeNode root){
        
    	if(root==null) return 0;
    	 int val=0;
    	if(root.left!=null){
    		val+=rob(root.left.left);
    		val+=rob(root.left.right);
    	}
    	if(root.right!=null){
    		val+=rob(root.right.left);
    		val+=rob(root.right.right);
    	}
    	return Math.max(root.val+val, rob(root.left)+rob(root.right));
    }
    //this solution is similar to above solution with memorization of subproblems
    //using hashMap
    public int robUsingMap(TreeNode root){
    	return robMap(root,new HashMap<TreeNode,Integer>());
    }
    
    public int robMap(TreeNode t,Map<TreeNode,Integer>map){
    	if(t==null)return 0;
    	if(map.containsKey(t)){
    		return map.get(t);
    	}
    	int val=0;
    	if(t.left!=null){
    		val+=robMap(t.left.left,map);
    		val+=robMap(t.left.right,map);
    	}
    	if(t.right!=null){
    		val+=robMap(t.right.left,map);
    		val+=robMap(t.right.right,map);
    	}
    	int max=Math.max(t.val+val, robMap(t.left,map)+robMap(t.right,map));
    	map.put(t, max);
    	return max;
    	
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


