package tree;

/**
 * @author: ryjarvis
 * Apr 20, 2018
 * 
 */
//LeetCode #437
public class PathSumIII {
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			val=x;
		}
	}
    public static int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return sum(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);    
    }
    
    public static int sum(TreeNode t, int sum){
        if(t==null) return 0;      
        return  (t.val==sum?1:0)+ sum(t.left,sum-t.val)+sum(t.right,sum-t.val);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


