/*

  Author: Shaik Faizan Roshan Ali
  Date: 4th June 2020
  Link: https://leetcode.com/problems/path-sum-ii/

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        long sum = Long.MAX_VALUE;
        
        if (root == null) 
            return result;
        findPath(root, targetSum, sum, path);
        return result;
    }
    
    public boolean findPath(TreeNode root, int targetSum, long sum, ArrayList<Integer> path) {

        if (root == null)
            return false;
        if(root != null) {
            
            // System.out.println(sum);
            if(sum > Integer.MAX_VALUE) {
                
                sum = root.val;
            }
                
            else {
                
                sum += root.val;

            }
            path.add(root.val);
                
            if(targetSum == sum && root.left == null && root.right == null) {

                // System.out.println(path);
                result.add(new ArrayList<>(path));
            }

            boolean leftAdded = findPath(root.left, targetSum, sum, path);
            if(leftAdded)
                path.remove(path.size()-1);
            boolean rightAdded = findPath(root.right, targetSum, sum, path);
            if(rightAdded)
                path.remove(path.size()-1);
                
            
            
            return true;
        }
        return true;
    }
}
