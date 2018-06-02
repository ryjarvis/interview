package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis
 * May 2, 2018
 * 
 */
//LeetCode #539
public class MinimumTimeDifference {
    public static int findMinDifference(List<String> times) {
        int[]nums=new int[times.size()];
        int j=0;
        for(String s:times){
        	nums[j++]=timeToInt(s);
        }
        Arrays.sort(nums);
        int n=nums.length;
        int diff=Integer.MAX_VALUE;
        int prev=nums[0];
        for(int i=1;i<n;i++){
            diff=Math.min(nums[i]-prev,diff);
            prev=nums[i];
            if(diff==0) return 0;
        }
        int upper=(24*60);
        return Math.min(upper-nums[n-1]+nums[0], diff);
    }
    
    public static int timeToInt(String a){
    	String[]s1=a.split("\\:");
    	return 60*(Integer.valueOf(s1[0]))+(Integer.valueOf(s1[1]));
    }
    
    public int findMinDifferenceOptimized(List<String> timePoints) {
		boolean[] minutes = new boolean[24 * 60];
        int first = 24 * 60;
        int last = 0;
        for(int i = 0; i < timePoints.size(); i++){
            char[] str = timePoints.get(i).toCharArray();
            int hour = (str[0] - '0') * 10 + (str[1] - '0') ;
    	    int min = (str[3] - '0') * 10 + (str[4] - '0') ;
            int index = hour * 60 + min;
            if(minutes[index])
                return 0;
            minutes[index] = true;
            first = Math.min(first, index);
            last = Math.max(last, index);
        }
        int min = 1440 - last + first;
        int temp = first;
        for(int i = first + 1; i <= last; i++){
            if(minutes[i]){
                min = Math.min(min, i - temp);
                temp = i;
            }
        }
        return min;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ar=new ArrayList<>();
		ar.add("00:00");
		ar.add("23:59");
		int diff=findMinDifference(ar);

	}

}


