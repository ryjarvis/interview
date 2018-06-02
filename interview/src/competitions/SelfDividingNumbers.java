package competitions;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
	
    public static List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> res=new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
        	String val=String.valueOf(i);
        	if(val.contains("0")){
        		continue;
        	}
        	for(int j=0;;j++){
        		if(j==val.length()){
        			res.add(i);
        			break;
        		}
        		if((i%Character.getNumericValue(val.charAt(j)))!=0){
        			break;
        		}        		
        	}       	
        }
        return res;
    }
    //uwi solution
    public List<Integer> selfDividingNumbersUwi(int left, int right) {
    	List<Integer> ret = new ArrayList<>();
    	outer:
        for(int i = left;i <= right;i++){
        	for(int j = i;j > 0;j /= 10){
        		int k = j % 10;
        		if(k == 0)continue outer;
        		if(i % k != 0)continue outer;
        	}
        	ret.add(i);
        }
    	return ret;
    }
    
    public static List<Integer> selfDividingNumbersImproved(int left,int right){
    	List<Integer> res=new ArrayList<Integer>();
    	for(int i=left;i<=right;i++){
    		if(ok(i)) res.add(i);
    	}
    	return res;
    	
    }
    public static boolean ok(int num){
    	int x=num;
    	while(x>0){
    		if(x%10==0) return false;
    		if(num%(x%10)!=0){
    			return false;
    		}
    		x/=10;
    	}
    	return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer>res=selfDividingNumbersImproved(1, 22);
		for(Integer i:res){
			System.out.println(i);
		}

	}

}
