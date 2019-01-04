package ds.graph;

import ds.linked_list.LinkedList;
import ds.linked_list.Node;

public class Graph {
	private int maxVertices; // Max number of vertices.
	private int vertexCount; // Number of vertices.
	private int[] eCount; // Number of edges for each vertex.

	private LinkedList[] vertexList; // Array of vertices (Vertex is first node, Edges follow).

	public Graph(int maxVertices) {
		super();
		this.maxVertices = maxVertices;
		this.vertexCount = 0;
		this.eCount = new int[maxVertices];
		vertexList = new LinkedList[maxVertices];

	}

	// Add a new vertex to the list.
	// If it doesn't already exist or max out the array.
	public void addVertex(String vertex) {
		boolean foundVertex = false;

		if (vertexCount < maxVertices) {
			for (int i = 0; i < vertexCount; i++) {
				if (vertexList[i].getFirstNode().getValue().equals(vertex)) {
					// Already have that vertex
					foundVertex = true;
					break;
				}
			}

			// Vertex doesn't exist so add it to the vertex list.
			if (!foundVertex) {
				vertexList[vertexCount] = new LinkedList();
				vertexList[vertexCount].insertFirst(vertex);
				vertexCount++;
			}
		} else {
			System.out.println("Reached limit. Can't add anymore Vertices");
		}
	}

	// If the source Vertex exists add edge to next node in list.
	public String addEdge(String src, String dest) {
		String msg = "Vertex: " + src + " doesn't exist!";

		for (int i = 0; i < vertexCount; i++) {
			if (vertexList[i].getFirstNode().getValue().equals(src)) {
				// Found the vertex add the edge.
				vertexList[i].insertLast(dest);
				// Increment the number of edges for this vertex.
				eCount[i]++;
				msg = "Successfully inserted edge: " + dest + " into: " + src;
				break;
			}
		}

		return msg;
	}

	// Display list of vertices.
	public void displayVertices() {
		for (int i = 0; i < vertexCount; i++) {
			System.out.println(vertexList[i].getFirstNode().getValue());
		}
	}

	// Display list of vertices with their edges.
	public void displayVerticesWithEdges() {
		System.out.println("\nVertices and their Edges ->");
		for (int i = 0; i < vertexCount; i++) {
			Node<Object> v = vertexList[i].getFirstNode();
			System.out.println("\nVertex -> " + v.getValue() + "");
			while (v.getNextNode() != null) {
				v = v.getNextNode();
				System.out.print("\t--> " + v.getValue());
			}
		}
	}

}
