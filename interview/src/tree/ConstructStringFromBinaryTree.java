package tree;

/**
 * @author: ryjarvis Apr 23, 2018
 * 
 */
// LeetCode #606
public class ConstructStringFromBinaryTree {
	
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			this.val=x;
		}
	}
	public String tree2str(TreeNode t) {
		if (t == null)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append(t.val);
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		if (left == "" && right == "") {
			return sb.toString();
		}
		if (right == "") {
			sb.append("(");
			sb.append(left);
			sb.append(")");
			return sb.toString();
		}
		sb.append("(");
		sb.append(left);
		sb.append(")");
		sb.append("(");
		sb.append(right);
		sb.append(")");
		return sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
