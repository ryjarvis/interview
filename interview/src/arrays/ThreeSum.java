package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		int i=0;
		int k;
		int j;
		int target;
		int prev;
		int length=nums.length;
		Arrays.sort(nums);
		int lastFirst=Arrays.binarySearch(nums, 0);
		lastFirst=lastFirst<0?(-1*lastFirst)-2:lastFirst;
		if(length<3||nums[length-1]<0||nums[0]>0){
			return result;
		}
		while(i<=lastFirst){
			k=length-1;
			j=i+1;
			target=-nums[i];
			
			if(i-1>=0&&nums[i]==nums[i-1]){
				i++;
				continue;
			}

			while(k>j){
				
				if(nums[j]+nums[k]>target){
					k--;
				}
				else if(nums[k]+nums[j]<target){
					j++;
				}
				else{
					result.add(Arrays.asList(nums[i],nums[j],nums[k]));
					prev=nums[j];
					while(nums[j]==prev&&j<k){
						j++;
					}
					prev=nums[k];
					while(nums[k]==prev&&k>j){
						k--;
					}
				}
			}
			i++;
			
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res=threeSum(nums);
		System.out.println(res);
	}

}
