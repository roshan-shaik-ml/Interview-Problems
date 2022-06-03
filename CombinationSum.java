/*
  Author: Shaik Faizan Roshan Ali
  Date: 3rd June 2022
  Link: https://leetcode.com/problems/combination-sum/
/*

Algorithm: Backtracking solution for finding combinations
build a state space tree


if current sum is greater than target. return
else if target = current sum. add current list to the result list
Else
    for(current index to last index)
        add the next integer from arr to current combo list
        recurse
        pop the last added integer from the combo list
    
**/
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<List<Integer>> result;
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ArrayList<Integer> combo = new ArrayList<>();
        result = new ArrayList<List<Integer>>();
        findCombo(candidates, target, 0, combo, 0);
        return result;
    }
    
    public static void findCombo(int[] candidates, int target, int currentSum, ArrayList<Integer> combo, int index) {
        
        if(currentSum > target) /* current sum greater than target */
            return;
        if (currentSum == target) { 
            
            /* current sum equal to target add the current combo list to result */
            result.add(new ArrayList<>(combo));
            
            return;
        }
        
        /* 
        
        NOTE: start from current "index" to avoid duplicate results in any reordered form 
        add the next value to current sum and append it to the combo list
        recurse
        subtract the last value from combo list and pop the value as well from the combo list
        
        */
        for(int i = index; i < candidates.length; i++) {
            
            currentSum += candidates[i];
            combo.add(candidates[i]);
           
            findCombo(candidates, target, currentSum, combo, i);
            
            int prev = combo.remove(combo.size() - 1);
            currentSum -= prev;
            
        }
        return;
    }

    public static void main(String[] args) {
        
        int[] arr = {100, 200, 4, 12};
        int target = 400;

        List<List<Integer>> results = combinationSum(arr, target);
        
        for(List<Integer> result : results) {

            System.out.println(result);
        }
    }
}
