package competitions;

import java.util.TreeSet;

/**
 * @author: ryjarvis
 * Jan 6, 2018
 * 
 */

public class Question664 {
	
	public String makeLargestSpecial1(String S) {
        TreeSet<String> set = new TreeSet<>();
        dg(set, S);
        return set.last();
    }

    void dg(TreeSet<String> set, String str) {
        if (set.contains(str)) return;
        set.add(str);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') continue;

            int count = 1;
            for (int j = i + 1; j < str.length()-2; j++) {
                count += (str.charAt(j) == '1' ? 1 : -1);
                if (count < 0) break;

                if (count == 0 && str.charAt(j+1) == '1') {
                    int m = j+1;
                    int count2 = 1;
                    for (int n = m+1; n < str.length(); n++) {
                        count2 += (str.charAt(n) == '1' ? 1 : -1);

                        if (count2 < 0) break;

                        if (count2 == 0) {
                            String left = str.substring(i,j+1);
                            String right = str.substring(m,n+1);
                            if (left.compareTo(right) < 0) {
                                // System.out.println("left = " + left + ", right = " + right);
                                String newStr = str.substring(0,i) + right + left + str.substring(n+1);
                                if (set.higher(newStr) == null) {
                                    dg(set, newStr);
                                }
                            }
                        }
                    }

                }
            }
        }
    }
    
	boolean isSpecial(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == '1') {
				sum++;
			} else {
				sum--;
			}
			if (sum < 0) return false;
		}
		return sum == 0;
	}
	
    public String makeLargestSpecial2(String S) {
    	int N = S.length();
        for (int i = N - 2; i >= 0; --i) {
        	String tS = S;
        	for (int j = i + 1; j <= N; ++j) {
        		for (int k = j + 1; k <= N; ++k) {
	        		String s1 = S.substring(i, j);
	        		String s2 = S.substring(j, k);
	        		if (isSpecial(s1) && isSpecial(s2) && (s2 + s1).compareTo(s1 + s2) > 0) {
	        			String mS = S.substring(0, i) + s2 + s1 + S.substring(k);
	        			if (mS.compareTo(tS) > 0) {
	        				tS = mS;
	        			}
	        		}
        		}
        	}
        	S = tS;
        }
        return S;
    }
    
    public String makeLargestSpecialKaka(String S) {
        int n=S.length();
        while (true)
        {
        boolean[][] bo=new boolean[n][n];
        for (int i=0;i<n;i++)
        {
            int left=0;
            for (int j=i;j<n;j++)
            {
                if (S.charAt(j)=='1') left++; else left--;
                if (left<0) break;
                if (left==0) bo[i][j]=true;
            }
        }
        String[][] ans=new String[n][n];
        for (int i=0;i<n-1;i++) ans[i][i+1]=S.substring(i,i+2);
        for (int len=3;len<=n;len++)
            for (int i=0;i<n-len+1;i++)
            {
                int j=i+len-1;
                ans[i][j]=S.substring(i,j+1);
                String s1=ans[i][j-1]+S.charAt(j);
                String s2=S.charAt(i)+ans[i+1][j];
                if (s1.compareTo(ans[i][j])>0) ans[i][j]=s1;
                if (s2.compareTo(ans[i][j])>0) ans[i][j]=s2;
                if (bo[i][j]) 
                {
                    for (int k=i+1;k<j;k++)
                        if (bo[i][k] && bo[k+1][j])
                        {                    
                            if (ans[i][k].compareTo(ans[k+1][j])<0)
                            {
                                s1=ans[k+1][j]+ans[i][k];
                                if (s1.compareTo(ans[i][j])>0) ans[i][j]=s1;
                            }
                        }
                }
            }
        //return ans[0][n-1];
            if (ans[0][n-1].equals(S)) return S;
            S=ans[0][n-1];
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


