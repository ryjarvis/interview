package tree;

/**
 * @author: ryjarvis Mar 18, 2018
 * 
 */
// LeetCode #124

public class BinaryTreeMaximumPathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	public class Tuple {
		int max;
		boolean isConsistOfRoot;

		public Tuple(int x, boolean isRoot) {
			max = x;
			isConsistOfRoot = isRoot;
		}
	}

	public int maxPathSum(TreeNode root) {
		return sum(root, 0).max;
	}

	public Tuple sum(TreeNode cur, int parent){
	        if(cur==null) return new Tuple(Integer.MIN_VALUE,false);
	        return Math.max(sum)
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
