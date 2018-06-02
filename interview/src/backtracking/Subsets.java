package backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis
 * Dec 1, 2017
 * 
 */
//LeetCode #78
public class Subsets {
	
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>>res=new ArrayList<List<Integer>>();

    	List<Integer>avail=new ArrayList<Integer>();
    	for(int i:nums){
    		avail.add(i);
    	}
        subsetsHelper(new ArrayList<Integer>(),avail,res);
        return res;
    }
    
    public static void subsetsHelper(List<Integer>chosen,List<Integer>avail,List<List<Integer>>res){
    	if(avail.isEmpty()){
    		res.add(new ArrayList<Integer>(chosen));
    		return;
    	}
    	int num=avail.remove(0);
    	chosen.add(num);
    	subsetsHelper(chosen,avail,res);
    	chosen.remove(chosen.size()-1);
    	subsetsHelper(chosen,avail,res); 
    	avail.add(0,num);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ar={1,2,3};
		List<List<Integer>>res=subsets(ar);
	}

}


