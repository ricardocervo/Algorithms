package algorithms.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BfsAndDfsSearch {

    private class Vertex {
        int data;
        boolean visited;
        List<Vertex> neighbors = new ArrayList<>();

        public Vertex(int data) {
            this.data = data;
        }
    }
    
    private void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.visited = true;
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            System.out.print(current.data + ", ");
            for (Vertex neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                }
            }
        }
        System.out.println();
    }

    private void dfs(Vertex root) {
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        root.visited = true;
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            System.out.print(current.data + ", ");
            for (Vertex neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    stack.push(neighbor);
                    neighbor.visited = true;
                }
            }
        }
        System.out.println();
    }

    private Vertex graph1() {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

          /*************
                v0
              /    \
             v1     v2
             /\     / \
            v3 v4  v5  v6
            
          ***************/
        v0.neighbors = Arrays.asList(v1, v2);
        v1.neighbors = Arrays.asList(v3, v4);
        v2.neighbors = Arrays.asList(v5, v6);

        return v0;
    }

    private Vertex graph2() {
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
        
        return v0;
    }

    public static void main(String[] args) {
        BfsAndDfsSearch program = new BfsAndDfsSearch();
        
        System.out.println("BFS: ");
        program.bfs(program.graph1());
        System.out.println();
        System.out.println("DFS: ");
        program.dfs(program.graph1());
        
        System.out.println("\n\n======================\n\n");
        
        System.out.println("BFS: ");
        program.bfs(program.graph2());
        System.out.println();
        System.out.println("DFS: ");
        program.dfs(program.graph2());
        
    }
}
