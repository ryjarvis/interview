package tree;

//LeetCode #129

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int x){
		val=x;
	}
}
public class SumRootToLeafNumbers {
	
	public int sumNumbers(TreeNode root) {
        return helper(root,0); 
    }
    
	//first Solution
    public int helper(TreeNode root,int sum){
           if(root==null) return sum;
        if(root.right==null&&root.left==null) return sum*10+root.val;
        else if(root.right!=null&&root.left!=null){
            return helper(root.left,sum*10+root.val)+helper(root.right,sum*10+root.val);
        }
        else if(root.left!=null){
            return helper(root.left,sum*10+root.val);
        }
        else{
           return helper(root.right,sum*10+root.val);
        }
        
    }
    
    public int helperImproved(TreeNode root,int sum){
    	if(root==null) return 0;
    	else if(root.right==null&&root.left==null){
    		return root.val+sum*10;
    	}
    	sum=root.val+sum*10;
    	return helperImproved(root.left, sum)+helperImproved(root.right,sum);
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
