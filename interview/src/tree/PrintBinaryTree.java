package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {
	public class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int heightCalculator(TreeNode root) {
		if (root != null) {
			return Math.max(heightCalculator(root.left), heightCalculator(root.right)) + 1;
		} else {
			return 0;
		}
	}
	
	TreeNode root;
	public void init(){
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
	}

	public static List<List<String>> printTree(TreeNode root) {
		
		int n=heightCalculator(root);
		List<List<String>> stringTree=new ArrayList<List<String>>(n);
		//List<String> stringLevel=new ArrayList<String>((int) (Math.pow(2,n)-1));
		int rootPosition=(int)Math.pow(2, n-1);
		Queue<Object> nodeQueue=new LinkedList<Object>();
		nodeQueue.add(root);
		nodeQueue.add(new Integer(1));
		nodeQueue.add(new Integer(0));
		nodeQueue.add(new Integer((int)Math.pow(2,n)));
		nodeQueue.add(new Integer(rootPosition));

		for(int i=0;i<n;i++){
			List<String> stringLevel=new ArrayList<String>((int) (Math.pow(2,n)-1));
			for(int j=0;j<Math.pow(2,n)-1;j++){
				stringLevel.add(new String(""));
			}
			stringTree.add(stringLevel);
		}
		while(!nodeQueue.isEmpty()){
			TreeNode parentNode=(TreeNode)nodeQueue.poll();

			Integer parentLevel=(Integer)nodeQueue.poll();
			Integer parentMin=(Integer)nodeQueue.poll();
			Integer parentMax=(Integer)nodeQueue.poll();
			Integer parentPosition=(Integer)nodeQueue.poll();
			stringTree.get(parentLevel-1).set(parentPosition-1, String.valueOf(parentNode.val));
			if(parentNode.left!=null){
				nodeQueue.add(parentNode.left);
				nodeQueue.add(parentLevel+1);
				nodeQueue.add(parentMin);
				nodeQueue.add(parentPosition);
				nodeQueue.add(new Integer((int)(parentMin+parentPosition)/2));
				
				
				//Integer leftLevel=parentLevel+1;
				/*if(parentPosition>rootPosition){
					nodeQueue.add((Integer)(parentPosition+rootPosition)/2);
					nodeQueue.add(leftLevel);
				}
				else{
					nodeQueue.add((Integer)(parentPosition)/2);
					nodeQueue.add(leftLevel);
				}*/
				/*nodeQueue.add(parentMin);
				nodeQueue.add((Integer)parentPosition);*/
			}
			if(parentNode.right!=null){
				nodeQueue.add(parentNode.right);
				nodeQueue.add(parentLevel+1);
				nodeQueue.add(parentPosition);
				nodeQueue.add(parentMax);
				nodeQueue.add(new Integer((int)(parentMax+parentPosition)/2));
				/*nodeQueue.add(parentNode.right);
				Integer rightLevel=parentLevel+1;
				if(parentPosition>=rootPosition){
					nodeQueue.add((Integer)((int)Math.pow(2, n)+parentPosition)/2);
					nodeQueue.add(rightLevel);
				}
				else{
					nodeQueue.add((Integer)(rootPosition+parentPosition)/2);
					nodeQueue.add(rightLevel);
				}*/
				
			}
			
		}
		
		return stringTree;
		
	}
	
	public static void main(String[] args){
		PrintBinaryTree bt=new PrintBinaryTree();
		bt.init();
		List<List<String>> ls=printTree(bt.root);
		for (List<String> l1 : ls) {
			   for (String s : l1) {
			       System.out.print(s+","); 
			   }

			   System.out.println();
			} 
		
		
	}

}
