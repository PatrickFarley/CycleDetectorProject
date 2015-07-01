package graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeuronGraph {
	private List<Integer>[] adj_data;
	private int vertexCount;

	
	public NeuronGraph(int vertexCount) {
		this.vertexCount = vertexCount;
	}
	
	/** 
	 *  Given the appropriately-formatted .txt file, this method fills the adjacency
	 *  list adj_data with the neural connection data. If the file cannot be opened
	 *  or read, an exception is thrown and message printed.
	 * @param filename
	 * @throws IOException
	 */
	public void fillGraph(String filename) throws IOException {

		adj_data = (List<Integer>[])new ArrayList[vertexCount];
		// String to hold the scanned line
		String line;
		// String array to hold the individual strings in the line:
		String[] line_split = new String[3];
		// integer values to hold the int data from each line:
		int from; 	// the ID of a neuron
		int conns;	// the number of connections it has to the 'other' neuron
		int to; 	// the ID of the other neuron
		// scanner object for file scanning:
		Scanner sc = new Scanner(new File(filename));

		while (sc.hasNextLine())    {
			line = sc.nextLine().trim(); // fill the line String
			//System.out.println(line);	 
			line_split = line.split("\\s+");	// fill the line_split array

			// assign the relevant integers from the line_split array
			from = Integer.parseInt(line_split[0]);
			if (line_split.length > 2)
				conns = Integer.parseInt(line_split[2]);
			to = Integer.parseInt(line_split[1]);

			// go to the main data array and add to adjacency lists appropriately
			if (adj_data[from] == null)
				adj_data[from] = new ArrayList<Integer>();
			adj_data[from].add(to);
		}


	}

	/**
	 * Constructs a CycleDetector class (passing in the adjacency list) and requests a search for cycles,
	 * passing in the vertex of focus.
	 * @return
	 */
	public String cycleTest(int v){
		CycleDetector detector = new CycleDetector(adj_data, adj_data.length);
		String result = detector.findCycleForVertex(v);
		return result;
	}
}
