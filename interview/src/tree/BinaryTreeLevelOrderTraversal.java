package tree;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @author: ryjarvis
 * Dec 5, 2017
 * 
 */
//LeetCode #102
public class BinaryTreeLevelOrderTraversal {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){this.val=x;}
	}
	//Not optimized
	public static List<List<Integer>> levelOrderSubOptimal(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null){
			return res;
		}		
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		Queue<TreeNode> next=new LinkedList<TreeNode>();
		List<Integer> temp=new ArrayList<Integer>();
		temp.add(root.val);
		res.add(temp);
		next.add(root);
		while(!next.isEmpty()){
			q.addAll(next);
			next=new LinkedList<TreeNode>();
			temp=new ArrayList<>();
			while(!q.isEmpty()){

				TreeNode node=q.poll();
				if(node.left!=null){
					temp.add(node.left.val);
					next.add(node.left);
				}
				if(node.right!=null){
					temp.add(node.right.val);
					next.add(node.right);
				}
			}
			if(!temp.isEmpty()){
				res.add(temp);
			}			
		}
		return res;
		
	}
	//much cleaner O(n) solution BFS approach with queue
	public static List<List<Integer>> levelOrder(TreeNode root){
		Queue<TreeNode> q=new LinkedList<>();
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		q.add(root);
		while(!q.isEmpty()){
			int size=q.size();
			List<Integer> temp=new ArrayList<>();
			for(int i=0;i<size;i++){
				if(q.peek().left!=null) q.add(q.peek().left);
				if(q.peek().right!=null)q.add(q.peek().right);
				temp.add(q.poll().val);
			}
			res.add(temp);
		}
		return res;
	}
	//Interesting recursive solution with O(1) space not considering recursive call stack
	public static List<List<Integer>> levelOrderRec(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		levelOrderHelper(root,0,res);
		return res;
	}
	
	public static void levelOrderHelper(TreeNode root,int level,List<List<Integer>>res){
		if(root==null)return;
		if(level==res.size()){
			res.add(new ArrayList<Integer>());
		}
		res.get(level).add(root.val);
		levelOrderHelper(root.left,level+1,res);
		levelOrderHelper(root.right,level+1,res);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal bt=new BinaryTreeLevelOrderTraversal();
		TreeNode node=bt.new TreeNode(1);
		node.left=bt.new TreeNode(2);
		node.right=bt.new TreeNode(3);
		node.left.left=bt.new TreeNode(4);
		node.left.right=bt.new TreeNode(5);
		List<List<Integer>> res=levelOrder(node);		
	}

}


