package heap;

import java.util.PriorityQueue;

/**
 * @author: ryjarvis
 * Mar 22, 2018
 * 
 */
//LeetCode #378
public class KthSmallestElementInSortedMatrix {
	
    public static int kthSmallest(int[][] mat, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        for(int i=0;i<mat.length;i++) pq.add(new int[]{mat[0][i],0,i});
        int []min=new int[3];
        for(int j=0;j<k-1;j++){
        	min=pq.poll();
        	if(min[1]==mat.length-1) continue;
        	pq.add(new int[]{mat[min[1]+1][min[2]],min[1]+1,min[2]});
        }
        min=pq.poll();
        return min[0];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]mat={{1,5,9},{10,11,13},{12,13,15}};
		int res=kthSmallest(mat, 8);
		System.out.println(res);

	}

}


