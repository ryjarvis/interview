package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//LeetCode #692
public class TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		int n = words.length;
		List<String> res = new ArrayList<>();
		List<Set<String>> count = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (String w : words) {
			Integer val = map.get(w);
			if (val == null) {
				val = 0;
			} else {
				count.get(val-1).remove(w);
			}
			map.put(w, val + 1);
			if (val == count.size()) {
				count.add(new TreeSet<String>((a, b) -> a.compareTo(b)));
			}
			count.get(val).add(w);
		}
		int i = count.size() - 1;
		while (res.size() != k) {
			Set<String> temp = count.get(i);
			if (res.size() + temp.size() <= k) {
				res.addAll(temp);
			} else {
				for (String s : temp) {
					res.add(s);
					if (res.size() == k) {
						break;
					}
				}

			}
			i--;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[]ar={"i", "love", "leetcode", "i", "love", "coding"};
		List<String>res=topKFrequent(ar, 2);
	}

}
