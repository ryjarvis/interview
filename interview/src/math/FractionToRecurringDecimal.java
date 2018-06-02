package math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ryjarvis
 * Jan 20, 2018
 * 
 */
//LeetCode #166
public class FractionToRecurringDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {
        Long num=Long.valueOf(numerator);
        Long den=Long.valueOf(denominator);
        if(num==0){
            return "0";
        }
        boolean sign=((numerator>>31)^(denominator>>31))==0?true:false;
        num=num<0?-num:num;
        den=den<0?-den:den;
        Map<Long,Integer> map=new HashMap<>();
        StringBuilder sb=new StringBuilder();
        if(!sign){
            sb.append("-");
        }
        Long q=(long)(num/den);
        sb.append(q);
        Long rem=num%den;
        if(rem==0){
            return sb.toString();
        }
        else{
            sb.append(".");
            map.put(rem,sb.length());
            rem*=10;
        }
        while(rem!=0){
            q=rem/den;
            rem%=den;
            if(map.containsKey(rem)){
                int pos=map.get(rem);
                sb.insert(pos,"(");
                sb.append(q);
                sb.append(")");
                break;
            }
            sb.append(q);
            map.put(rem,sb.length());
            
            rem*=10;
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


