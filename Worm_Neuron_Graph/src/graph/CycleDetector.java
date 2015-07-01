package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CycleDetector {

	
	private boolean marked[];
    private boolean onStack[];
    private List<Integer>[] adj_data;
    
    public CycleDetector(List[] adj, int n) {
    	adj_data = adj;
    	marked = new boolean[n];
        onStack = new boolean[n];
    }
    
    /**
     * A wrapper-method for the "detectCycles" method. Adds some explanatory detail to the returned String,
     * and also reverses the cycle path so it reads in the direction of edges.
     */
    public String findCycleForVertex(int v){
    	String result = detectCycles(v,v);
    	if (result == "") {
    		// the case of no cycles detected:
    		return	"no cycles found for vertex "+v;
    	} else {
    		// in this case, there was a cycle detected:
    		String[] temp = result.split("\\s+"); // make result string an array
    		Collections.reverse(Arrays.asList(temp)); // reverse the order of the array
    		return "cycle found!\n"+ Arrays.toString(temp); // convert back to a single string
   
    	}
    }
	
	/**
	 *  A recursive algorithm for detecting cycle(s) that include a given original vertex.
	 *  If a cycle is triggered, it returns a space-separated String of vertex ids that track 
	 *  the path of a cycle up to the current vertex. If no cycles were found, an empty string
	 *  is returned
	 */
	private String detectCycles(int v, int original) {

		marked[v] = true; // the vertex we're currently on
		onStack[v] = true;

		if (adj_data[v] == null){
			return "";
		}
		
		for (Integer i : adj_data[v]) {
			if (marked[i] == false) {
				// if it has not been done already, do DFS of the vertex i
				String res = detectCycles(i,original);
				if (res != ""){
					// if a cycle was found somewhere in this recursive stack...
					return res +" "+ v; // take the path-tracking string and append this vertex id to it
				}
			} else if (onStack[i]==true && i == original) { 
				// if i has already been marked, AND i is in the current recursive stack and is the
				// original vertex, then we know we have found a cycle	
				return ""+v; // return the current vertex id
			}
		}
		onStack[v] = false;
		return "";
	}
	

}
