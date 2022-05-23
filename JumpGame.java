/*
    Author: Shaik Faizan Roshan Ali
    Date: 23rd May 2022
    Link: https://leetcode.com/problems/jump-game/
    Difficulty: Medium  
*/
class Solution {
    public boolean canJump(int[] nums) {
        
        boolean can = true;
        int steps = nums[0];
        
        if(nums.length == 1) {
            
            return true;
        }
        for(int i=0; i<nums.length; i++) {
            
            if(steps == 0) {
                can = false;
                break;
            }
            else {
                
                steps -= 1;
                if(steps <= nums[i])
                    steps = nums[i];
            }
        }
        return can;
    }
}
