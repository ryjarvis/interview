package arrays;

public class MedianOfTwoSortedArrays {

	// this solution works based on Merge algorithm in the mergesort and has
	// O(N)
	public static double medianFinderByMerge(int[] a, int[] b) {
		boolean isEven = (a.length + b.length) % 2 == 0 ? true : false;
		int[] mergedArray = new int[a.length + b.length];
		int j = 0, k, i = 0;
		for (k = 0; k < mergedArray.length; k++) {
			if (i < a.length && (j >= b.length || a[i] < b[j])) {
				mergedArray[k] = a[i];
				i++;
			} else {
				mergedArray[k] = b[j];
				j++;
			}
		}
		if (isEven) {
			return ((double) mergedArray[(int) (a.length + b.length) / 2]
					+ (double) mergedArray[((int) (a.length + b.length) / 2) - 1]) / 2.0;
		} else {
			return mergedArray[(int) (a.length + b.length) / 2];
		}
	}

	public static double findMedianSortedArrays1(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, 0, m - 1, B, 0, n - 1, (m + n) / 2);
		else { // even
			return (findKth(A, 0, m - 1, B, 0, n - 1, (m + n) / 2) + findKth(A, 0, m - 1, B, 0, n - 1, (m + n) / 2 - 1))
					* 0.5;
		}
	}

	public static int findKth(int A[], int p1, int r1, int B[], int p2, int r2, int k) {
		int n1 = r1 - p1 + 1;
		int n2 = r2 - p2 + 1;

		// base cases
		if (n1 == 0) {
			return B[p2 + k];
		}
		if (n2 == 0) {
			return A[p1 + k];
		}
		//
		if (k == 0) {
			return Math.min(A[p1], B[p2]);
		}

		// select two index i,j from A and B respectively such that If A[i] is
		// between B[j] and B[j-1]
		// Then A[i] would be the i+j+1 smallest element because.
		// Therefore, if we choose i and j such that i+j = k-1, we are able to
		// find the k-th smallest element.
		// int i = (n1/(n1+n2))*k;//let's try tp chose a middle element close to
		// kth element in A
		int i = (n1 / (n1 + n2)) * k;
		int j = k - 1 - i;

		// add the offset
		int mid1 = Math.min(p1 + i, r1);
		int mid2 = Math.min(p2 + j, r2);

		// mid1 is greater than mid2. So, median is either in A[p1...mid1] or in
		// B[mid2+1...r2].
		// we have already see B[p2..mid2] elements smaller than kth smallest
		if (A[mid1] > B[mid2]) {
			k = k - (mid2 - p2 + 1);
			r1 = mid1;
			p2 = mid2 + 1;
		}
		// mid2 is greater than or equal mid1. So, median is either in
		// A[mid1+1...r1] or in B[p2...mid2].
		// we have already see A[p1..mid1] elements smaller than kth smallest
		else {
			k = k - (mid1 - p1 + 1);
			p1 = mid1 + 1;
			r2 = mid2;
		}

		return findKth(A, p1, r1, B, p2, r2, k);
	}

	public static int findKthElementOfTwoSortedArray(int[] a, int start_a, int end_a, int[] b, int start_b, int end_b,
			int k) {
		int remainedA = end_a - start_a + 1;
		int remainedB = end_b - start_b + 1;
		if (remainedA == 0) {
			return b[start_b + k];
		}
		if (remainedB == 0) {
			return a[start_b + k];
		}
		if (k == 0) {
			return Math.min(a[start_a], b[start_b]);
		}
		int i = (remainedA / (remainedA + remainedB)) * k;
		int j = k - 1 - i;
		int midA = Math.min(start_a + i, end_a);
		int midB = Math.min(start_b + j, end_b);

		if (b[midB] > a[midA]) {
			k -= (midA - start_a + 1);
			start_a = midA + 1;
			end_b = midB;
			return findKthElementOfTwoSortedArray(a, start_a, end_a, b, start_b, end_b, k);
		} else {
			k -= (midB - start_b + 1);
			start_b = midB + 1;
			end_a = midA;
			return findKthElementOfTwoSortedArray(a, start_a, end_a, b, start_b, end_b, k);
		}
	}

	public static int findKthElementOfTwoSortedArray(int[] a, int[] b, int k) {
		return findKthElementOfTwoSortedArray(a, 0, a.length - 1, b, 0, b.length - 1, k);
	}

	public static double findMedianOfTwoSortedArray(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		if (((m + n) & 1) == 1) {
			return findKthElementOfTwoSortedArray(a, 0, n - 1, b, 0, m - 1, ((m + n) >> 1));
		} else {
			return (findKthElementOfTwoSortedArray(a, 0, n - 1, b, 0, m - 1, ((m + n) >> 1) - 1)
					+ findKthElementOfTwoSortedArray(a, 0, n - 1, b, 0, m - 1, (m + n) >> 1)) * 0.5;
		}
	}

	public static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}

		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}

		int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;

		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
	
	public static int findKthElement(int[]a,int[]b,int start_a,int end_a,int start_b,int end_b,int k){
		int m=end_a-start_a+1;
		int n=end_b-start_b+1;
		if(n>m){
			return findKthElement(b,a,start_b,end_b,start_a,end_a,k);
		}
		if(n<=0){
			return a[k-1+start_a];
		}
		if(k==m+n){
			return Math.max(a[end_a], b[end_b]);
		}
		if(k==1){
			return Math.min(a[start_a], b[start_b]);
		}
		int j=Math.min(k/2, n-1);
		int i=k-j-1;
		int midA=Math.min(start_a+i, end_a);
		int midB=Math.min(start_b+j, end_b);
		if(a[midA]>b[midB]){
			end_a=midA-1;
			k=k-midB+start_b;//k-(midb-startb)
			start_b=midB;
			return findKthElement(a,b,start_a,end_a,start_b,end_b,k);
		}
		else if(b[midB]>a[midA]){
			end_b=midB-1;
			k=k-midA+start_a;
			start_a=midA;
			return findKthElement(a,b,start_a,end_a,start_b,end_b,k);
		}
		else{
			return a[midA];
		}
		
		
		
		
	}
	public static double findKthElement(int[]a,int[] b){
		//return findKthElement(a,b,0,a.length-1,0,b.length-1,k);
		int n=a.length;
		int m=b.length;
		if(m>n){
			return findKthElement(b,a);
		}
		if(m>0&&n>0){
			if((m+n)%2==0){
				return (findKthElement(a,b,0,n-1,0,m-1,(m+n)/2)+findKthElement(a,b,0,n-1,0,m-1,((m+n)/2)+1))*0.5;
			}
			else{
				return (double)findKthElement(a,b,0,n-1,0,m-1,((m+n)/2)+1);
			}
		}
		else if(m==0&&n>0){
			return n%2==0?(a[n/2]+a[(n/2)-1])*0.5:a[(n/2)];
		}
		
		else{
			return -1;
		}
		
	}
	
	

	public static void main(String[] args) {
		int[] a = { 3};
		int[] b = { 1,2,4};
		/*double medianMerge = medianFinderByMerge(a, b);
		System.out.println(medianMerge);
		// double newMethodMerge = medianFinderDivideAndConquer(a, b);
		double newMethodMerge = findMedianSortedArrays1(a, b);
		System.out.println(newMethodMerge);
		double findKth = findMedianOfTwoSortedArray(a, b);
		System.out.println(findKth);
		int kth=findKth(a,0,b,0,4);
		System.out.println(kth);*/
		double kth=findKthElement(a,b);
		System.out.println(kth);
		
	}

}
