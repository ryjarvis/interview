package tree;

/**
 * @author: ryjarvis
 * Dec 26, 2017
 * 
 */
//LeetCode #108
public class ConvertSortedArrayToBinarySearchTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){val=x;}
	}
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstBuilder(nums,0,nums.length-1);
    }
    
    public TreeNode bstBuilder(int[]nums,int lo,int hi){
    	if(lo>hi){
    		return null;
    	}
    	TreeNode root=new TreeNode(nums[(hi-lo)/2+lo]);
    	root.left=bstBuilder(nums,lo,(hi-lo)/2+lo-1);
    	root.right=bstBuilder(nums,(hi-lo)/2+lo+1,hi);
    	return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


