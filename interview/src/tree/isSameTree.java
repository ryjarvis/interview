package tree;

/**
 * @author: ryjarvis
 * Dec 24, 2017
 * 
 */

public class isSameTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){this.val=x;}
	}
	//LeetCode #100
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        else if(p==null&&q!=null||q==null&&p!=null||p.val!=q.val){
            return false;
        }
        else{
            return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
        }
                
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


