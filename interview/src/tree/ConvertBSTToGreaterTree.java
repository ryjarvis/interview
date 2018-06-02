package tree;

/**
 * @author: ryjarvis Mar 23, 2018
 * 
 */
// LeetCode #538
public class ConvertBSTToGreaterTree {
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode convertBST(TreeNode root) {		
		convert(root,0);
		return root;
	}
	
	public static int convert(TreeNode root,int next){
		if(root==null){
			return next;
		}
		int res=convert(root.right,next);
		root.val+=(res);
		int left=convert(root.left,root.val);
		return left==0?root.val:left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
