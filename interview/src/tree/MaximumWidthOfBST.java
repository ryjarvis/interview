package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LeetCode 662. Maximum Width of Binary Tree
public class MaximumWidthOfBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode root;

	public void init() {
		root = new TreeNode(1);
		root.left = new TreeNode(3);
		//root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		// root.right.left=new TreeNode(6);
		//root.right.right = new TreeNode(9);
	}

	// Timeout solution but correct
	public int widthOfBinaryTree2(TreeNode root) {
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		TreeNode currentNode;
		int minIdx;
		int maxIdx;
		int localMax;
		if (root != null) {
			int level = 0;
			int max = 1;
			nodeQueue.add(root);
			localMax = 1;
			while (localMax > 0) {
				maxIdx = Integer.MIN_VALUE;
				minIdx = Integer.MAX_VALUE;
				for (int i = 0; i < Math.pow(2, level); i++) {
					currentNode = nodeQueue.poll();
					if (currentNode != null) {
						if (currentNode.left != null) {
							minIdx = Math.min(minIdx, 2 * i);
							maxIdx = Math.max(maxIdx, 2 * i);
						}
						if (currentNode.right != null) {
							minIdx = Math.min(minIdx, (2 * i) + 1);
							maxIdx = Math.max(maxIdx, (2 * i) + 1);
						}
						nodeQueue.add(currentNode.left);
						nodeQueue.add(currentNode.right);
					}

					else {
						nodeQueue.add(null);
						nodeQueue.add(null);
					}
				}
				localMax = (maxIdx) < 0 ? -1 : (maxIdx - minIdx) + 1;
				max = Math.max(max, localMax);
				level += 1;
			}
			return max;

		} else {
			return 0;
		}
	}
	//10 ms solution
	public int widthOfBinaryTree(TreeNode root) {
		ArrayDeque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
		ArrayDeque<Integer> posQueue = new ArrayDeque<Integer>();
		if (root == null)
			return 0;
		int max = 1;
		nodeQueue.add(root);
		posQueue.add(1);
		while (!nodeQueue.isEmpty()) {
			int minIdx=0, maxIdx=0;
			int size=nodeQueue.size();
			for (int i = 0; i <size; i++) {
				TreeNode currentNode = nodeQueue.poll();
				int index = posQueue.poll();			
				if (i == 0)
					minIdx = index;
				if (i == size - 1)
					maxIdx = index;
				if (currentNode.left != null) {
					nodeQueue.add(currentNode.left);
					posQueue.add(2 * (index));

				}
				if (currentNode.right != null) {
					nodeQueue.add(currentNode.right);
					posQueue.add(2 * (index) + 1);
				}
			}
			max=Math.max(max, (maxIdx-minIdx)+1);
		}

		return max;

	}
	//recursive solution 9ms
	public int widthOfBinaryTreeRecursive(TreeNode root){
		List<Integer> start=new ArrayList<Integer>();
		List<Integer> end=new ArrayList<Integer>();
		return dfsWidth(root,start,end,1,0);
	}
	public int dfsWidth(TreeNode root,List<Integer> start,List<Integer> end,int parentIdx,int level){
		if(root==null)return 0;
		if(start.size()==level){
			start.add(parentIdx);
			end.add(parentIdx);
		}
		else{
			end.set(level,parentIdx);
		}		
		int cur=end.get(level)-start.get(level)+1;
		int left=dfsWidth(root.left,start,end,2*parentIdx,level+1);
		int right=dfsWidth(root.right,start,end,(2*parentIdx)+1,level+1);
		return Math.max(cur, Math.max(left, right));
	}
	
    public int widthOfBinaryTreeOptimized(TreeNode root) {
        int max=0;
        if(root==null){
            return max;
        }
        Queue<TreeNode> q=new LinkedList<>();
        root.val=1;
        q.add(root);
        int first=0,last=0;
        int oldSize=1;
        while(!q.isEmpty()){
            Queue<TreeNode> aux=new LinkedList<>();
            while(!q.isEmpty()){
                if(q.size()==oldSize){
                    first=q.peek().val;
                }
                TreeNode node=q.poll();

                if(node.left!=null){
                    node.left.val=2*(node.val);
                    aux.add(node.left);
                }
                if(node.right!=null){
                    node.right.val=2*(node.val)+1;
                    aux.add(node.right);
                }
                last=node.val;
            }
            max=Math.max(max,last-first+1);
            q=aux;
            oldSize=q.size();
        }
        
        return max;
    }

	public static void main(String[] args) {
		MaximumWidthOfBST m = new MaximumWidthOfBST();
		m.init();
		int res2 = m.widthOfBinaryTree2(m.root);
		int res = m.widthOfBinaryTree(m.root);
		int res3=m.widthOfBinaryTreeRecursive(m.root);
		System.out.println(res);
		System.out.println(res2);
		System.out.println(res3);

	}

}
