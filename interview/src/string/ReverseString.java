package string;

/**
 * @author: ryjarvis
 * Feb 6, 2018
 * 
 */
//LeetCode #344
public class ReverseString {
	
    public String reverseString(String s) {
        if(s.isEmpty()){
            return s;
        }
        char[]ch=s.toCharArray();
        int mid=ch.length/2;
        for(int i=0;i<=mid&&ch.length-1-i>=mid;i++){
            swap(ch,i,ch.length-1-i);
        }
        return new String(ch);
    }
    
    public void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


