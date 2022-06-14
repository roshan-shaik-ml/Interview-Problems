/*
    Auhtor: Shaik Faizan Roshan Ali
    Date: 14th June 2022
    Link: https://leetcode.com/problems/unique-binary-search-trees/
    Algorithm: Dynamic programming approach. We find the the numbers of unqiue BST for for n - 1.
    We can use that to determine number of unique BST combinations for left and right subtree.
    
    For example: When n = 3
    [10, 20, 30]
    (root) 10 -> Left (0) []       | Right -> (2) [20, 30]
    (root) 20 -> Left (1) [10]     | Right -> (1) [30]
    (root) 30 -> Left (2) [10, 20] | Right -> (0) []
    
    Since, we know the number of unique BST for n = 2. We can directly substitute from the DP array 
    and add the values of all combinations.
    
    NOTE: Do read up about Catalan number (i.e another mathematical approach for finding this solution)
**/
public class Solution {
    
    public static int numTrees(int n) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            
            int left = 0;
            int right = i-1;
            
            while(left <= i - 1) {
                
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
                
        }
        
        return dp[n];
    }
    
    public static void main(String args[]) {
        
        int nodes = 10;
        System.out.println("Number of unique BST are " + numTrees(nodes));
    }
}