package competitions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author: ryjarvis
 * Dec 23, 2017
 * 
 */

public class Question643 {
	private static class Element {
		public String string;
		public int dist;
		public Element(String string , int dist) {
			this.string = string;
			this.dist = dist;
		}
	}
	
	private Set<String> vis = new HashSet<>();

	private char getPrev(char ch) {
		
		if (ch == '0') {
			return '9';
		} else {
			return (char) (ch - 1);
		}
		
	}
	
	private char getNext(char ch) {
		
		if (ch == '9') {
			return '0';
		} else {
			return (char) (ch + 1);
		}
		
	}
	
    public int openLock(String[] deadends, String target) {
        
    	for (String string : deadends) {
    		vis.add(string);
    		if ("0000".equals(string)) {
    			return - 1;
    		}
    	}
    	
    	Queue<Element> queue = new LinkedList<>();
    	queue.add(new Element("0000" , 0));
    	vis.add("0000");
    	while (!queue.isEmpty()) {
    		Element e = queue.poll();
    		char[] array = e.string.toCharArray();
    		for (int i = 0;i < array.length;i ++) {
    			char temp = array[i];
    			array[i] = getPrev(temp);
    			String next = new String(array);
    			if (next.equals(target)) {
    				return e.dist + 1;
    			} else {
    				if (!vis.contains(next)) {
    					vis.add(next);
    					queue.add(new Element(next , e.dist + 1));
    				}
    			}
    			array[i] = getNext(temp);
    			next = new String(array);
    			if (next.equals(target)) {
    				return e.dist + 1;
    			} else {
    				if (!vis.contains(next)) {
    					vis.add(next);
    					queue.add(new Element(next , e.dist + 1));
    				}
    			}
    			array[i] = temp;
    		}
    	}
    	return - 1;
    	
    }
    
    public int openLock2(String[] deadends, String target) {
        int t = Integer.parseInt(target);
        boolean[] de = new boolean[10000];
        for(String d : deadends){
        	de[Integer.parseInt(d)] = true;
        }
        if(de[0]){
        	return -1;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int[] ds = new int[10000];
        Arrays.fill(ds, 99999999);
        ds[0] = 0;
        while(!q.isEmpty()){
        	int cur = q.poll();
        	for(int d = 1;d <= 1000;d*=10){
        		int l = cur % (d*10) / d;
        		{
        			int ne = l == 0 ? cur + 9*d : cur - d;
        			if(!de[ne] && ds[ne] > ds[cur] + 1){
        				ds[ne] = ds[cur] + 1;
        				q.add(ne);
        			}
        		}
        		{
        			int ne = l == 9 ? cur - 9*d : cur + d;
        			if(!de[ne] && ds[ne] > ds[cur] + 1){
        				ds[ne] = ds[cur] + 1;
        				q.add(ne);
        			}
        		}
        	}
        }
        if(ds[t] > 100000){
        	return -1;
        }else{
        	return ds[t];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


