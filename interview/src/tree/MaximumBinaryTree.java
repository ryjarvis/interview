package tree;

/**
 * @author: ryjarvis Apr 25, 2018
 * 
 */
// LeetCode #654
public class MaximumBinaryTree {
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		public TreeNode(int x) {
			val = x;
		}
	}

	// This is a Nlog(n) solution at best and N^2 at worst it depends where
	// partition occurs
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return helper(0, nums.length - 1, nums);
	}

	public int max(int l, int r, int[] nums) {
		if (l == r)
			return l;
		int idx = 0;
		int max = Integer.MIN_VALUE;
		for (int i = l; i <= r; i++) {
			if (nums[i] > max) {
				idx = i;
				max = nums[i];
			}
		}
		return idx;
	}

	public TreeNode helper(int l, int r, int[] nums) {
		if (l > r)
			return null;
		int id = max(l, r, nums);
		TreeNode t = new TreeNode(nums[id]);
		t.left = helper(l, id - 1, nums);
		t.right = helper(id + 1, r, nums);
		return t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		MaximumBinaryTree mb = new MaximumBinaryTree();
		TreeNode res = mb.constructMaximumBinaryTree(nums);

	}

}
