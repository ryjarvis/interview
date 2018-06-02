package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: ryjarvis Dec 17, 2017
 * 
 */
// LeetCode #127
public class WordLadder {
	
	public static int ladderLength(String beginWord, String endWord,List<String>words){
		int shortest=0;
		boolean found=false;
		Queue<String> q=new LinkedList<String>();
		Set<String> visited=new HashSet<String>();
		q.add(beginWord);
		q.add(null);
		visited.add(beginWord);
		while(!q.isEmpty()&&!found){
			while(q.peek()!=null){
				String parent=q.poll();
				for (String st : words) {
					if (dist(st, parent) == 1&&!visited.contains(st)) {
						q.add(st);
						visited.add(st);
						if(st.equals(endWord)){
							found=true;
							shortest++;
							break;
						}
					}
				}
			}
			if(q.peek()==null&&q.size()>1){
				q.poll();
				q.add(null);
				shortest++;
			}
			else{
				q.poll();
			}
		}
		return found==false?0:shortest;
	}
	//two end(bidirectional BFS)
    public int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        Set<String> dict = new HashSet<String>(wordList);
        if (!dict.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 1;
        Set<String> q1 = new HashSet<String>(), q2 = new HashSet<String>();
        q1.add(beginWord); dict.remove(beginWord);
        q2.add(endWord);dict.remove(endWord);
        return twoEndBFS(q1, q2, dict, 2);
    }
    
    private int twoEndBFS(Set<String> q1, Set<String> q2, Set<String> dict, int len) {
        if (q1.isEmpty() || q2.isEmpty()) return 0;
        if (q1.size() > q2.size()) return twoEndBFS(q2, q1, dict, len);
        
        Set<String> temp = new HashSet<String>();
        for (String word : q1) {
            char[] chArr = word.toCharArray();
            for (int i=0; i<chArr.length; i++) {
                char c = chArr[i];
                for (char newC='a'; newC<='z'; newC++) {
                    chArr[i] = newC;
                    String next = new String(chArr);
                    if (q2.contains(next)) return len;
                    if (dict.contains(next)) {
                        temp.add(next);
                        dict.remove(next);
                    }
                }
                chArr[i] = c;
            }
        }
        return twoEndBFS(temp, q2, dict, len+1);
    }
	//unsuccessful dfs approach that led to LTE
	public static int ladderLength2(String beginWord, String endWord, List<String> words) {
		int res=dfs(beginWord, endWord, "", Integer.MAX_VALUE, words, new HashSet<String>());
		return res<Integer.MAX_VALUE?res:0;
	}

	public static int dfs(String b,String e,String path,int shortest,List<String>w,Set<String>set){
		String newPath=path+b+"-";
		set.add(newPath);
		if(!newPath.isEmpty()&&newPath.length()/(b.length()+1)>=shortest){
			return shortest;
		}
		
		else if(b.equals(e)){
			return (newPath.length())/(b.length()+1);
		}
		List<String>close=new ArrayList<String>();
		
		for (String st : w) {
			if (dist(st, b) == 1&&!path.contains(st)) {
				close.add(st);
			}
		}
		if(close.isEmpty()){
			return shortest;
		}
		for(String str:close){
					shortest=Math.min(shortest, dfs(str, e, newPath, shortest, w,set));							
		}		
		return shortest;		
	}
	
	public static int dist(String s, String t) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> word = Arrays.asList("si", "go", "se", "cm", "so", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm",
				"ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "sn", "ya", "cr", "po", "fe", "ho", "ma",
				"or", "rn", "au", "ur", "rh", "sr", "lt", "nb", "yb", "th", "pm", "rb", "sh", "co", "ga", "li", "ha",
				"hz", "no", "bi", "di", "hi", "qa", "pi", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am",
				"ex", "lr", "sq");
		List<String> w = Arrays.asList("qa", "ca", "cm", "tm", "ti", "si", "se", "le", "ln", "rn", "rh", "rb", "mb",
				"mo", "go", "yo", "po", "ho", "hz", "no", "nb", "sq");

		List<String> my = Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm",
				"le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr",
				"po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb",
				"yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi",
				"qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am",
				"ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye");
		List<String> wg = Arrays.asList("qa", "qe", "se", "sf", "if", "fm", "wm", "sq");
		List<String>test=Arrays.asList("hot","dog","cog","pot","dot");
		int res = ladderLength("qa", "sq", word);
		System.out.println(res);

	}

}
