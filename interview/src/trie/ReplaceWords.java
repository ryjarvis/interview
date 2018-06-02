package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis May 5, 2018
 * 
 */
// LeetCode #648
public class ReplaceWords {
	class TrieNode {
		TrieNode[] children;
		Integer id;
		public TrieNode() {
			children = new TrieNode[26];
			id=-1;
		}
	}
	private TrieNode root=new TrieNode();
	//O(n) solution
	public String replaceWords(List<String> dict, String sentence) {
		TrieNode cur;   
		for (int i=0;i<dict.size();i++) {
		
			cur=root;
			boolean t=false;
			for(char c:dict.get(i).toCharArray()){
				
				if(cur.id>=0){
                    t=true;
					break;
                    
				}
				if(cur.children[c-'a']==null){
					cur.children[c-'a']=new TrieNode();
				}
				cur=cur.children[c-'a'];
			}
            if(!t){
               cur.id=i; 
            }
			
		}
		String []ar=sentence.split("\\s");
		for(int i=0;i<ar.length;i++){
			cur=root;
			for(char c:ar[i].toCharArray()){
				if(cur.id>=0){
					ar[i]=dict.get(cur.id);
                    break;
				}
                else{
                    if(cur.children[c-'a']==null){
					    break;
				    }
				    cur=cur.children[c-'a'];
                }

			}
		}
		return String.join(",", ar).replaceAll(","," ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> ar=new ArrayList<>();
		ar.add("a");
		ar.add("ar");
		ar.add("i");		
		ar.add("w");
		String s="its wrong";
		ReplaceWords rw=new ReplaceWords();
		rw.replaceWords(ar, s);
		
	}

}
