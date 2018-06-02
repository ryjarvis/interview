package tree;
import java.util.List;
import java.util.ArrayList;


/**
 * @author: ryjarvis
 * Dec 1, 2017
 * 
 */
//LeetCode #94
public class BinaryTreeInorderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val=val;
		}
	}
    public static List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> res=new ArrayList<Integer>();
        inorderHelper(res,root);
        return res;
        
    }
    public static void inorderHelper(List<Integer>res, TreeNode root){
        if(root==null){
            return;
        }
        inorderHelper(res,root.left);
        res.add(root.val);
        inorderHelper(res,root.right);       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


