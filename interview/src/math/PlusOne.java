package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis Nov 25, 2017
 * 
 */

public class PlusOne {

	public int[] plusOne(int[] digits) {
		// List<Integer> dig=new ArrayList<Integer>();
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 < 10) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;

		}
		int[] dig = new int[digits.length + 1];
		dig[0] = 1;
		return dig;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
