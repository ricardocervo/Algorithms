package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class SnakedAndLadders {
    
    private class Vertex {
        boolean visited;
        List<Vertex> neighbors = new ArrayList<>();
        
    }
    
    public int snakesAndLadders(int[][] board) {
        return snakesAndLadders2(createBoardOneDimension(board));
    }
    
    public int snakesAndLadders2(int[] board) {
        Vertex[] graph = buildGraph(board);
        return bfs(graph[0], graph[board.length -1]);
    }
    
    public int bfs(Vertex root, Vertex destination) {
        
        Map<Vertex, Integer> mapDistances = new HashMap<>();
        
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.visited = true;
        mapDistances.put(root, 0);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Vertex neighbor : current.neighbors) {
                if (!neighbor.visited) {
                    mapDistances.put(neighbor, mapDistances.get(current) + 1);
                    neighbor.visited = true;
                    queue.add(neighbor);
                }
            }
        }
        return mapDistances.get(destination);
    }
    
    private Vertex[] buildGraph(int[] board) {
        Vertex[] graph = new Vertex[board.length];
        
        for (int i=0; i<board.length; i++) {
            graph[i] = new Vertex();
        }
        
        for (int i=0; i<graph.length; i++) {
            List<Vertex> neighbors = new ArrayList<>();
            for (int j=1; j <= 6; j++) {
                if (i + j >= board.length) {
                    continue;
                }
                
                if (board[i + j] == -1) {
                    neighbors.add(graph[i + j]);
                } else {
                    int newSquare = board[i + j] - 1;
                    neighbors.add(graph[newSquare]);
                }
            }
            graph[i].neighbors = neighbors;
        }
        return graph;
    }
    
    private int[] createBoardOneDimension(int[][] board) {
        int n = board.length;
        int[] board1d = new int[n*n];
        boolean reversed = false;
        
        int index = 0;
        
        for (int i=board.length-1; i>= 0; i--) {
            if (reversed) {
                for (int j=n-1; j>=0; j--) {
                    board1d[index++] = board[i][j];
                }
            } else {
                for (int j=0; j < n; j++) {
                    board1d[index++] = board[i][j];
                }
            }
            
            reversed = !reversed;
        }
        
        return board1d;
    }

    @Test
    public void test1() {
        int[][] board = { 
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 },
                { -1, -1, -1, -1, -1, -1 },
                { -1, 15, -1, -1, -1, -1 } };
        
        int result = snakesAndLadders(board);
        assertEquals(4, result);
    }

    @Test
    public void test2() {
        int[][] board = {{-1,-1},{-1,3}};
        int result = snakesAndLadders(board);
        assertEquals(1, result);
    }

    @Test
    public void test3() {
        int[][] board = {
                { -1, -1, 19, 10, -1 },
                {  2, -1, -1,  6, -1 },
                { -1, 17, -1, 19, -1 },
                { 25, -1, 20, -1, -1 },
                { -1, -1, -1, -1, 15 } };

        int result = snakesAndLadders(board);
        assertEquals(2, result);
    }
    
}