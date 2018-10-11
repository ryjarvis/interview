package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Jan 24, 2018
 * 
 */
//LeetCode #236
public class LowestCommonAncestorOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){val=x;}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null||p==null||q==null)return null;
        List<TreeNode> path1=new ArrayList<>();
        List<TreeNode> path2=new ArrayList<>();
        boolean first=pathFromRoot(root,p,path1);
        if(!first) return null;
        boolean second=pathFromRoot(root,q,path2);
        if(!second) return null;
        int pos=0;
        for(int i=0;i<path1.size();i++){
        	if(path1.get(i)==q) return q;
        	if(path2.get(i)==p) return p;
        	if(path1.get(i)!=path2.get(i)){
        		pos=i;
        		break;
        	}
        }
        return path1.get(pos-1);
        
    }
    
    public boolean pathFromRoot(TreeNode root, TreeNode t,List<TreeNode> path){
    	if(root==null){
    		return false;
    	}
    	
    	path.add(root);
    	if(root==t){
    		return true;
    	}
    	boolean left=pathFromRoot(root.left,t,path);
    	if(!left){
    		boolean right=pathFromRoot(root.right,t,path);
    		if(right){
    			return true;
    		}
    	}
    	else{
    		return true;
    	}
    	path.remove(path.indexOf(root));
    	return false;
    }
    
    public TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode A, TreeNode B) {
        if(root==A||root==B||root==null){
           return root;
       }
       TreeNode left=lowestCommonAncestor(root.left,  A, B);
       TreeNode right=lowestCommonAncestor(root.right,  A, B);
       if(right!=null&&left!=null){
           return root;
       }
       else if(left!=null&&right==null){
           return left;
       }
       else{
           return right;
       }
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


