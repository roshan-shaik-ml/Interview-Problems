/*
  Author: Shaik Faizan Roshan Ali
  Date: 13th June 2022
  Link: https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
  Algorithm: This is a straight forward BFS approach for finding the nearest exit (i.e. border of the matrix)
  NOTE: BFS has relatively better time efficient approach in this scenario compared to a DFS
**/
class Solution {
    
    static int minimum = Integer.MAX_VALUE;
    static int[][] directions = { {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int nearestExit(char[][] maze, int[] entrance) {
        
        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
        Queue<List<Integer>> queue = new LinkedList<>();
        
        queue.add(List.of(entrance[0], entrance[1]));
        visited.add(List.of(entrance[0], entrance[1]));
        
        int level = -1;
        level = bfs(maze, entrance, visited, queue);
        
        return level;
    }
    
    public int bfs(char[][] maze,int[] entrance, HashSet<List<Integer>> visited, Queue<List<Integer>> queue) {
      
        List<Integer> current = new ArrayList<>(2);
        current.add(entrance[0]);
        current.add(entrance[1]);
      
        int level = 0;
        while(!queue.isEmpty()) {

            for(int i=queue.size(); i>0; i--){

                current = queue.poll();
                boolean borderCondition = (current.get(0) == 0 || 
                                           current.get(1) == 0 || 
                                           current.get(1) == maze[0].length-1 || 
                                           current.get(0) == maze.length-1
                                          );

                if(borderCondition && level != 0) {

                    return level;
                }

                for(int[] direction : directions) {

                    int[] temp = new int[2];
                    temp[0] = current.get(0) + direction[0];
                    temp[1] = current.get(1) + direction[1];

                    boolean isOutside = (temp[0] < 0 || temp[1] < 0 || temp[0] >= maze.length || temp[1] >= maze[0].length);
                    if(isOutside)
                        continue;

                    boolean isVisited = visited.contains(List.of(temp[0], temp[1]));
                    boolean isNotBlocked = maze[temp[0]][temp[1]] != '+';

                    if (!isVisited && isNotBlocked) {

                        visited.add(List.of(temp[0], temp[1]));
                        queue.add(new ArrayList<>(List.of(temp[0], temp[1])));
                    }    
                }
            }
            level += 1;
        }
        return -1;      
    }
}
