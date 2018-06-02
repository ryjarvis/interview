package hashtable;

import java.util.HashMap;
import java.util.Map;

//LeetCode #535
public class EncodeAndDecodeTinyURL {
	
    Map<String,String> coded=new HashMap<String,String>();
    Map<String,String> reverse=new HashMap<String,String>();
    static String BASE="http://tinyurl.com/";
    static String CHARSET="QWERTqwertYUIOPyuiopASDFGasdfgHJKLhjklZXCVBzxcvbNMnm1234567890";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	if(reverse.containsKey(longUrl)) return BASE+reverse.get(longUrl);
    	StringBuffer sb;
    	do{
    		sb=new StringBuffer();
    		for(int i=0;i<6;i++){
    			int rand=(int)Math.random()*CHARSET.length();
    			sb.append(CHARSET.charAt(rand));
    		}
    	}while (coded.containsKey(sb.toString()));
    	coded.put(sb.toString(),longUrl);
    	reverse.put(longUrl, sb.toString());	
    	return BASE+sb.toString();
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String shorted=shortUrl.replace(BASE, "");
    	String res="";
    	if(!shorted.isEmpty()){
    		res=coded.get(shorted);
    	}
    	return res==null?"":BASE+res;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
