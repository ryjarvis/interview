package competitions;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
	List<int[]> list;

	public MyCalendar() {
		this.list = new ArrayList<int[]>();
	}

	public boolean book(int start, int end) {
		for(int[] a:list){
			if(Math.max(a[0], start)<Math.min(a[1], end)){
				return false;
			}			
		}
		list.add(new int[]{start,end});
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
