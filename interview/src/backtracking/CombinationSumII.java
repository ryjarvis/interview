package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode #40
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] c, int target) {
    	Arrays.sort(c);
    	List<List<Integer>> res=new ArrayList<>();
    	helper(new ArrayList<>(), res, target, c,0);
    	return res;
    }
    
    public void helper(List<Integer> list,List<List<Integer>> res,int target,int[]c,int level){
    	if(target<0){
    		return;
    	}
    	if(target==0&level!=0){
    		res.add(new ArrayList<>(list));
    	}
    	for(int i=level;i<c.length;i++){
    		if(i>level&&c[i]==c[i-1]){
    			continue;
    		}
    		list.add(c[i]);
    		helper(list,res,target-c[i],c,i+1);
    		list.remove(list.size()-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
