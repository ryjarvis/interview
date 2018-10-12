package design;

import java.util.TreeMap;

/**
 * @author: ryjarvis
 * Oct 11, 2018
 * 
 */
//LeetCode #729
class MyCalendarI {
    TreeMap<Integer,Integer> map;
    public MyCalendarI() {
        map=new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer prev=map.floorKey(start);
        Integer next=map.ceilingKey(start);
        if((prev==null||start>=map.get(prev))&&(next==null||next>=end)){
            map.put(start,end);
            return true;
        }
        return false;
    }
}


