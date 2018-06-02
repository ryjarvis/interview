package greedy;

import java.util.Arrays;

/**
 * @author: ryjarvis Apr 22, 2018
 * 
 */
// LeetCode #621
public class TaskScheduler {
	// the idea is to first get the frequency then keep using those frequencies
	// until we ran out
	// then if we ran out fully that means we didn't need the idle time
	// if we ran out but still some didn't ran out it means we need idle times
	//Time complexity O(time)
	public static int leastInterval(char[] tasks, int n) {
        int[] map=new int[26];
        for(char c:tasks){
        	map[c-'A']++;
        }
        Arrays.sort(map);
        int time=0;
        while(map[25]>0){
        	for(int i=0;i<=n;i++){
        		if(i<=25&&map[25-i]>0){
        			map[25-i]--;
        		}

        		time++;
                if(map[25]==0&&i<25&&map[25-i-1]==0){
        			break;
        		}
        	}
        	Arrays.sort(map);
        }
        return time;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[]ar={'A','B','C','D','E','A','B','C','D','E'};
		leastInterval(ar, 4);
				
	}

}
