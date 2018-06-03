package competition87;

/**
 * @author: ryjarvis
 * Jun 2, 2018
 * 
 */

public class Question2 {
	//O(n)
    public static int longestMountain(int[] a) {
    	if(a.length<3) return 0;
        int max=0;
        int up=0;
        int id=-1;
        int down=0;
        int prev=a[0];
        for(int i=1;i<a.length;i++){
        	if(a[i]>prev){
        		if(down==1){
        			up++;
        		}
        		if(up==2){
        			down=0;
        			max=Math.max(max, i-id);
        			up=1;
                    id=i-1;
        		}
        		
        		if(up==0){
        			up++;
        			id=i-1;
        			
        		}
        	}
        	else if(down==0&&a[i]<prev&&up==1){
    			down++;
    		}
            
        	else if(down==1&&a[i]==prev){
        		down=0;
        		up=0;
    			max=Math.max(max, i-id);
    			id=-1;
        	}
        	
        	else if(down==0&&a[i]==prev){
        		id=-1;
        		up=0;
        	}
            
        	prev=a[i];
        }
        if(down==1){
        	max=Math.max(max, a.length-id);
        }
        if(max<3){
            return 0;
        }
        return max;
    }
    
    //other way of solving this
    public int longestMountain2(int[] A) {
		int ret = 0;
		for(int i = 1; i < A.length-1; i++) {
			if(A[i] <= A[i-1] || A[i] <= A[i+1]) continue;
			int low = i;
			int curr = 1;
			while(low > 0 && A[low] > A[low-1]) {
				low--;
				curr++;
			}
			int high = i;
			while(high + 1 < A.length && A[high] > A[high+1]) {
				curr++;
				high++;
			}
			ret = Math.max(ret, curr);
		}
		return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]a={875,884,239,731,723,685};
		int res=longestMountain(a);
		

	}

}


