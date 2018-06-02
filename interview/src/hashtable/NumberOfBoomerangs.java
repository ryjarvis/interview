package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis May 14, 2018
 * 
 */
// LeetCode #447
public class NumberOfBoomerangs {

	public int numberOfBoomerangs(int[][] points) {
		Map<Integer,Integer>map=new HashMap<>();
		int res=0;
		for(int[]i:points){
			for(int[]j:points){
				int d=dist(i,j);
				map.put(d, map.getOrDefault(d, 0)+1);
			}
			for(int val:map.values()){
				res+=val*(val-1);
			}
			map.clear();
		}
		return res;
	}
	public int dist(int[]a,int[]b){
		int x=a[0]-b[0];
		int y=a[1]-b[1];
		return x*x+y*y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
