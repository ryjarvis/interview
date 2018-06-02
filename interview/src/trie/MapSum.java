package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Apr 28, 2018
 * 
 */
//LeetCode #677 
public class MapSum {
	class TrieNode{
		Map<Character,TrieNode> child;
		int val;
		public TrieNode(){
			child=new HashMap<>();
			val=0;
		}
		
	}
	private TrieNode root;
    public MapSum() {
    	root=new TrieNode();
    }
    public void insert(String key, int val) {
    	TrieNode cur=root;
        for(char c:key.toCharArray()){
        	TrieNode next=cur.child.get(c);
        	if(next==null){
        		next=new TrieNode();
        		cur.child.put(c, next);
        	}
        	cur=next;
        }
        cur.val=val;
    }
    
    public int sum(String prefix) {
        TrieNode cur=root;
        for(char c:prefix.toCharArray()){
        	TrieNode next=cur.child.get(c);
        	if(next==null){
        		return 0;
        	}
        	cur=next;
        }
        return dfs(cur);
    }
    
    public int dfs(TrieNode t){
    	int count=0;
    	Map<Character,TrieNode> map=t.child;
    	for(char c:map.keySet()){
    		count+=dfs(map.get(c));
    	}
    	return count+t.val;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


