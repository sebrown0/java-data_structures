package ds.graph;

import java.util.ArrayList;

import ds.linked_list.LinkedList;

public class Graph {
	private int vCount; // Number of vertices
	private int eCount; // Number of edges
	private ArrayList<Integer>[] adjacents; // Array of integer lists
	private LinkedList[] arrayList;

	public Graph(int vCount) {
		super();
		this.vCount = vCount;
		this.eCount = 0;
		adjacents = new ArrayList[vCount];
		arrayList = new LinkedList[vCount];

		// Create new empty list for each vertex
		for (int i = 0; i < vCount; i++) {
			adjacents[i] = new ArrayList<Integer>();
			arrayList[i] = new LinkedList();
		}
	}

	public int getVertexCount() {
		return vCount;
	}

	public int getEdgeCount() {
		return eCount;
	}

	public void addEdge(int src, int dest) {
		adjacents[src].add(dest);
		eCount++;
	}

	public Object[] adj(int src) {
		return adjacents[src].toArray();
	}
}
