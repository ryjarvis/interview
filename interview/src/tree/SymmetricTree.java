package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:*/

public class SymmetricTree {
	public class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x) { val = x; }
	}
	//List<Integer> inOrder=new ArrayList<Integer>();
	Stack<Integer> inOrder=new Stack<Integer>();
	TreeNode root;
	public void init(){
		root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(3);
	}
    
/*    public boolean isSymmetric(TreeNode root) {
        if(root!=null&&(root.left!=null||root.right!=null)){
            Stack<Integer> leftTraversal=inorderTraversal(root.left);
            if(leftTraversal.isEmpty()){
            	return false;
            }
            else{
            	return inorderRightChild(root.right,leftTraversal);
            }
            
        }
        return true;
    }*/
	
	public boolean isSymmetric(TreeNode root){
		if(root==null){
			return true;
		}
		else if(root.left==null && root.right==null){
			return true;
		}
		else if((root.left!=null&&root.right==null)||(root.left==null&&root.right!=null)){
			return false;
		}
		else{
			return isSymmetric(root.left,root.right);
		}
	}
	
	public boolean isSymmetric(TreeNode left,TreeNode right){
		if((left==null&&right!=null)||(left!=null&&right==null)){
			return false;
		}
		else if(left==null&&right==null){
			return true;
		}
		return ((left.val==right.val)&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left));
	}
    public Stack<Integer> inorderTraversal(TreeNode node){
        
	    if(node!=null){
			inorderTraversal(node.left);
			inOrder.push(node.val);
			inorderTraversal(node.right);
		}
        return inOrder;

	}
    
    public boolean inorderRightChild(TreeNode node, Stack<Integer> inOrder){
    	
		if(node!=null){
			inorderRightChild(node.left,inOrder);
			if(!inOrder.isEmpty()&&inOrder.peek()==node.val){
				inOrder.pop();
			}
			else if(inOrder.isEmpty()){
				inOrder.push(-2500);
			}
			inorderRightChild(node.right,inOrder);
		}
		return inOrder.isEmpty();
	}
	public static void main(String[] args){
		SymmetricTree sm=new SymmetricTree();
		sm.init();
		boolean res=sm.isSymmetric(sm.root);
		/*Stack<Integer> rest=sm.inorderTraversal(sm.root.left);
		boolean res=sm.inorderRightChild(sm.root.right,rest);*/
		System.out.println(res);
	}
	

}
