package string;

/**
 * @author: ryjarvis
 * May 10, 2018
 * 
 */
//LeetCode #12
public class IntegerToRoman {
	
    public String intToRoman(int num) {
    	int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" }; 
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<values.length;i++){
        	while(num>=values[i]){
        		num-=values[i];
        		sb.append(numerals[i]);
        	}        	
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


