package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ryjarvis
 * Jan 13, 2018
 * 
 */
//LeetCode #179
public class LargestNumber {
	//Wrong solution it does sort based on alphabet then by the length
	public String largestNumberWrong(int[] nums) {
        String[]s=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s);
        List<String> list=Arrays.asList(s);        
        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0)==o2.charAt(0))
                {
                    if(o1.length()>o2.length()){
                        return -1;
                    }
                    else{
                       return o1.compareTo(o2); 
                    }
                }
                else{
                    return o1.compareTo(o2);
                }
            }
        });
        //Arrays.sort(s);
        StringBuilder sb=new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
            sb.append(list.get(i));
        }
        return sb.toString();
        
    }
	
	public String largestNumber(int[] nums) {
        String[]s=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(s, (s1, s2) -> (s1+s2).compareTo(s2+s1));
        StringBuilder sb=new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
            sb.append(s[i]);
        }
        return sb.toString();
        
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


