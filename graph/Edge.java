package ds.graph;

public class Edge {

	private String edgeId;
	private Edge nextEdge;
	
	public Edge(String edgeId) {
		super();
		this.edgeId = edgeId;
		this.nextEdge = null;
	}

	public String getEdgeId() {
		return edgeId;
	}

	public void setEdgeId(String edgeId) {
		this.edgeId = edgeId;
	}

	public Edge getNextEdge() {
		return nextEdge;
	}

	public void setNextEdge(Edge nextEdge) {
		this.nextEdge = nextEdge;
	}
	
	
}
