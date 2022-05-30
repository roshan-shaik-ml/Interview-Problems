/*
  Author: Shaik Faizan Roshan Ali
  Date: 30th May 2022
  Link: https://leetcode.com/problems/first-missing-positive/
*/

public class Solution {
  
    public static int firstMissingPositive(int[] nums) {
        /*
            Algorithm
              The are two different cases in this question 
              1. When all numbers are present we return n+1
              2. When one or more number are missing (i.e either a -ve or a number greater than n exists in the array)
              The number are in range of 1 to n;

              step 1: Let's make the numbers out of bonds (i.e. non-positive and numbers greater than n) as n+1
              step 2: We iterate through array and mark the nums[nums[index]] of nums[i] by making them -ve
              step 3: Finally we iterate through it once more and find the index with non-negative value in range 1 to n

              So, we have found the first index that was not marked as negative value, meaning it is missing from the array.
        **/
        int n = nums.length
        for(int i = 0; i < n; i++) {
            
            if(nums[i] <= 0 || nums[i] > n) {
                
                nums[i] = n+1;
            }
        }
        
        for(int i = 0; i < n; i++) {
            
            if(Math.abs(nums[i]) != n + 1) {
               
                int index = Math.abs(nums[i]);
                nums[index-1] = -nums[index-1];
            }
        }
      
        for(int i = 0; i < n; i++) {
            
            if(nums[i] > 0) {
                
                return i+1;
            }
        }
        
        return n+1;
    }
    public static void main(String args[]) {
        
        int[] arr = {3, -1, 1, 4};
        int missedYou = firstMissingPositive(arr);
        System.out.println("The first missing positive number is " + missedYou);
    }
}
