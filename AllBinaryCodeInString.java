/*
  Date: 17th June 2022
  Author: Shaik Faizan Roshan Ali
  Link: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
  Description: Given a Binary String check if all the binary values of length K exist as a Substring in the string.
  Algorithm: Sliding Window using substring method for O(n) time complexity assuming substring to be O(1)

**/

class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        HashSet<String> hashset = new HashSet<>();
        for(int i = 0; i <= s.length()-k; i++) {
            
            String sub = s.substring(i, i+k);
            if(hashset.contains(sub) == false)
                hashset.add(sub);
        }
        System.out.println(hashset);
        if(hashset.size() == Math.pow(2, k))
            return true;
        else
            return false;
    }
}
