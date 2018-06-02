package trie;

public class Trie {
	private TrieNode root;
	public class TrieNode{
		TrieNode [] child;
		boolean endOfWord;
		public TrieNode(){
			child=new TrieNode[26];
		}
	}
	
	public Trie(){
		root=new TrieNode();
		root.endOfWord=true;
	}
	
	public boolean search(String word){
		char[]cArray=word.toCharArray();
		TrieNode node=root;
		for(int i=0;i<cArray.length;i++){
			if(node.child[cArray[i]-'a']!=null){
				node=node.child[cArray[i]-'a'];
			}
			else{
				return false;
			}
		}
		return node.endOfWord;
	}
	
	public void insert(String word){
		TrieNode node=root;
		char[]cArray=word.toCharArray();
		for(int i=0;i<cArray.length;i++){
			if(node.child[cArray[i]-'a']==null){
				node.child[cArray[i]-'a']=new TrieNode();
			}
			node=node.child[cArray[i]-'a'];
		}
		node.endOfWord=true;
		
	}
	
	public boolean startsWith(String prefix){
		char[]cArray=prefix.toCharArray();
		TrieNode node=root;
		for(int i=0;i<cArray.length;i++){
			if(node.child[cArray[i]-'a']!=null){
				node=node.child[cArray[i]-'a'];
			}
			else{
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
