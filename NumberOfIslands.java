/*
    Date: 17th June 2022
    Author: Shaik Faizan Roshan Ali
    Link: https://leetcode.com/problems/number-of-islands/
    Description: This question is about finding the connected components in a graph (i.e. consider graph to be a matrix)
    Algorithm: DFS flood fill algorithm
**/

class Solution {
    
    public int numIslands(char[][] grid) {
        
        int count = 0;
        
        for(int row = 0; row < grid.length; row++) {
            
            for(int col = 0; col < grid[0].length; col++) {
                
                if(grid[row][col] == '1') {
                    
                    findConnectedComponents(grid, row, col);
                    
                    count++;
                }
            }
        }
        return count;
    }
    
    public void findConnectedComponents(char[][] grid, int row, int col) {
        
        boolean isOutside = ( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length );
        
        if(isOutside == false && grid[row][col] == '1') {

            grid[row][col] = 'X';
            findConnectedComponents(grid, row+1, col); /* Move  South */
            findConnectedComponents(grid, row-1, col); /* Move  North */
            findConnectedComponents(grid, row, col+1); /* Move  East */
            findConnectedComponents(grid, row, col-1); /* Move  West */
        }
    }
}
