package bitmanipulation;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #476
public class NumberComplement {
	
    public static int findComplement(int num) {
        return ~num + (Integer.highestOneBit(num) << 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findComplement(5);
	}

}


