package ds.graph;

public class App {

	public static void main(String[] args) {

		Graph graph = new Graph(5);
		
		Vertex vState =  graph.addVertex("State St");
		Vertex vAvenel = graph.addVertex("Avenel St");
		Vertex vPocono = graph.addVertex("Pocono St");
		Vertex vWilliam = graph.addVertex("William Ave");
		Vertex vElm = graph.addVertex("Elm St");
		graph.displayVertices();
		
		System.out.println(graph.addEdge("State St", vAvenel));
		System.out.println(graph.addEdge("State St", vElm));

		System.out.println(graph.addEdge("Avenel St", vPocono));
		
		graph.addEdge("Pocono St", vElm);
		
		graph.addEdge("William Ave", vPocono );
		graph.addEdge("William Ave", vState);
		
		graph.addEdge("Elm St", vAvenel);
		graph.addEdge("Elm St", vWilliam);
		
		graph.displayVerticesWithEdges();
		
	}

}
