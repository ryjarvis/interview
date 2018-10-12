package math;

/**
 * @author: ryjarvis Oct 11, 2018
 * 
 */
// LeetCode 789
public class EscapeTheGhosts {

	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int dist = Math.abs(target[0]) + Math.abs(target[1]);
		for (int[] g : ghosts) {
			if (Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]) <= dist) {
				return false;
			}
		}
		return true;
	}
	
	//python one liner
	//return abs(target[0])+abs(target[1])< min([abs(g[0]-target[0])+abs(g[1]-target[1]) for g in ghosts ])

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
