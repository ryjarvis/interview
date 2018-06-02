package string;

public class CountAndSay {

	public static String countAndSay(int n) {
		String s = "1";
		int i = 2;
		while (i <= n) {
			i++;
			s = countAndSayHelper(s);			
		}
		return s;
	}

	public static String countAndSayHelper(String s) {
		// char[] c=s.toCharArray();
		StringBuilder sb = new StringBuilder();
		int length = s.length();
		int i = 0;

		while (i < length) {
			int j = i + 1;
			while (j < length && s.charAt(j) == s.charAt(i)) {
				j++;
			}
			sb.append(String.valueOf(j - i));
			sb.append(s.charAt(i));
			i = j;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res=countAndSay(9);
		System.out.println(res);

	}

}
