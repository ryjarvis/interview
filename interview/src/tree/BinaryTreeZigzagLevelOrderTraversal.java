package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ryjarvis Dec 25, 2017
 * 
 */
// LeetCode #103
public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			this.val = x;
		}
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>>res=new ArrayList<>();
		Set<TreeNode> set=new HashSet<TreeNode>();
		Set<TreeNode> temp=new HashSet<TreeNode>();
		int level=1;
		set.add(root);
		while(!set.isEmpty()){
			temp=new HashSet<>();
			List<Integer> l=new ArrayList<>();
			for(TreeNode t:set){
				if(level%2==1){
					l.add(t.val);
				}
				else{
					l.add(0, t.val);
				}
				if(t.left!=null){
					temp.add(t.left);
				}
				if(t.right!=null){
					temp.add(t.right);
				}				
			}
			res.add(l);
			temp=set;
			level++;			
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
