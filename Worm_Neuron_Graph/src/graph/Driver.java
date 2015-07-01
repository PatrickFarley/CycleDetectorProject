package graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Driver {

	// enter a vertex id of a neuron (1-302 in this case)
	private final static int originalVertex = 1;

	
	private final static int vertexCount = 350;
	/**
	 * This program will first fill a graph from a file source, then it will call the 
	 * graph to look for cycles that include a given specified vertex. It will print 
	 * the result of this search.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NeuronGraph graph = new NeuronGraph(vertexCount);
			graph.fillGraph("source.txt");
			String result = graph.cycleTest(originalVertex);
			System.out.println(result);
		
		} catch (IOException e) {
			System.out.println("invalid file input");;
		}

	}
	

}
