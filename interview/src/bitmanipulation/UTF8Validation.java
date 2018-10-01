package bitmanipulation;
//LeetCode #393
public class UTF8Validation {
	
    public boolean validUtf8(int[] data) {
        int n=data.length;
        if(n==0){return true;}
        int count=0;
        for(int d:data){
            if(count<0) return false;
            else if(count==0){
                count=lastZeroBit(d);
            }
            else{
                if(d>>6==2){
                    count--;
                }
                else{
                    return false;
                }
            }
        }
        return count==0;
    }
    
    public int lastZeroBit(int num){
        int dist=7;
        while(dist>2){
            if(((num>>dist)&1)==0){
                if(dist==6){
                    return -1;
                }
                
                return dist==7?0:7-dist-1;
            }
            dist--;
        }
        return -1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
