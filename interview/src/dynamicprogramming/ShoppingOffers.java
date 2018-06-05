package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ryjarvis
 * Jun 4, 2018
 * 
 */
//LeetCode #638
public class ShoppingOffers {
	//fully DP solution although didn't give me the best time but worth trying O(n) memory
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {        
        int min=Integer.MAX_VALUE;
        int n=toNumber(needs);
        int[]mem=new int[n+1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0]=0;
        int mod=1;
        for(int i=price.size()-1;i>=0;i--){
            int aux=mod;
            while(aux<n+1&&aux<(needs.get(i)+1)*mod){
                if(mem[aux-mod]<Integer.MAX_VALUE&&valid(aux,n)){
                    mem[aux]=Math.min(price.get(i)+mem[aux-mod],mem[aux]);
                }
            	aux++;
            }
            mod*=10;
        }
        for(List<Integer>l:special){

        	int deal=l.remove(l.size()-1);
        	int num=toNumber(l);
            if(!valid(num,n)){
                    continue;
            }
        	for(int i=num;i<n+1;i++){
                if(mem[i-num]<Integer.MAX_VALUE){
                    if(validAdd(i-num,num)){
                        mem[i]=Math.min(deal+mem[i-num],mem[i]);
                    }
                }
        	}
        }
        return mem[n];
    }
    
    public boolean validAdd(int i,int j){
        while(i!=0){
            int i1=i%10;
            int j1=j%10;
            if(i1+j1>6) return false;
            i/=10;
            j/=10;
        }
        return true;
    }
    
    public boolean valid(int i,int j){
        while(i!=0){
            int i1=i%10;
            int j1=j%10;
            if(i1>j1) return false;
            i/=10;
            j/=10;
        }
        return true;
    }
    
    public int toNumber(List<Integer> list){
    	int val=0;
    	int mod=(int) Math.pow(10, list.size()-1);
    	for(int i:list){
    		val+=mod*i;
    		mod/=10;
    	}
    	return val;
    	
    }
    
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


