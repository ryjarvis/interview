package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author: ryjarvis
 * Jan 6, 2018
 * 
 */
//LeetCode #279
public class PerfectSquares {
	
    public static int numSquares(int n) {
        Queue<Integer> q=new LinkedList<Integer>();
        Queue<Integer> temp;
        Set<Integer> visited=new HashSet<Integer>();
        q.add(n);
        visited.add(n);
        int level=1;
        outer:
        while(true){
        	temp=new LinkedList<Integer>();
        	while(!q.isEmpty()){
        		int num=q.poll();
        		if(isSquare(num)){
        			break outer;
        		}
        		List<Integer>l=listOfSquares(num);
        		for(int m:l){
        			if(!visited.contains(num-m)){
        				temp.add(num-m);
        				visited.add(num-m);
        			}
        			
        		}       		
        	}
        	q=temp;
        	level++;        	
        }
        return level;
    }
    
    public static List<Integer>listOfSquares(int n){
    	int i=1;
    	List<Integer> res=new ArrayList<Integer>();
    	while(Math.pow(i, 2)<n){
    		res.add(i*i);
    		i++;
    	}
    	return res;
    }
    
    public static boolean isSquare(int n){
    	return n==Math.pow((int)Math.sqrt(n), 2);
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=numSquares(7168);
		System.out.println(res);
	}

}


