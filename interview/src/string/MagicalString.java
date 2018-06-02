package string;

/**
 * @author: ryjarvis Jun 1, 2018
 * 
 */
// LeetCode #481
public class MagicalString {

    public static int magicalString(int n) {
        if(n==0)return 0;
        if(n<=3){
            return 1;
        }
       int[] mem=new int[n];
		mem[0]=1;
		mem[1]=2;
		mem[2]=2;
		int end=2;
		int count=1;
		int start=2;
		while(end<n-1){
			int temp=0;
			for(int i=0;i<mem[start]&&end+i+1<n;i++){
				temp++;
				mem[end+i+1]=3-mem[end];
			}
			if(mem[end]==2){
				count+=temp;
			}
			end+=temp;
			start++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		magicalString(11);
	}

}
