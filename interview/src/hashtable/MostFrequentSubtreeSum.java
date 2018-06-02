package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ryjarvis
 * Apr 27, 2018
 * 
 */
//LeetCode #508
public class MostFrequentSubtreeSum {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int x){
			val=x;
		}
	}
    public static int[] findFrequentTreeSum(TreeNode root) {

        int[]max={0};
        List<Integer>nums=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        find(root,max,nums,map);
        int[]res=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
        	res[i]=nums.get(i);
        }
        return res;
    }
    
    public static int find(TreeNode t,int[]max,List<Integer>nums,Map<Integer,Integer>map){
    	if(t==null) return 0;
    	int left=find(t.left, max, nums, map);
    	int right=find(t.right, max, nums, map);
    	int key=t.val+left+right;
    	int val=map.getOrDefault(key, 0);
    	map.put(key, val+1);
    	if(val+1>max[0]){
    		//nums=new ArrayList<Integer>();
    		nums.clear();
    		nums.add(key);
            max[0]=val+1;
    	}
    	else if(val+1==max[0]){
    		nums.add(key);
    	}
    	return key;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostFrequentSubtreeSum mf=new MostFrequentSubtreeSum();
		TreeNode root=mf.new TreeNode(5);
		root.left=mf.new TreeNode(2);
		root.right=mf.new TreeNode(-3);
		findFrequentTreeSum(root);
		

	}

}


