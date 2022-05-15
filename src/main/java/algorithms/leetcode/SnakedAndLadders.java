package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class SnakedAndLadders {
    
    class Vertex {
        int square;
        boolean visited;
        List<Vertex> neighbors = new ArrayList<>();
        
        Vertex(int square) {
            this.square = square;
        }
        
        @Override
        public String toString() {
            return Integer.toString(square);
        }
    }
    
    
    public int snakesAndLadders(int[][] board) {
        return snakesAndLadders2(createBoardOneDimension(board));
    }
    
    public int snakesAndLadders2(int[] board) {
        Vertex[] graph = buildGraph(board);
        return bfs(graph[0], graph[board.length -1], board.length);
    }
    
    public int bfs(Vertex root, Vertex destination, int n) {
        
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        distances[root.square] = 0;
        
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            for (Vertex neighbor : current.neighbors) {
                if (distances[neighbor.square] == -1) {
                    distances[neighbor.square] = distances[current.square] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return distances[n-1];
    }
    
    
    Vertex[] buildGraph(int[] board) {
        Vertex[] graph = new Vertex[board.length];
        
        for (int i=0; i<board.length; i++) {
            graph[i] = new Vertex(i);
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
        for (int i = 0; i < graph.length; i++) {
            System.out.println("node: " + i + ", neighbords = " + toStr(graph[i].neighbors));
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
        }
        
        return board1d;
    }

//    @Test
//    public void test1() {
//        int[][] board = { 
//                { -1, -1, -1, -1, -1, -1 },
//                { -1, -1, -1, -1, -1, -1 },
//                { -1, -1, -1, -1, -1, -1 },
//                { -1, 35, -1, -1, 13, -1 },
//                { -1, -1, -1, -1, -1, -1 },
//                { -1, 15, -1, -1, -1, -1 } };
//        
//        int result = snakesAndLadders(board);
//        assertEquals(4, result);
//    }
//
//    @Test
//    public void test2() {
//        int[][] board = {{-1,-1},{-1,3}};
//        int result = snakesAndLadders(board);
//        assertEquals(1, result);
//    }

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
    
    String toStr(List<Vertex> list ) {
        Vertex[] arr = new Vertex[list.size()]; 
        list.toArray(arr);
        return Arrays.toString(arr);
    }
    
}