package sorting;

/**
 * @author: ryjarvis
 * Jan 21, 2018
 * 
 */
//LeetCode #280
public class WiggleSort {
	
	public static void wiggleSort(int[] a) {
		int l=a.length;
		if(l<2)return;
		for(int i=1;i<l;i+=2){
			if(a[i]<a[i-1]){
				swap(a,i,i-1);
			}
			if(i+1<l&&a[i+1]>a[i]){
				swap(a,i,i+1);
			}
		}
	}
	
	public static void swap(int[]ar,int i,int j){
		int temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


