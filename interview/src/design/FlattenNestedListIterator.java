package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ryjarvis
 * Jan 20, 2018
 * 
 */
//LeetCode #341

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class FlattenNestedListIterator {
	public List<Integer> res;
    public int idx=0;
    public NestedIterator(List<NestedInteger> nestedList) {
        res=new ArrayList<>();
        flat(nestedList);
    }
    
    public void flat(List<NestedInteger> nested){
        for(NestedInteger i:nested){
            if(i.isInteger()){
                res.add(i.getInteger());
            }
            else{
                flat(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return(res.get(idx++));
        
    }

    @Override
    public boolean hasNext() {
        return (idx<res.size());
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


