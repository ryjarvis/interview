package string;

//LintCode #734
public class NumberOfSubsequencesOfFormIAJBKC {

	// this question is very interesting
	// the solution is coming from the fact that we are looking at each
	// character
	// and try to see how much combination we can build up to that point
	// plus the extension amount
	// for instance a....a...a the third a can add one to the previous amount
	// since
	// if we only consider the third a we will have a new combo also it can
	// extend the combo by
	// another a times you ask how lets see closer consider the prior a's combo
	// and call it combo_a
	// now this last a either be used in any of those combinations or not which
	// will
	// results in 2*a similarly all the other ones came from the same fact
	// 1) consider them alone 2) put them in the combo or not
	// lets look at b and c too if we are at b location then if we look at it
	// alone then we have
	// a times possibility before it and we have 2*b combo so it will be a+2*b
	// similarly if we end at c if looked alone it can add 1*(b) combinations
	// and if we extend it we can have 2*c so the total would be b+2*c

	public int countSubsequences(String s) {
		int total_end_at_a_combo = 0;
		int total_end_at_b_combo = 0;
		int total_end_at_c_combo = 0;

		for (char c : s.toCharArray()) {
			if (c == 'a') {
				total_end_at_a_combo = total_end_at_a_combo * 2 + 1;
			}

			if (c == 'b') {
				total_end_at_b_combo = total_end_at_b_combo * 2 + total_end_at_a_combo;
			}
			
			if (c == 'c') {
				total_end_at_c_combo = total_end_at_c_combo * 2 + total_end_at_b_combo;
			}
		}
		return total_end_at_c_combo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
