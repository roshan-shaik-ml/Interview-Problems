/*
  Author: Shaik Faizan Roshan Ali
  Date: 4th June 2022
  Link: https://leetcode.com/problems/combination-sum-ii/
*/

/*
Algorithm: Backtracking solution for finding combinations
build a state space tree
if current sum is greater than target. return
else if target = current sum. add current list to the result list
Else
    for(current index to last index)
        add the next integer from arr to current combo list
        recurse with index + 1
        pop the last added integer from the combo list
    
**/

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    static List<List<Integer>> result;
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        ArrayList<Integer> combo = new ArrayList<>();
        result = new ArrayList<List<Integer>>();
        findCombo(candidates, target, 0, combo, 0);
        return result;
    }
    
    public static void findCombo(int[] candidates, int target, int currentSum, ArrayList<Integer> combo, int index) {
        
        if(currentSum > target)
            return;
        if (currentSum == target && result.contains(new ArrayList<>(combo)) == false) {
            
            result.add(new ArrayList<>(combo));
            
            return;
        }
      
        for(int i = index;i < candidates.length; i++) {
            
            if(i>index && candidates[i] == candidates[i-1]) 
                continue;
            currentSum += candidates[i];
            combo.add(candidates[i]);
           
            findCombo(candidates, target, currentSum, combo, i+1);
            
            int prev = combo.remove(combo.size() - 1);
            currentSum -= prev;
            
        }
        return;
    }

    public static void main(String[] args) {
        
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> results = combinationSum2(arr, target);
        
        for(List<Integer> result : results) {

            System.out.println(result);
        }
    }
}
