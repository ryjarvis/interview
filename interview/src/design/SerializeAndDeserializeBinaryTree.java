package design;

import java.util.LinkedList;
import java.util.Queue;

//LeetCode 297 
class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int x){
		val=x;
	}
}
public class SerializeAndDeserializeBinaryTree {

    public static String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        sb.append(root.val).append(",");
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left==null){
                sb.append("n,");
            }
            else{
                sb.append(node.left.val).append(",");
                q.add(node.left);
            }
            if(node.right==null){
                sb.append("n,");
            }
            else{
                sb.append(node.right.val).append(",");
                q.add(node.right);
            }
        }
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data==null){
    		return null;
    	}
        String[]str=data.split(",");
        Queue<TreeNode>q= new LinkedList<>();        
        TreeNode root=new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        int idx=1;
        while(!q.isEmpty()){
        	TreeNode node=q.poll();
        	if(!str[idx].equals("n")){
        		TreeNode left=new TreeNode(Integer.parseInt(str[idx]));
        		q.add(left);
        		node.left=left;
        	}
        	if(!str[idx+1].equals("n")){
        		TreeNode right=new TreeNode(Integer.parseInt(str[idx+1]));
        		q.add(right);
        		node.right=right;
        	}
        	idx+=2;
        	
        }
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(5);
		String res=serialize(root);


	}

}
