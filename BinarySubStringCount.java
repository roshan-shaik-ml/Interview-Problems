/*
Author: Shaik Faizan Roshan Ali
Date: 5th August 2021
About: From the given binary string, 
        count the number of subsequences that start and end with 1
**/
public class BinarySubStringCount {
    
    public static void main(String[] args) {
        
        String binary = "00100101";
        char[] binaryArray = binary.toCharArray();
        int countOnes = 0;
        int length = binary.length;
        for(int index = 0; index < length; index++) {

            if(binaryArray[index] == 1)
                countOnes += 1;
        }

        int possibleSubsequenceCount = countOnes * (countOnes - 1) / 2;
        System.out.println(possibleSubsequenceCount);
    }
}   
