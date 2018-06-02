package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * May 7, 2018
 * 
 */
//LeetCode #216

//this solution works in O(9!/(9-k)!) if k==9 then we have the worst case of 9!
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {        
        List<List<Integer>> res=new ArrayList<>();
        helper(res,new ArrayList<Integer>(),k,n,1);
        return res;
    }
    
    public void helper(List<List<Integer>> res,List<Integer> cur,int k,int n,int level){
        if(n<0){
            return;
        }
        else if(n==0){
            if(k==0){
                res.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        for(int i=level;i<=9;i++){
            cur.add(i);
            helper(res,cur,k-1,n-i,i+1);
            cur.remove(cur.size()-1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


