package tree;

/**
 * @author: ryjarvis
 * Dec 3, 2017
 * 
 */
//LeetCode #98
public class ValidateBinarySearchTree {
	static TreeNode prev;
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){this.val=x;}
	}
	//first method not optimized O(n^2) time
	public static boolean isValidBSTVersion1(TreeNode root){
		if(root==null){
			return true;
		}
		if(maxSubTree(root.left)<root.val&&minSubTree(root.right)>root.val){
			return isValidBSTVersion1(root.left)&&isValidBSTVersion1(root.right);
		}
		return false;		
	}
	
	public static long maxSubTree(TreeNode root){
		if(root==null){
			return Integer.MIN_VALUE-1;
		}
		return Math.max(Math.max(maxSubTree(root.left), maxSubTree(root.right)), root.val);
	}
	
	public static long minSubTree(TreeNode root){
		if(root==null){
			return Integer.MAX_VALUE+1;
		}
		return Math.min(Math.min(minSubTree(root.left),minSubTree(root.right)),root.val);
	}
	//efficient O(N) method
	public static boolean isValidBSTVersion2(TreeNode root){
		return isValid(root,(long)Integer.MIN_VALUE-1,(long)Integer.MAX_VALUE+1);
	}
	
	public static boolean isValid(TreeNode root,long min,long max){
		if(root==null){
			return true;
		}
		if(root.val>min&&root.val<max){
			return isValid(root.left,min,root.val)&&isValid(root.right,root.val,max);
		}
		return false;
	}
	//efficient inorder traversal method
	public static boolean isValidBST(TreeNode root){
		if(root==null){
			return true;
		}
		isValidBST(root.left);
		if(prev!=null&&root.val<=prev.val){
			return false;
		}
		prev=root;
		isValidBST(root.right);
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


