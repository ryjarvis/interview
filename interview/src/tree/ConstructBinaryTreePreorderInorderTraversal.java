package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Dec 27, 2017
 * 
 */
//LeetCode #105
public class ConstructBinaryTreePreorderInorderTraversal {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){val=x;}
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
        	map.put(inorder[i], i);
        }
        if(preorder.length==0||inorder.length==0||preorder.length!=inorder.length){
        	return null;
        }
        return buildHelper(preorder,map,0,inorder.length-1,0);
    }
    
    public TreeNode buildHelper(int[]pre,Map<Integer,Integer>in,int lo,int hi,int next){
    	if(hi<lo){
    		return null;
    	}
    	TreeNode node=new TreeNode(pre[next]);
    	if(lo==hi){
    		return node;
    	}
    	int rank=in.get(node.val);
    	node.left=buildHelper(pre,in,lo,rank-1,next+1);
    	node.right=buildHelper(pre,in,rank+1,hi,next+rank-lo+1);
    	return node;    	
    }
    
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] {0};
        int[] inIndex = new int[] {0};
        return buildTree(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE);
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int[] preIndex, int[] inIndex, int target) {
        //pre: [root][left][right];
        //in: [left][root][right];
        //target is the root
        if (inIndex[0] >= inorder.length || inorder[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        //preorder, advance the index by 1 sice we already finish the root;
        preIndex[0]++;
        root.left = buildTree(preorder, inorder, preIndex, inIndex, root.val);
        //after finishing left subtree, we can advance the index by 1
        inIndex[0]++;
        root.right = buildTree(preorder, inorder, preIndex, inIndex, target);
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


