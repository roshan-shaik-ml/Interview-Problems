/*
  Author: Shaik Faizan Roshan Ali
  Date: 31st May 2022
  Link: https://leetcode.com/problems/container-with-most-water/

**/
class Solution {
    public int maxArea(int[] height) {
        
        int n = height.length;
        int left = 0;
        int right = n-1;
        int result = 0;
        
        while(left < right) {
            
            if(height[left] < height[right]) {
                
                result = Math.max(result, compute(height[left], left, right));
                left++; 
            }
            else {
                
                result = Math.max(result, compute(height[right], left, right));
                right--;
            }
        }
        return result;
    }
    
    public int compute(int  num, int leftpart, int rightpart) {
        
        int distance = rightpart - leftpart;
        
        return (num * distance);
    }
}
