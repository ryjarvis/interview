package string;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

//LeetCode 17
public class LetterCombinationsOfPhoneNumber {
	
	public static List<String> letterCombinations(String digits) {
		List<String> digitList=new ArrayList<String>();
		List<String> result=new ArrayList<String>();
		//char[] arr=new char[digits.length()];
		boolean invalid=false;
		if(digits.isEmpty()){
			invalid=true;
		}
		int i=0;
		while(!invalid&&i<digits.length()){
			switch(digits.charAt(i)){
			case '2':
				digitList.add("abc");
				break;
			case '3':
				digitList.add("def");
				break;
			case '4':
				digitList.add("ghi");
				break;
			case '5':
				digitList.add("jkl");
				break;
			case '6':
				digitList.add("mno");
				break;
			case '7':
				digitList.add("pqrs");
				break;
			case '8':
				digitList.add("tuv");
				break;
			case '9':
				digitList.add("wxyz");
				break;
			default:
			invalid=true;
			break;
			}
			i++;
		}
		if(invalid){
			return new ArrayList<String>();
		}
		return letterCombinationsHelper(result,digitList,0);

	}
	
	public static List<String> letterCombinationsHelper(List<String>result,List<String>digits,int level){
		String s=digits.get(level);
		char[] c=new char[digits.size()];
		List<String> aux=new ArrayList<String>();
		for(int i=0;i<s.length();i++){
			c[0]=s.charAt(i);
			result.add(String.valueOf(c));
		}
		level++;
		while(level<digits.size()){
			s=digits.get(level);
			aux=new ArrayList<String>();
			aux.addAll(result);
			result=new ArrayList<String>();
			for(int i=0;i<s.length();i++){
				for(int j=0;j<aux.size();j++){
					char[]temp=aux.get(j).toCharArray();
					temp[level]=s.charAt(i);
					result.add(String.valueOf(temp));
				}
			}
			level++;
		}	
		return result;
		
	}
	
    public List<String> letterCombinationsOptimized(String digits) {
        final char[][] c={{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},
                         {'t','u','v'},{'w','x','y','z'}};
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        helper(res,digits,0,c,new StringBuilder());
        return res;   
    }
    
    public void helper(List<String> res,String digits,int level,char[][]c,StringBuilder sb){
        if(level==digits.length()){
            res.add(sb.toString());
            return;
        }
        int idx=digits.charAt(level)-'0'-2;
        for(char ch:c[idx]){
            sb.append(ch);
            helper(res,digits,level+1,c,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res=letterCombinations("6");
		System.out.println(res.size());
		for(String s:res){
			System.out.println(s);
		}

	}

}
