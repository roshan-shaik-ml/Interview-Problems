/*
    Author: Shaik Faizan Roshan Ali
    Date: 30th May 2022
    Link: https://leetcode.com/problems/is-graph-bipartite/
*/
import java.util.*;
public class Solution {
    
    public static boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < n; i++) {
            
            int[] vertices = graph[i];
            for(int j = 1; j < vertices.length; j++) {
                
                uf.union(vertices[0], vertices[j]);
            }
            if(vertices.length > 0 && uf.findSet(i) == uf.findSet(vertices[0]))
                return false;
        }
        
        return true;
    }
    
    public static void main(String args[]) {
        
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        boolean bipartite = isBipartite(graph);
        
        System.out.println("Is the given graph bipartite? " + bipartite);
    }
}

class UnionFind {
    
    /*
    
        Parent array is used for keeping track of the parent for each node
        Rank determines the rank of the set
        setSize determines the size of the set.
        numSets determines the number of sets.
    **/
    Vector<Integer> parent, rank, setSize;
    int numSets;
    UnionFind(int n) {
        
        parent = new Vector<Integer>(n);
        rank = new Vector<Integer>(n);
        setSize = new Vector<Integer>(n);
        numSets = n;
        
        for(int i = 0; i < n; i++) {
            
            parent.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }
    
    /* findset method is used to check to which set the node belongs to */
    public int findSet(int i) {
        
        if(parent.get(i) == i) {
            
            return i;
        }
        
        else {
            
            int papa = findSet(parent.get(i));
            parent.set(i, papa); // maybe path compression
            return papa;
        }
    }
    
    /* Union is used for performing union of two disjoint sets */
    public void union(int i, int j) {
        
        int parent1 = findSet(i);
        int parent2 = findSet(j);
        
        /* union is only possible if the parent/root of both nodes are different */
        if(parent1 != parent2) {
            
            numSets--;
            if(rank.get(parent1) > rank.get(parent2)) {
                
                parent.set(parent2, parent1); // cause parent 1 rank is higher
                setSize.set(parent1, setSize.get(parent1) + setSize.get(parent2));
                
                /* rank doesn't change in this scenario */
            }
        
            else {
                
                parent.set(parent1, parent2);
                setSize.set(parent2, setSize.get(parent1)+ setSize.get(parent2));
                
                if(rank.get(parent1) == rank.get(parent2)) {
                    
                    rank.set(parent2, rank.get(parent2)+1);
                }
            }        
        }
        
    }  
}
