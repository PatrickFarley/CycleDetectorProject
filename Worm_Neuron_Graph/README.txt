
Driver.java is the class that contains the main method. It is also the only class that accepts user input. The “originalVertex” field can be edited to change where in the graph the program will search for cycles

Driver.java constructs an instance of NeuronGraph.java and calls its fillGraph method. NeuronGraph.java contains the code for filling a graph from file data. Driver also calls NeuronGraph’s cycleTest method, wherein it constructs a CycleDetector object and passes in its data, then calls the CycleDetector’s public method findCycleForVertex to get the results of the cycle search.

CycleDetector.java takes the graph data and, when called, computes and returns the path of a cycle, or a message indicating that no cycles were found.

Information Flow:
Driver > NeuronGraph > CycleDetector > NeuronGraph > Driver > System Output

See report for more information..