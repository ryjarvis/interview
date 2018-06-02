package tree;

/**
 * @author: ryjarvis
 * Jan 24, 2018
 * 
 */
//LeetCode #235
public class LowestCommonAncestorOfBinarySearchTree {
	
	public class TreeNode{
		int val;
		TreeNode right;
		TreeNode left;
		TreeNode (int x){val=x;}
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>=Math.min(p.val,q.val)&&root.val<=Math.max(p.val,q.val)){
            return root;
        }
        else if(root.val<Math.min(p.val,q.val)){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return lowestCommonAncestor(root.left,p,q);
        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


