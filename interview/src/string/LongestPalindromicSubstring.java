package string;

//leetcode #5
public class LongestPalindromicSubstring {
	// first solution
	// idea: reverse the string then start from the begining of the string check
	// if any of the substring exist in the reverse string
	// Time out solution
	public static String longestPalindromeTimeOut(String s) {
		// String reverse = reverse(s);
		String reverse = new StringBuilder(s).reverse().toString();
		String maxString = "";
		int l = s.length();
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j <= l; j++) {
				/*
				 * System.out.println(s.substring(i, j));
				 * System.out.println(reverse.substring(l-j,l-i));
				 * System.out.println(l-i); System.out.println(l-j);
				 */
				if (s.substring(i, j).equals(reverse.substring(l - j, l - i))) {
					if (j - i > maxString.length()) {
						maxString = s.substring(i, j);
					}
				}
			}
		}
		return maxString;
	}

	public static String longestPalindrome(String s){
		String max="";
		int l=s.length();
		char[] c=s.toCharArray();
		boolean [][] b=new boolean[l][l];
		//k=1 diagonal equals to true because 
		//if s.length()>0 then at least we have palindrome with size of 1
		for(int j=0;j<l;j++){
			b[j][j]=true;
			if(max.length()<1){
				max=s.substring(0, 1);
			}
		}
		//for k=2 aa or bb or... finding palindrome length of two
		for(int i=0;i<l-1;i++){
			if(c[i]==c[i+1]){
				b[i][i+1]=true;
				if(max.length()<2){
					max=s.substring(i, i+2);
				}
			}
		}
		//general k>2
		for(int k=2;k<l;k++){
			for(int i=1;i<l-k+1;i++){
				if(b[i][k+i-2]&&c[i-1]==c[k+i-1]){
					b[i-1][k+i-1]=true;
					if(max.length()<k+1){
						max=s.substring(i-1,k+i);
					}
				}
			}
			
		}
		return max;
	}

	/*
	 * public static String reverse(String s) { String reverse = ""; char[] c =
	 * s.toCharArray(); int i = 0; int j = c.length - 1; while (i < j) { char
	 * temp = c[j]; c[j] = c[i]; c[i] = temp; i++; j--; } reverse = new
	 * String(c); return reverse; }
	 */
	
	public String longestPalindromeBetter(String s) {
        int n=s.length();
        int max=0;
        String res="";
        if(n==1){
            res=s;
        }
        char[]c=s.toCharArray();
        boolean[][] mem=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            mem[i][i]=true;
            for(int j=i+1;j<n;j++){
                if(c[i]==c[j]&&(mem[i+1][j-1]||j<=i+2)){
                    mem[i][j]=true;
                    if(j-i+1>max){
                        res=s.substring(i,j+1);
                        max=j-i+1;
                    }
                }
            }
        }
        return res;  
    }
	
	public String longestPalindromeClean(String s) {
		  int n = s.length();
		  String res = null;
		    
		  boolean[][] dp = new boolean[n][n];
		    
		  for (int i = n - 1; i >= 0; i--) {
		    for (int j = i; j < n; j++) {
		      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
		            
		      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
		        res = s.substring(i, j + 1);
		      }
		    }
		  }
		    
		  return res;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx";
		String s2="babad";
		String res = longestPalindrome(s);
		System.out.println(res);
	}

}
