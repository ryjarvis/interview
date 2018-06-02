package math;

/**
 * @author: ryjarvis
 * May 4, 2018
 * 
 */
//LeetCode #492
public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[]res=new int[2];       
        int sqrt=(int)Math.sqrt(area);
        int l=sqrt;
        int w=sqrt;
        while(true){
            if(l*w==area){
                res=new int[]{l,w};
                return res;
            }
            else if(l*w>area){
                w--;
            }
            else{
                l++;
            }
        }       
    }
    
    public int[] constructRectangleOptimized(int area) {   
        int sqrt=(int)Math.sqrt(area);      
        while(true){
            if(area%sqrt==0){
                return new int[]{area/sqrt,sqrt};
            }
            sqrt--;
        }       
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


