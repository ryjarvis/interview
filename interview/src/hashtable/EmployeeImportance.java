package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ryjarvis
 * Apr 29, 2018
 * 
 */

public class EmployeeImportance {
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	};
    public int getImportance(List<Employee> emp, int id) {
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee e:emp){
        	map.put(e.id, e);
        }
        int count=dfs(map.get(id),map);
        return count;
    }
    
    public int dfs(Employee emp,Map<Integer,Employee>map){
    	int count=emp.importance;
    	for(int id:emp.subordinates){
    		count+=dfs(map.get(id),map);
    	}
    	return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


