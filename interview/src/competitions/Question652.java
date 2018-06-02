package competitions;

/**
 * @author: ryjarvis
 * Dec 30, 2017
 * 
 */

public class Question652 {
    public int[] pourWater(int[] heights, int V, int K) {
        for (; V > 0; V--) {
            int minLeft = K;
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] < heights[minLeft])
                    minLeft = i;
                if (heights[i] > heights[minLeft])
                    break;
            }
            if (minLeft < K) {
                heights[minLeft]++;
            } else {
                int minRight = K;
                for (int i = K + 1; i < heights.length; i++) {
                    if (heights[i] < heights[minRight])
                        minRight = i;
                    if (heights[i] > heights[minRight])
                        break;
                }
                heights[minRight]++;
            }
        }
        return heights;
    }
    
    int findLeft(int[] heights,int K)
    {
        int left=-1,min=10000000;
        for (int j=K-1;j>=0;j--)
        {
            if (heights[j+1]<heights[j]) break;
            if (heights[j+1]>heights[j]) left=j;
        }
        return left;
    }
    int findRight(int[] heights,int K)
    {
        int right=-1,min=10000000;
        for (int j=K+1;j<heights.length;j++)
        {
            if (heights[j-1]<heights[j]) break;
            if (heights[j-1]>heights[j]) right=j;
        }
        return right;
    }
    public int[] pourWater2(int[] heights, int V, int K) {
        int n=heights.length,left=findLeft(heights,K),right=findRight(heights,K);
        for (int i=0;i<V;i++)
        {
            if (left>=0)
            {
                heights[left]++;
                left=findLeft(heights,K);
            }
            else
            {
                if (right>=0)
                {
                    heights[right]++;
                    right=findRight(heights,K);
                }
                else 
                {
                    heights[K]++;
                    left=findLeft(heights,K);
                    right=findRight(heights,K);
                }
            }
        }
        return heights;
    }
    
    public int[] pourWater3(int[] a, int V, int K) {
        for(int i = 0;i < V;i++){
        	int cur = K;
        	inner:
        	while(true){
	        	for(int j = cur-1;j >= 0;j--){
	        		if(a[j] < a[cur]){
	        			cur = j;
	        			continue inner;
	        		}
	        		if(a[j] > a[cur])break;
	        	}
	        	for(int j = cur+1;j < a.length;j++){
	        		if(a[j] < a[cur]){
	        			cur = j;
	        			continue inner;
	        		}
	        		if(a[j] > a[cur])break;
	        	}
	        	a[cur]++;
	        	break;
        	}
        }
    	return a;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


