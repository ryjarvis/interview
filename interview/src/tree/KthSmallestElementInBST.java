package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Jan 16, 2018
 * 
 */
//LeetCode #230
public class KthSmallestElementInBST {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){val=x;}
	}
	
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ar=new ArrayList<Integer>();
        help(ar,root,k);
        return ar.get(k-1);
    }
    
    public void help(List<Integer> l,TreeNode node,int k ){
        if(l.size()==k){
            return;
        }        
        if(node==null){
            return;
        }
        help(l,node.left,k);
        l.add(node.val);
        help(l,node.right,k);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


