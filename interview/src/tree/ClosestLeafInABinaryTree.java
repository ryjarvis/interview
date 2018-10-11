package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LeetCode #742
public class ClosestLeafInABinaryTree {
	//since its only 1000 nodes we can use array for lookup instead of map
	 public static int findClosestLeaf(TreeNode root, int k) {
		 final int SIZE=1000;
		 List []map=new List[SIZE];
		 map[root.val]=new ArrayList<>();
		 map[root.val].add(-1);
		 buildGraph(map,root);
		 Queue<Integer> q=new LinkedList<>();
		 boolean[]seen=new boolean[SIZE];
		 q.add(k);
		 seen[k]=true;
		 while(!q.isEmpty()){
			 Queue<Integer>aux=new LinkedList<>();
			 while(!q.isEmpty()){
				 int top=q.poll();
				 if(map[top].size()==1){
					 return top;
				 }
				 for(int i=0;i<map[top].size();i++){
					 int val=(int) map[top].get(i);
					 if(!seen[val]){
						 aux.add(val);
						 seen[val]=true;
					 }
				 }
			 }
			 q=aux;
		 }
		 return -1;
	 }
	 
	 public static void buildGraph(List[]map,TreeNode node){
		 if(node.left!=null){
			 map[node.val].add(node.left.val);
			 map[node.left.val]=new ArrayList<>();
			 map[node.left.val].add(node.val);
			 buildGraph(map,node.left);
		 }
		 if(node.right!=null){
			 map[node.val].add(node.right.val);
			 map[node.right.val]=new ArrayList<>();
			 map[node.right.val].add(node.val);
			 buildGraph(map,node.right);
		 }
	 }
	 
	 public int findClosestLeafBuggy(TreeNode root, int k) {
	        // Write your code here
	        if(root==null){
	            return 0;
	        }
	       int[] p= helper(root,0);
	       System.out.println(p[0]);
	       if(root.val==k){
	           return p[0];
	       }
	        p[1]++;
	       int[]res=new int[]{-1,-1};
	       int []result=helper(root.left,p,k,res);
	       if(result[0]==-1){
	           result=helper(root.right,p,k,res);
	       }
	       return result[0];
	    }
	    
	    public int[] helper(TreeNode node,int[]p,int k,int[]res){
	        if(node==null){
	            return new int[]{-1,-1};
	        }
	        
	        if(node.val==k){
	            int[]aux=helper(node,0);
	            
	            if(p[1]>aux[1]){
	                res=Arrays.copyOf(aux,2);
	                return aux;
	            }
	            else{
	                res=Arrays.copyOf(p,2);
	                return p;
	               
	            }
	        }
	        int[]l=helper(node.left,new int[]{p[0],p[1]+1},k,res);
	        if(l[0]==-1){
	           return helper(node.right,new int[]{p[0],p[1]+1},k,res);
	        }
	        else{
	            return l;
	        }

	    }
	        
	    
	    
	    public int[] helper(TreeNode root,int val){
	        if(root.left==null&&root.right==null){
	            return new int[]{root.val,val};
	        }
	        int[]left=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
	        int[]right=new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
	        if(root.left!=null){
	            left=helper(root.left,val+1);
	        }
	        if(root.right!=null){
	            right=helper(root.right,val+1);
	        }
	        
	        return left[1]<=right[1]?left:right;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		findClosestLeaf(root,2);
	}

}
