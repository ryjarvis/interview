package math;

//LeetCode #13
public class RomanToInteger {
	public static int romanToInt(String s) {
		char[] c = s.toCharArray();
		int sum = converter(c[0]);
		int prev=sum;
		int cur;
		for (int i = 1; i < s.length(); i++) {
			cur=converter(c[i]);
			if(cur>prev){
				sum+=cur-2*prev;
			}
			else{
				sum+=cur;
			}
			prev=cur;
		}
		return sum;
	}

	public static int converter(char c) {
		int num;
		switch (c) {
		case 'I':
			num = 1;
			break;
		case 'V':
			num = 5;
			break;
		case 'X':
			num = 10;
			break;
		case 'L':
			num = 50;
			break;
		case 'C':
			num = 100;
			break;
		case 'D':
			num = 500;
			break;
		case 'M':
			num = 1000;
			break;
		default:
			num = 0;
			break;
		}
		return num;

	}

	public static void main(String[] args) {
		String s = "LXXXIX";
		int res = romanToInt(s);
		System.out.println(res);
	}

}
