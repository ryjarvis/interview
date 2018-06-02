package competitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Jan 6, 2018
 * 
 */

public class Question661 {
	
    public int[] anagramMappings(int[] a, int[] b) {
        Map<Integer,ArrayList<Integer>> m=new HashMap<>();
        int[]res=new int[a.length];
        for(int i=0;i<b.length;i++){
        	int n=b[i];
        	if(m.get(n)==null){
        		m.put(n,new ArrayList<Integer>());
        	}
        	m.get(n).add(i);
        }
        for(int i=0;i<a.length;i++){
        	int num=a[i];
        	res[i]=m.get(num).remove(0);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


