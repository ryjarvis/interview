package competitions;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LogReader {
	public int[] exclusiveTime(int n, List<String> logs) {
        int[] time=new int[n];
        int previousId=-1;
        String previousState;
        Map<Integer,Integer> mapTime=new TreeMap<Integer,Integer>();
        for(String log:logs){
        	String[] values=log.split("\\s*:\\s*");
        	if(previousId!=-1){
        		mapTime.put(previousId, mapTime.get(previousId)>0?Integer.valueOf(values[3])-mapTime.get(previousId)+1:Integer.valueOf(values[3])-mapTime.get(previousId));
        	}
        	
        	if(mapTime.containsKey(arg0))
        }
    }
	
	public class Solution {
	    public int[] exclusiveTime(int n, List<String> logs) {
	    	int[] ret = new int[n];
	    	int ptime = -1;
	    	int[] stack = new int[logs.size()+2];
	    	int p = 0;
	        for(int i = 0;i < logs.size();i++){
	        	String[] sp = logs.get(i).split(":");
	        	int id = Integer.parseInt(sp[0]);
	        	int time = Integer.parseInt(sp[2]);
	        	if(p > 0){
	        		ret[stack[p-1]] += time - ptime - 1;
	        	}
	        	if(sp[1].equals("start")){
	        		stack[p++] = id;
	        		ret[id]++;
	        	}else{
	        		ret[id]++;
	        		p--;
	        	}
	        	ptime = time;
	        }
	        return ret;
	    }
	}
	
	public class Solution {
	    public double findMaxAverage(int[] nums, int k) {
	                if (nums == null || nums.length == 0 || k > nums.length) return 0;
	        int n =  nums.length;

	        int [] sarr = new int[n+1];
	        for (int i = 0; i < n; i++) {
	            sarr[i+1] += sarr[i] + nums[i];
	        }





	        double res = Integer.MIN_VALUE;
	        for (int i = k ; i <= n; i++) {
	            double s1 = Integer.MIN_VALUE;
	            for (int j = n-i; j >= 0; j--) {
	                int sum = sarr[j+i] - sarr[j];
	                s1 = Math.max(s1, sum);
	            }
	            res = Math.max(res, s1/i);
	        }
	        return res;
	    }
	}


}
