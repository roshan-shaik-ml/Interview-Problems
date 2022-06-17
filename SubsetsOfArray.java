/*
    Date: 17th June 2022
    Auhtor: Shaik Faizan Roshan Ali
    Link: https://leetcode.com/problems/subsets/
    Description: Find Subsets of an array.
**/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> sets = new ArrayList<>();
        getSubsets(nums, 0, sets, new ArrayList<>());
        
        return sets;
    }
    
    public void getSubsets(int[] nums, int index, List<List<Integer>> sets, List<Integer> sub) {
        
        sets.add(new ArrayList<>(sub));
        if(index == nums.length)
            return;
        
        for(int i = index; i < nums.length; i++) {

            sub.add(nums[i]);
            getSubsets(nums, i+1, sets, sub);
            sub.remove(sub.size()-1);
        }
    }
}
