package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Dec 11, 2017
 * 
 */
//LeetCode #155
class MinStack {

    /** initialize your data structure here. */
    long min;
    List<Long> data;
    public MinStack() {
        min=Integer.MAX_VALUE;
        data=new ArrayList<Long>();
    }
    
    public void push(int x) {
        data.add(x-min);
        if(x<min){            
            this.min=x;
        }
    }
    
    public void pop() {
        if(!data.isEmpty()){
            if(data.get(data.size()-1)<0){
                min=-(data.get(data.size()-1))+min;
            }
            data.remove(data.size()-1);
        }
        
    }
    
    public long top() {
        long oldMin;
        if(!data.isEmpty()){
            if(data.get(data.size()-1)<0){
                oldMin=-(data.get(data.size()-1))+min;
            }
            else{
                oldMin=min;
            }
            return (data.get(data.size()-1)+oldMin);
        }
        return -1;
    }
    
    public long getMin() {
        return min;
    }
}


