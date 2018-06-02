package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: ryjarvis Jan 18, 2018
 * 
 */
// LeetCode #373
public class FindKPairsWithSmallestSums {

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res=new ArrayList<>();
		if(k==0||nums1.length==0||nums2.length==0){
			return res;
		}
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]+a[1]-b[0]-b[1]));
		for(int i=0;i<nums1.length;i++) pq.add(new int[]{nums1[i],nums2[0],0});
		while(k-->0&&!pq.isEmpty()){
			int[]val=pq.poll();
			res.add(new int[]{val[0],val[1]});
			if(val[2]+1<nums2.length){
				pq.add(new int[]{val[0],nums2[val[2]+1],val[2]+1});
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
