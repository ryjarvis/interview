package string;

import java.util.ArrayList;
import java.util.List;

//LintCode #1045
public class PartitionLabels {

	public static List<Integer> partitionLabels(String S) {
		List<Integer> res=new ArrayList<>();
		if(S.length()==0){
			return res;
		}
		int idx = 0;
		int first_idx=0;
		int[]map=new int[26];
		for(int i=0;i<S.length();i++){
			map[S.charAt(i)-'a']=i;
		}
		int last_idx;
		while(first_idx<S.length()){
			idx=first_idx;
			last_idx=map[S.charAt(first_idx)-'a'];
			while(idx!=last_idx){
				last_idx=Math.max(map[S.charAt(idx)-'a'], last_idx);
				idx++;
			}
			res.add(last_idx-first_idx+1);
			first_idx=last_idx+1;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res=partitionLabels("ababcbacadefegdehijhklij");
	}

}
