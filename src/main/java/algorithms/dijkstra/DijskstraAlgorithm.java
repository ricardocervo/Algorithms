package algorithms.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import algorithms.sorting.HeapSort;

public class DijskstraAlgorithm {

	List<Node> graph;

	void initGraph() {
		graph = new ArrayList<>();

		for (int i=0; i<6; i++) {
			graph.add(new Node(i));
		}
		
		graph.get(0).setEstimative(0);
		
		graph.get(0).getMapAjacencies().put(graph.get(1), 10);
		graph.get(0).getMapAjacencies().put(graph.get(2), 5);
		
		graph.get(1).getMapAjacencies().put(graph.get(3), 1);
		
		graph.get(2).getMapAjacencies().put(graph.get(1), 3);
		graph.get(2).getMapAjacencies().put(graph.get(3), 8);
		graph.get(2).getMapAjacencies().put(graph.get(4), 2);
		
		graph.get(3).getMapAjacencies().put(graph.get(4), 4);
		graph.get(3).getMapAjacencies().put(graph.get(5), 4);
		
		graph.get(4).getMapAjacencies().put(graph.get(5), 6);
	}

	void test() {
		initGraph();
		dijkstra();
		
		for (Node node : graph) {
			System.out.println(node);
		}

	}
	
	void dijkstra() {
		PriorityQueue<Node> heap = new PriorityQueue<Node>();
		
		heap.addAll(graph);
		while (!heap.isEmpty()) {
			Node current = heap.poll(); 
			for (Node neighbor : current.getMapAjacencies().keySet()) {
				int distance = current.getMapAjacencies().get(neighbor);
				neighbor.setEstimative(Math.min(neighbor.getEstimative(), current.getEstimative() + distance));
			}
		}
	}
	
	public static void main(String[] args) {
		new DijskstraAlgorithm().test();
	}
}
