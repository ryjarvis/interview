package tree;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #623
public class AddOneRowToTree {
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x){
			val=x;
		}
	}
	//this algorithm works in O(d)
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1){
            TreeNode temp=new TreeNode(v);
            temp.left=root;
            return temp;
        }
        helper(root,v,d,1);
        return root;
    }
    
    public void helper(TreeNode node,int v,int d,int level){
        if(node==null){
            return;
        }
        if(level==d-1){
            TreeNode left=node.left;
            TreeNode right=node.right;
            node.left=new TreeNode(v);
            node.right=new TreeNode(v);
            node.left.left=left;
            node.right.right=right;
            return;
        }
        helper(node.left,v,d,level+1);
        helper(node.right,v,d,level+1);        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


