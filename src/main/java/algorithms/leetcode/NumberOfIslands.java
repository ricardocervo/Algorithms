package algorithms.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class NumberOfIslands {

    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    consume(grid, row, col);
                }
            }
        }
        return count;
    }

    void consume(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        consume(grid, row, col + 1);
        consume(grid, row + 1, col);
        consume(grid, row, col - 1);
        consume(grid, row - 1, col);
    }

    @Test
    public void test1() {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        assertEquals(1, numIslands(grid));

    }

    @Test
    public void test2() {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        assertEquals(3, numIslands(grid));
    }

    @Test
    public void test3() {
        char[][] grid = {
                { '1', '0', '1', '0', '1' },
                { '0', '1', '0', '1', '0' },
                { '0', '0', '0', '0', '0' },
                { '1', '1', '1', '1', '1' }
        };

        assertEquals(6, numIslands(grid));
    }
}
