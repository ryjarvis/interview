package tree;

/**
 * @author: ryjarvis
 * Jan 15, 2018
 * 
 */
//LeetCode #116
public class PopulatingNextRightPointersEachNode {
	public class TreeLinkNode{
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		int val;
		TreeLinkNode(int x){
			this.val=x;
		}
		
	}
	 public void connect(TreeLinkNode root) {
	        if(root==null) return;
	        TreeLinkNode cur=root;
	        while(cur.left!=null){
	            TreeLinkNode level=cur;
	            while(level!=null){
	                level.left.next=level.right;
	                if(level.next!=null){
	                    level.right.next=level.next.left;
	                }
	                level=level.next;
	            }
	            cur=cur.left;
	        }
	        
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


