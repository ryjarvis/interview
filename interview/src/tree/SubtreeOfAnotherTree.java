package tree;

/**
 * @author: ryjarvis
 * Apr 18, 2018
 * 
 */
//LeeCode #572
public class SubtreeOfAnotherTree {
	
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			this.val=x;
		}
	}
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s==null) return false;
		if(isSame(s,t)) return true;
		else{
			return isSubtree(s.left,t)||isSubtree(s.right, t);
		}
	}
	
	public boolean isSame(TreeNode s,TreeNode t){
		if(s==null&&t==null) return true;
		if(s==null||t==null) return false;
		if(s.val!=t.val){
			return false;
		}
		else{
			return isSame(s.left,t.left)&&isSame(s.right,t.right);			
		}			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


