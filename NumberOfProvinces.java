/*
    Date: 17th June 2022
    Author: Shaik Faizan Roshan Ali
    Link: https://leetcode.com/problems/number-of-provinces/
    Description: This question is about finding the connected components in a graph.
    Algorithm: DFS flood fill algorithm for a graph.
**/

class Solution {
    public int findCircleNum(int[][] isConnected) {
    
        int count = 0;
        boolean[] isVisited = new boolean[isConnected.length];
        for(int vertex = 0; vertex < isConnected.length; vertex++) {
            
            for(int nbr = 0; nbr < isConnected[0].length; nbr++) {
                
                if(isVisited[vertex] == false && isConnected[vertex][nbr] == 1) {
                    
                    findConnected(isConnected, vertex, nbr, isVisited);
                    count++;
                }  
            }
        }
        return count;
    }
    
    public void findConnected(int[][] isConnected, int vertex, int nbr, boolean[] isVisited){
        
        if(isVisited[vertex] == false) {
            
            isVisited[vertex] = true;
            for(int next = 0; next < isConnected[0].length; next++) {

                if(next != nbr && isVisited[next] == false && isConnected[vertex][next] == 1) {

                    findConnected(isConnected, next, 0, isVisited);
                }
            }
        
        }
    }
}
