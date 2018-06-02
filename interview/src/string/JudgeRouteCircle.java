package string;

/**
 * @author: ryjarvis
 * May 14, 2018
 * 
 */
//LeetCode 657
public class JudgeRouteCircle {
	//O(n) 
    public boolean judgeCircle(String moves) {
        int horiz=0;
        int vert=0;
        for(char c:moves.toCharArray()){
            switch(c){
                case 'U':
                    vert++;
                    break;
                case 'D':
                    vert--;
                    break;
                case 'L':
                    horiz--;
                    break;
                default:
                    horiz++;
                    break;
            }
        }
        return (horiz==0&&vert==0);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


