package math;

/**
 * @author: ryjarvis Nov 26, 2017
 * 
 */

//LeetCode 69
public class Sqrt {
	//O(sqrt(x))
	public static int mySqrt(int x) {
		int i=1;
		long res=1;
		while(res<=x){
			
			i++;
			res=(long)i*(long)i;
		}
		return i-1;
	}
	//O(log(n))
	public static int mySqrtImproved(int x){
		int hi=x;
		int lo=0;
		int mid;
		long res=1;
		while(hi-lo>=1){
			mid=lo+((hi-lo)>>1);
			res=(long)mid*mid;
			if(res<x){
				lo=mid+1;
			}
			else if(res==x){
				return mid;
			}
			else{
				hi=mid-1;
			}
		}
		return (hi*hi)<=x?hi:hi-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=10;
		int res=mySqrtImproved(num);
		System.out.println(res);
	}

}
