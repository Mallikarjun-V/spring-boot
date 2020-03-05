package com.program.arrays;

/**
 * Given a 2d grid map of '1' s (land) and '0' s (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all the four edges of th egrid
 * are surrrounded by water.
 * 
 * Example 1
 * 
 * Input: <br>
 * 11110 11010 11000 00000
 * 
 * Output: 1
 * 
 * Example 2
 * 
 * Input: 11000 11000 00100 00011
 * 
 * Output: 3
 * 
 * 
 * Islands are the '1' s connected horizontally or vertically.
 * 
 * @author MALLIKARJUN
 *
 */
public class NumberOfIslands {
    
    static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    callBFS(grid, i, j);
                }
            }
        }
        return count;
    }
    
    /**
     * makes all the adjacent '1' s to '0'
     * 
     * @param grid
     * @param i
     * @param j
     */
    private static void callBFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
        callBFS(grid, i + 1, j); // check up
        callBFS(grid, i - 1, j); // check down
        callBFS(grid, i, j + 1); // check left
        callBFS(grid, i, j - 1); // check right
    }
    
    public static void main(String[] args) {
        char[][] input = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(numIslands(input));
    }
}
