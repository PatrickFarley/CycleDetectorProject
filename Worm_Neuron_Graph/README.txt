
Driver.java is the class that contains the main method. The “originalVertex” field can be edited to change where in the graph the program will search for cycles

Driver.java constructs an instance of NeuronGraph.java and calls its fillGraph method. This method creates a graph from file data (referenced as source.txt). Driver.java also calls NeuronGraph’s cycleTest method, wherein it constructs a CycleDetector object and passes in its graph data, then calls the CycleDetector’s method findCycleForVertex to get the results of the cycle search.

CycleDetector.java takes the graph data and, when called, computes and returns the path of a cycle, or a message indicating that no cycles were found.

Data Flow:
Driver > NeuronGraph > CycleDetector > NeuronGraph > Driver > System Output

See Neurron_Graph_Report.doc for more information and a practical use of this program.