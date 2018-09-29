package bitmanipulation;

/**
 * @author: ryjarvis
 * Jun 5, 2018
 * 
 */
//LeetCode #318
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
    	int max=0;
    	int n=words.length;
    	if(n==0) return 0;
    	int[]mem=new int[n];
    	mem[0]=charToBit(words[0]);
    	for(int i=0;i<n;i++){
    		for(int j=i+1;j<n;j++){
    			if(i==0){
    				mem[j]=charToBit(words[j]);
    			}
    			if((mem[i]&mem[j])==0&&words[i].length()*words[j].length()>max){
    				max=words[i].length()*words[j].length();
    			}
    		}
    	}
    	return max;
       
    }
    
    public int charToBit(String s){
    	int val=0;
    	for(char c:s.toCharArray()){
    		val|=1<<c-'a';
    	}
    	return val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


