package competitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: ryjarvis
 * Dec 9, 2017
 * 
 */

class WordFilter {
	//Sample Solution Q624
    Map<String, Set<Integer>> prefixMap = new HashMap<>();
    Map<String, Set<Integer>> suffixMap = new HashMap<>();

    public WordFilter(String[] words) {
        int i = 0;
        for (String word : words) {
            for (int l = 0; l <= word.length(); l++) {
                String prefix = word.substring(0, l);
                if (!prefixMap.containsKey(prefix)) {
                    prefixMap.put(prefix, new TreeSet<>());
                }
                prefixMap.get(prefix).add(-i);
                String suffix = word.substring(word.length() - l);
                if (!suffixMap.containsKey(suffix)) {
                    suffixMap.put(suffix, new TreeSet<>());
                }
                suffixMap.get(suffix).add(-i);
            }
            i++;
        }
    }

    public int f(String prefix, String suffix) {
        if (!prefixMap.containsKey(prefix) || !suffixMap.containsKey(suffix)) {
            return -1;
        }
        return getCommon(prefixMap.get(prefix), suffixMap.get(suffix));
    }

    private int getCommon(Set<Integer> a, Set<Integer> b) {
        if (a.size() > b.size()) {
            Set<Integer> t = a;
            a = b;
            b = t;
        }
        for (Integer integer : a) {
            if (b.contains(integer)) {
                return -integer;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "aaee"});
        System.out.println(wordFilter.f("a", "e"));
        System.out.println(wordFilter.f("b", ""));
    }
}


