package competitions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ryjarvis
 * Dec 30, 2017
 * 
 */

public class Question653 {
	
	public boolean pyramidTransition(String bottom, List<String> allowed) {
        int n = bottom.length();
        int[][] to = new int[7][7];
        for(String a : allowed){
        	int x = a.charAt(0)-'A';
        	int y = a.charAt(1)-'A';
        	int z = a.charAt(2)-'A';
        	to[x][y] |= 1<<z;
        }
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
        	dp[i] = 1<<bottom.charAt(i)-'A';
        }
        for(int i = n-1;i >= 1;i--){
        	int[] ndp = new int[i];
        	for(int j = 0;j < i;j++){
        		int l = dp[j], r = dp[j+1];
        		for(int k = 0;k < 7;k++){
        			for(int u = 0;u < 7;u++){
        				if(l<<~k<0 && r<<~u<0){
        					ndp[j] |= to[k][u];
        				}
        			}
        		}
        	}
        	dp = ndp;
        }
        return dp[0] != 0;
    }
	
	public boolean pyramidTransition2(String bottom, List<String> allowed) {
        List<Set<Character>> layer = new ArrayList<>();
        for (char c : bottom.toCharArray()) {
            Set<Character> p = new HashSet<>();
            p.add(c);
            layer.add(p);
        }
        while (layer.size() > 1) {
            for (int i = 0; i < layer.size() - 1; i++) {
                Set<Character> p1 = layer.get(i);
                Set<Character> p2 = layer.get(i + 1);
                Set<Character> p = new HashSet<>();
                for (String s : allowed) {
                    if (p1.contains(s.charAt(0)) && p2.contains(s.charAt(1))) {
                        p.add(s.charAt(2));
                    }
                }
                if (p.isEmpty()) {
                    return false;
                }
                layer.set(i, p);
            }
            layer.remove(layer.size() - 1);
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


