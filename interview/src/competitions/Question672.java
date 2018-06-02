package competitions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Jan 13, 2018
 * 
 */

public class Question672 {
	
    public List<Integer> partitionLabels(String s) {
    	List<Integer> res=new ArrayList<Integer>();
        help(s,res,0);
        return res;
    }
    
    public void help(String s,List<Integer> l,int ind){
    	if(s.isEmpty()){
    		return;
    	}
    	int j=ind;
    	int i=s.lastIndexOf(s.charAt(ind));
    	while(j<=i&&j<s.length()){
    		i=Math.max(i,s.lastIndexOf(s.charAt(j)));
    		j++;
    	}
    	l.add(j-ind+1);
    	help(s,l,j);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


