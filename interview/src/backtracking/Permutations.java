package backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
	
	public static void permute(String s){
		permuteHelper(s.toCharArray(),0);
	}
	
	public static void permuteHelper(char[]c,int level){
		if(level==c.length-1){
			System.out.println(String.valueOf(c));
		}
		for(int i=level;i<c.length;i++){
			swap(c,i,level);
			permuteHelper(c,level+1);
			swap(c,i,level);
		}
	}
	
	public static void swap(char[]c,int i,int j){
		char temp=c[i];
		c[i]=c[j];
		c[j]=temp;
	}
	
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	permuteHelper(nums,0,res);
    	return res;
    }
    
    public static void permuteHelper(int[] nums,int level,List<List<Integer>>res){
    	if(level==nums.length){
    		List<Integer> add=new ArrayList<Integer>();
    		for(int i=0;i<nums.length;i++){
    			add.add(nums[i]);
    		}
    		res.add(add);
    	}
    	for(int i=level;i<nums.length;i++){
    		swap(nums,i,level);
    		permuteHelper(nums,level+1,res);
    		swap(nums,i,level);
    	}
    }
    
    public static void swap(int[]nums,int i,int j){
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcd";
		permute(s);
		int[]nums={1,2,3};
		List<List<Integer>> res=permute(nums);
		System.out.println(res.size());

	}

}
