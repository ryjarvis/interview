package arrays;

/**
 * @author: ryjarvis
 * May 12, 2018
 * 
 */
//LeetCode #419
public class BattleshipsInBoard {
	
    public int countBattleships(char[][] b) {
    	int count=0;
        for(int i=0;i<b.length;i++){
        	for(int j=0;j<b[0].length;j++){
        		if(b[i][j]=='X'&&(i==0||(b[i-1][j]=='.'))&&(j==0||(b[i][j-1]=='.'))){
        			count++;
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


