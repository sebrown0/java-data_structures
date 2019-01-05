package ds.graph;

public class Graph {
	private int maxVertices; // Max number of vertices.
	private int vertexCount; // Number of vertices.
	private Vertex[] vList;

	public Graph(int maxVertices) {
		super();
		this.maxVertices = maxVertices;
		this.vertexCount = 0;

		vList = new Vertex[maxVertices];
	}

	// Add a new vertex to the list.
	// If it doesn't already exist or max out the array.
	public Vertex addVertex(String vertexId) {
		boolean foundVertex = false;
		Vertex returnVertex = null;

		if (vertexCount < maxVertices) {
			for (int i = 0; i < vertexCount; i++) {
				if (vList[i].getVertexID().equals(vertexId)) {
					// Already have that vertex
					foundVertex = true;
					break;
				}
			}

			// Vertex doesn't exist so add it to the vertex list.
			if (!foundVertex) {
				vList[vertexCount] = new Vertex(vertexId);
				returnVertex = vList[vertexCount];
				vertexCount++;

			}
		} else {
			System.out.println("Reached limit. Can't add anymore Vertices");
		}

		return returnVertex;
	}

	// If the source Vertex exists add edge to the in list.
	public String addEdge(String src, Vertex dest) {
		String msg = "Vertex: " + src + " doesn't exist!";

		for (int i = 0; i < vertexCount; i++) {
			if (vList[i].getVertexID().equals(src)) {
				// Found the vertex add the edge.
				vList[i].addEdge(vList[i], dest.getVertexID());
				msg = "Successfully inserted edge: " + dest.getVertexID() + " into: " + src;
				break;
			}
		}

		return msg;
	}

	// Display list of vertices.
	public void displayVertices() {
		for (int i = 0; i < vertexCount; i++) {
			System.out.println(vList[i].getVertexID());
		}
	}

	// Display list of vertices with their edges.
	public void displayVerticesWithEdges() {
		System.out.println("\nVertices and their Edges.");
		for (int i = 0; i < vertexCount; i++) {
			System.out.println("\nVertex -> " + vList[i].getVertexID());
			Edge edge = vList[i].getFirstEdge();
			while (edge != null) {
				System.out.print("\t--> " + edge.getEdgeId());
				edge = edge.getNextEdge();
			}
		}
	}
}
