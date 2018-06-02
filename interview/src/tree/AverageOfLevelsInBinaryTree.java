package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: ryjarvis Apr 23, 2018
 * 
 */
// LeetCode #637
public class AverageOfLevelsInBinaryTree {
	// first solution is DFS
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x) {
			this.val = x;
		}
	}

	class Node {
		long sum;
		int count;

		public Node(int s, int c) {
			sum = s;
			count = c;
		}
	}

	public List<Double> averageOfLevelsDFS(TreeNode root) {
		List<Double> res = new ArrayList<>();
		List<Node> l = new ArrayList<>();
		dfs(0, root, l);
		for (int i = 0; i < l.size(); i++) {
			res.add((double) l.get(i).sum / (double) l.get(i).count);
		}
		return res;
	}

	public void dfs(int level, TreeNode t, List<Node> l) {
		if (t == null)
			return;
		if (level == l.size()) {
			l.add(new Node(t.val, 1));
		} else {
			l.get(level).count++;
			l.get(level).sum += t.val;
		}
		dfs(level + 1, t.left, l);
		dfs(level + 1, t.right, l);
	}
	//BFS solution
	public List<Double> averageOfLevelsBFS(TreeNode root) {
		List<Double> res = new ArrayList<>(); 
		if(root==null) return res;
		Queue<TreeNode>q=new LinkedList<>();
		q.add(root);
		long sum=0;
		int count=0;
		while(!q.isEmpty()){
			count=q.size();
			sum=0;
			for(int i=0;i<count;i++){
				TreeNode node=q.poll();
				if(node.left!=null){
					q.add(node.left);
				}
				if(node.right!=null){
					q.add(node.right);
				}
				sum+=node.val;
			}
			res.add((double)sum/count);
			
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
