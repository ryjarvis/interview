package arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: ryjarvis Nov 24, 2017
 * 
 */

public class ManageIntervals {
	
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	//O(1) space
	public List<Interval> merge(List<Interval> intervals){
		//lambada java 8 
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		int i=0;
		while(i<intervals.size()-1){
			Interval current=intervals.get(i);
			Interval next=intervals.get(i+1);
			if(next.start<=current.end){
				intervals.remove(i);
				intervals.add(i,new Interval(current.start,Math.max(current.end, next.end)));
				intervals.remove(i+1);
			}
			else{
				i++;
			}
		}
		return intervals;
	}
	
	//not so good solution
    public List<Interval> mergeBad(List<Interval> intervals) {
    	//List<Interval> res=new ArrayList<Interval>();
    	for(int i=0;i<intervals.size();i++){
    		for(int j=i+1;j<intervals.size();j++){
    			Interval i1=intervals.get(i);
    			Interval i2=intervals.get(j);    			
    			if(Math.max(i1.start, i2.start)>=Math.min(i1.end, i2.end)){
    				intervals.remove(i);
    				intervals.remove(j);
    				intervals.add(i,new Interval(Math.min(i1.start, i2.start),Math.max(i1.end, i2.end)));
    			}
    		}
    	}
        return intervals;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
