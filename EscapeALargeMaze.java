/* 
    Author: Shaik Faizan Roshan Ali
    Date: 27th May 2022
    Link: https://leetcode.com/problems/escape-a-large-maze/
*/
import java.util.*;

public class Solution {
    
    static int limit = 1000000; /* Upperbounds of the maze */
    static int[][] directions = { {0, 1}, {1, 0}, {0, -1}, {-1, 0}}; /* up, right, down, left for updating coordinates */
    
    /*   
        check if we can traverse with DFS for over 200 manhattan distance. 
        if we can, then it is possible for us to reach the target.
        
        if we go for a source to target BFS approach for a million grid, we will run out of memory.
    */
    
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        
        boolean result;
        HashSet<List<Integer>> maze = new HashSet<>(); /* Hashset for checking blocked coordinate in O(1) */
        HashSet<List<Integer>> visited = new HashSet<>(); /* Hashset for checking visited coordinate in O(1) */
        
        if(blocked.length == 0)
            return true;
        
        for(int[] block: blocked) {
            
            maze.add(new ArrayList<>(List.of(block[0], block[1])));
        }
        
        /* 
            clear visited nodes we got from source to target
            before we send the parameter to target to source 
            traversal 
        */
        boolean sourceToTarget = checkBlocks(source, target, source, maze, visited);
        visited.clear(); 
        boolean targetToSource = checkBlocks(target, source, target, maze, visited);
        
        result = sourceToTarget && targetToSource;
        
        return result;
    }
    
    /*
    
        Functionality of checkBlocks
        DFS search to check if the perimeter is cleared.
        
        Function returns true for the following conditions
        
            1. if the current coordinate is target
            2. if the manhattan distance is greater than 200
            3. 
    */
    public static boolean checkBlocks(int[] source, int[] target, int[] current, HashSet<List<Integer>> maze, HashSet<List<Integer>> visited) {
        
        if(current[0] == target[0] && current[1] == target[1]) {
            return true;
        }
                    
        int manhattanDistance = Math.abs(current[0] - source[0]) + Math.abs(current[1] - source[1]);
        if(manhattanDistance > 200) 
            return true;
        
        visited.add(new ArrayList<>(List.of(current[0], current[1])));
        
        for(int[] direction : directions) {
            
            /* update directions up, left, down, right */
            int x = current[0] + direction[0];
            int y = current[1] + direction[1];
            int[] nextCoordinate = {x, y};
            
            /* Condition to update the current coordinate */
            boolean xCondition = (x >= 0 && x < limit);
            boolean yCondition = (y >= 0 && y < limit);
            boolean isVisited = visited.contains(List.of(x, y));
            boolean isBlocked = maze.contains(List.of(x, y));
            
            if(xCondition && yCondition && !isVisited && !isBlocked) {
                
                /* recursively traverses to next depth */
                if(checkBlocks(source, target, nextCoordinate, maze, visited) == true) {
                    
                    return true;
                }
                    
            }
        }
        
        return false;   
    }
    
    public static void main(String args[]) {
        
        int[][] blocked = {{0,3}, {1, 0}, {1, 1}, {1, 2}, {1, 3}};
        int[] source = {0, 0};
        int[] target = {0, 2};
        boolean escapePossible = isEscapePossible(blocked, source, target);
        System.out.println(escapePossible);
    }
}
