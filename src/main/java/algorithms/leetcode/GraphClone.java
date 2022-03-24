package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class GraphClone {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
		@Override
		public String toString() {
			return "Node [val=" + val+ "]";
		}
	    

	}
	
	private HashMap<Node, Node> oldToNew = new HashMap<>();

	public Node cloneGraph(Node node) {
		return node == null ? null : dfs(node);
	}
    
    private Node dfs(Node node) {
    	if (oldToNew.containsKey(node)) {
    		return oldToNew.get(node);
    	}
    	
    	Node copy = new Node(node.val, new ArrayList<>());
    	oldToNew.put(node, copy);
    	for (Node neighbor : node.neighbors) {
    		copy.neighbors.add(dfs(neighbor));
    	}
    	return copy;
    }
    
	@Test
    public void test1() {
        Node node0 = new Node(3, new ArrayList<>());
        Node node1 = new Node(7, new ArrayList<>());
        Node node2 = new Node(4, new ArrayList<>());
        Node node3 = new Node(2, new ArrayList<>());
        
        node0.neighbors.add(node1);
        node0.neighbors.add(node3);
        
        node1.neighbors.add(node0);
        node1.neighbors.add(node2);
        
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        
        node3.neighbors.add(node2);
        node3.neighbors.add(node0);

        Node clone = cloneGraph(node0);
        
        printGraph(node0);
        printGraph(clone);
    }
	
	private HashSet<Node> set = new HashSet<>();
	public void printGraph(Node node) {
		if (!set.contains(node)) {
			set.add(node);
			String strNeighbors = "";
			for (Node nei : node.neighbors) {
				if (!strNeighbors.isEmpty()) {
					strNeighbors += ", ";
				}
				strNeighbors += nei.val;
			}
			System.out.println(node.val + ": " + strNeighbors);
			for (Node nei : node.neighbors) {
				printGraph(nei);
			}
		}
	}
	

}
