/*
Author: Shaik Faizan Roshan Ali
Date: 25th May 2022
Link: https://leetcode.com/problems/generate-parentheses/
*/

import java.util.*;
class Solution {
    
    static Stack<String> stack =  new Stack<String>();
    static List<String> ll = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {

        genParenthesis(n, n, n);
        System.out.println(ll);
        return ll;
    }

    public static Stack<String> genParenthesis(int n, int open, int close) {

        if((open == 0 && close == 0)) {

            String temp = stack.toString().replaceAll("[\\[\\]]", "\"").replaceAll(", ", "");
            ll.add(temp);
            return stack;
        }
            
        if(open > 0) {

            stack.push("(");
            genParenthesis(n, open-1, close);
            stack.pop();
        }

        if(open < close) {

            stack.push(")");
            genParenthesis(n, open, close-1);
            stack.pop();
        }
        return stack;
    } 
}
