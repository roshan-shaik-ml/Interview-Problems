/*
  Author: Shaik Faizan Roshan Ali
  Date: 31st May 2022
  Link: https://leetcode.com/problems/two-sum/

**/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        Arrays.fill(result, 0);
        for(int i = 0; i < nums.length; i++) {
            
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            
            int second =target-nums[i];
            System.out.println(nums[i] + " " + second + " " + (nums.length + 1)/2);
            if(map.containsKey(second) && map.get(second) != i) {
                
                result[0] = i;
                result[1] = map.get(second);
                return result;
            }
        }
        return result;
    }
}
