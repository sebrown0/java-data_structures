package ds.graph;

public class App {

	public static void main(String[] args) {

		Graph graph = new Graph(5);
		
		graph.addVertex("State St");
		graph.addVertex("Avenel St");
		graph.addVertex("Pocono St");
		graph.addVertex("William Ave");
		graph.addVertex("Elm St");
		
		graph.addEdge("State St", "Avenel St");
		graph.addEdge("State St", "Elm St");
		graph.addEdge("Avenel St", "Pocono St");
		graph.addEdge("Pocono St", "Elm St");
		graph.addEdge("William Ave", "Pocono St");
		graph.addEdge("William Ave", "State St");
		graph.addEdge("Elm St", "Avenel St");
		
		graph.displayVerticesWithEdges();
		
	}

}
