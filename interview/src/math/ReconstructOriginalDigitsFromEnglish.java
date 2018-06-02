package math;

/**
 * @author: ryjarvis
 * May 28, 2018
 * 
 */
//LeetCode #423
public class ReconstructOriginalDigitsFromEnglish {
	//O(n)
    public String originalDigits(String s) {
        int[]count=new int[26];
        int [] num=new int[10];
        for(char c:s.toCharArray()){
        	count[c-'a']++;
        }
        num[0]=count['z'-'a'];
        num[6]=count['x'-'a'];
        num[2]=count['w'-'a'];
        num[8]=count['g'-'a'];
        num[3]=count['h'-'a']-num[8];
        num[7]=count['s'-'a']-num[6];
        num[5]=count['v'-'a']-num[7];
        num[4]=count['f'-'a']-num[5];
        num[1]=count['o'-'a']-num[0]-num[2]-num[4];
        num[9]=count['i'-'a']-num[5]-num[6]-num[8];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
        	if(num[i]==0) continue;
        	for(int j=0;j<num[i];j++){
        		sb.append(i);
        	}
        }
        return sb.toString();        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


