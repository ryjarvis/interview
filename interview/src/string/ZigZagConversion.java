package string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	//sub optimal solution
	public static String convert(String s, int numRows) {
		if(s.length()<=numRows||numRows<2){
			return s;
		}
		//StringBuffer sb=new StringBuffer("");
		List<StringBuffer> asb= new ArrayList<StringBuffer>(); 
		for(int i=0;i<numRows;i++){
			asb.add(new StringBuffer());
			asb.get(i).append(s.charAt(i));
		}
		int idx=numRows;
		//zigzag up
		while(idx<s.length()){
			for(int i=0;i<numRows-1;i++){
				if(idx+i>=s.length()){
					break;
				}
				asb.get(numRows-2-i).append(s.charAt(i+idx));
			}
			idx+=numRows-1;
			//zigzag down
			for(int i=0;i<numRows-1;i++){
				if(idx+i>=s.length()){
					break;
				}
				asb.get(1+i).append(s.charAt(i+idx));
			}
			idx+=numRows-1;
		}
		StringBuffer res=new StringBuffer();
		for(StringBuffer arr:asb){
			res.append(arr.toString());
		}
		return res.toString();			
	}
	//better way to solve this would be to for each element do it and do it in one go instead of having to deal with array
	// for example put all the first row elements first by doing P A ... till the last first row element

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res=convert("PAYPALISHIRING ", 5);
		System.out.println(res);

	}

}
