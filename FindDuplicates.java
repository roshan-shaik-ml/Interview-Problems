/*
Author: Shaik Faizan Roshan Ali
Date: 23rd May 2022
Problem link: https://leetcode.com/problems/find-all-duplicates-in-an-array/

*/
import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> l = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(set.add(nums[i]) != true)
                l.add(nums[i]);
        }
        
        return l;
    
    }
}
