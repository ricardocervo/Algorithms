package algorithms.datastructure.graph.bfs.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex {
	int data;
	boolean visited;
	List<Vertex> neighbors = new ArrayList<>();
	
	public Vertex(int data) { this.data = data;	}

	@Override
	public String toString() {
		return "(" + data + ", " + visited + ")";
	}
	
}

public class BFSTest {
	
	void bfs(Vertex root) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(root);
		root.visited = true;
		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			System.out.println(current);
			for (Vertex nei : current.neighbors) {
				if (!nei.visited) {
					queue.add(nei);
					nei.visited=true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		
		v0.neighbors = Arrays.asList(v1, v5, v6);
		v1.neighbors = Arrays.asList(v3, v4, v5);
		v4.neighbors = Arrays.asList(v2, v6);
		v6.neighbors = Arrays.asList(v0);
		new BFSTest().bfs(v1);
	}
}
