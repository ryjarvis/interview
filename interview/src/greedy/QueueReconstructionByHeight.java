package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis
 * Apr 18, 2018
 * 
 */
//LeetCode #406
public class QueueReconstructionByHeight {
	
    public static int[][] reconstructQueue(int[][] p) {
    	 Arrays.sort(p,(int[]p1, int[]p2) -> {
    	        if (p1[0]==p2[0]) {
    	            return p1[1] - p2[1];
    	        } else {
    	            return p2[0] - p1[0];
    	        }
    	    });
    	 List<int[]> list=new ArrayList<>();
    	 for(int i=0;i<p.length;i++){
    		 list.add(p[i][1],p[i]);
    	 }
    	 
    	 //this is not actually necessary
    	/*for(int i=0;i<p.length;i++){
    		p[i]=list.get(i);
    	}*/
    	 //this way is faster
    	 return list.toArray(new int[list.size()][]);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]p={{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(p);

	}

}


