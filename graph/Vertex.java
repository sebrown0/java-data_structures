package ds.graph;

public class Vertex {

	private String vertexID;
	private Edge firstEdge;
	private int numberOfEdges;

	public Vertex(String vertexID) {
		super();
		this.vertexID = vertexID;
		this.firstEdge = null;
		numberOfEdges = 0;
	}

	public Edge getFirstEdge() {
		return firstEdge;
	}

	public String getVertexID() {
		return vertexID;
	}

	public void setVertexID(String vertexID) {
		this.vertexID = vertexID;
	}

	private boolean isEmpty(Edge e) {
		return (e == null);
	}

	// Add edge (vertex) to source vertex.
	public void addEdge(Vertex src, String destId) {
		Edge edge = src.firstEdge;
		Edge temp = null;

		// Has the vertex got any edges?
		if (!isEmpty(edge)) {
			// Loop until we get to an empty edge.
			while (edge != null) {
				temp = edge;
				edge = edge.getNextEdge();
			}
			// Assign source's next edge as the destination.
			temp.setNextEdge(new Edge(destId));
		} else {
			src.firstEdge = new Edge(destId);
		}
		src.numberOfEdges++;
	}

	public int getNumberOfEdges() {
		return numberOfEdges;
	}

	public void incrementNumberOfEdges() {
		this.numberOfEdges++;
	}

}
