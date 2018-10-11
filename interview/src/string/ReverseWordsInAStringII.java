package string;
//LintCode #927
//LeetCode #186
public class ReverseWordsInAStringII {
	
    public char[] reverseWords(char[] str) {
        int i=0;
        int j=str.length-1;
       reverseWord(str,i,j);
        int slow=0;
        int fast=0;
       while(fast<str.length){
           if(str[fast]==' '){
               reverseWord(str,slow,fast-1);
               slow=fast+1;
           }
           fast++;
       }
       reverseWord(str,slow,str.length-1);
       return str;
        
    }
    
    public void reverseWord(char[]c,int i,int j){
        while(i<j){
            swap(c,i++,j--);
        }
    }
    
    public void swap(char[]c,int i,int j){
        char aux=c[i];
        c[i]=c[j];
        c[j]=aux;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
