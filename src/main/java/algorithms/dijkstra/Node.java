package algorithms.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Node> {

	private int id;
	private int estimative = Integer.MAX_VALUE;
	private Node predecessor;
	private Map<Node, Integer> mapAjacencies = new HashMap<>();

	
	public Node(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstimative() {
		return estimative;
	}

	public void setEstimative(int estimative) {
		this.estimative = estimative;
	}
	public Node getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}
	public Map<Node, Integer> getMapAjacencies() {
		return mapAjacencies;
	}
	
	public void setMapAjacencies(Map<Node, Integer> mapAjacencies) {
		this.mapAjacencies = mapAjacencies;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", estimative=" + estimative + ", predecessor=" + (predecessor == null ? "null" : predecessor.getId()) + "]";
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.estimative, o.estimative);
	}
	
}
