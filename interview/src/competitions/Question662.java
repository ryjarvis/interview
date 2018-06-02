package competitions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ryjarvis
 * Jan 6, 2018
 * 
 */

public class Question662 {
	
    public String boldWords(String[] words, String S) {
        Set<String> st=new HashSet<String>();
        StringBuilder sb=new StringBuilder();
       
        for(String t:words){
        	st.add(t);
        }
        int[]start=new int[st.size()];
        int[]end=new int[st.size()];
        for(String str:st){
        	int startid=S.indexOf(str);
        	int endid=startid+str.length();
        	for(int i=0;i<start.length;i++){
        		
        	}
        }
        char[]arr=S.toCharArray();
        int i=0;
        while(i<arr.length){
        	if(st.contains(arr[i])){
        		sb.append("<b>");
        		while(st.contains(arr[i])){
        			sb.append(arr[i]);
        			i++;
        		}
        		sb.append("</b>");
        	}
        	else{
        		sb.append(arr[i]);
        		i++;
        	}
        }
        return sb.toString();
    }
    public String boldWordsSample(String[] words, String S) {
    	int[] hit = new int[S.length()+1];
    	for(String w : words){
    		for(int i = 0;i+w.length()-1 < S.length();i++){
    			if(S.substring(i, i+w.length()).equals(w)){
    				hit[i]++;
    				hit[i+w.length()]--;
    			}
    		}
    	}
    	for(int i = 0;i < S.length();i++){
    		hit[i+1] += hit[i];
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i < S.length();i++){
    		if(hit[i] > 0){
    			sb.append("<b>" + S.charAt(i) + "</b>");
    		}else{
    			sb.append(S.charAt(i));
    		}
    	}
    	return sb.toString().replace("</b><b>", "");
    }
    public String boldWordsUWI(String[] words, String S) {
        String s=S;
        String[] dict=words;
        int n=s.length();
        int[] a=new int[n+1];
        String left="<b>",right="</b>";
        for (String w:dict)
        {
            int last=0;
            while (true)
            {
                last=s.indexOf(w,last);
                if (last==-1) break;
                a[last]++;
                a[last+w.length()]--;
                last++;
            }
        }
        int now=0;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<=n;i++)
        {
            if (a[i]!=0)
            {
                int next=now+a[i];
                if (now==0 && next>0) sb.append(left);
                if (next==0 && now>0) sb.append(right);
                now=next;
            }
            if (i<n) sb.append(s.charAt(i));
        }
        return sb.toString();        
    }
    
    public String boldWordsKaka(String[] words, String S) {
        String s=S;
        String[] dict=words;
        int n=s.length();
        int[] a=new int[n+1];
        String left="<b>",right="</b>";
        for (String w:dict)
        {
            int last=0;
            while (true)
            {
                last=s.indexOf(w,last);
                if (last==-1) break;
                a[last]++;
                a[last+w.length()]--;
                last++;
            }
        }
        int now=0;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<=n;i++)
        {
            if (a[i]!=0)
            {
                int next=now+a[i];
                if (now==0 && next>0) sb.append(left);
                if (next==0 && now>0) sb.append(right);
                now=next;
            }
            if (i<n) sb.append(s.charAt(i));
        }
        return sb.toString();        
    }
    //c program very creative
    /*public:
        string boldWords(vector<string>& words, string S) {
            vector<bool> bold(S.length(), false);
            for (auto & w : words) {
                for (int i = 0; i < S.length() - w.length() + 1; ++i) {
                    if (S.substr(i, w.length()) == w) {
                        for (int j = i; j < i + w.length(); ++j)
                            bold[j] = true;
                    }
                }
            }
            string ret = "";
            for (int i = 0; i < S.length(); ++i) {
                if (bold[i] && (i == 0 || !bold[i-1]))
                    ret = ret + "<b>";
                ret = ret + S[i];
                if (bold[i] && (i == S.length() - 1 || !bold[i+1]))
                    ret = ret + "</b>";
            }
            return ret;
        }
    };*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


