package divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Jun 5, 2018
 * 
 */
//LeetCode #241
public class DifferentWaysToAddParentheses {
	
	public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<>();
        res=helper(input,res,0);
        return res;
    }
    
    public static List<Integer> helper(String input,List<Integer>res,int level){
        int idx=getNextOperand(input);
        List<Integer> list=new ArrayList<Integer>();
    	if(idx==input.length()){
    		list=new ArrayList<>();
    		if(!input.isEmpty()){
    			list.add(Integer.parseInt(input));
    		}
    		
    		return list;
    	}
    	while(idx<input.length()){
        	List<Integer>left=helper(input.substring(0, idx),res,level+1);
        	List<Integer>right=helper(input.substring(idx+1, input.length()),res,level+1);
        	boolean isPlus=false;
        	boolean isMinus=false;
        	if(input.charAt(idx)=='+'){
        		isPlus=true;
        	}
        	else if(input.charAt(idx)=='-'){
        		isMinus=true;
        	}
            if(left.size()==0){
                return right;
            }
            else if(right.size()==0){
                return left;
            }
        	for(int i:left){
        		for(int j:right){
        			if(isPlus){
        				list.add(i+j);
        			}
        			else if(isMinus){
        				list.add(i-j);
        			}
        			else{
        				list.add(i*j);
        			}
        			
        		}
        	}
        	idx+=getNextOperand(input.substring(idx+1, input.length()))+1;
    	}
    	if(level==0){
    		res.addAll(list);
    	}
    	return list;    	
    }
    
    public static int getNextOperand(String s){
    	int min=s.length();
    	if(s.indexOf('+')>-1){
    		min=s.indexOf('+');
    	}
    	if(s.indexOf('-')>-1&&s.indexOf('-')<min){
    		min=s.indexOf('-');
    	}
    	if(s.indexOf('*')>-1&&s.indexOf('*')<min){
    		min=s.indexOf('*');
    	}
    	return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="2-1-1";
		diffWaysToCompute(s);
		
	}

}


