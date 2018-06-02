package tree;

/**
 * @author: ryjarvis
 * Apr 24, 2018
 * 
 */
//LeetCode #513
public class FindBottomLeftTreeValue {
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			this.val=x;
		}
	}
    public int findBottomLeftValue(TreeNode root) {
        int[]res=new int[2];
        res[0]=0;
        res[1]=root.val;
        helper(0,res,root);
        return res[1];
        
    }
    //here you keep the level of the max so far seen on the left array
    public void helper(int level,int[]left,TreeNode t){
        if(t==null) return;
        if(level>left[0]){
            left[1]=t.val;
            left[0]=level;
        }
        helper(level+1,left,t.left);
        helper(level+1,left,t.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


