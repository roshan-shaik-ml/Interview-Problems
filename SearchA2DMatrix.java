/*
    Author: Shaik Faizan Roshan Ali & Junaid Shek
    Date: 7th May 2022
    Approach: Binary Search on the row based on the row of the array target belongs to.
    Link: https://leetcode.com/problems/search-a-2d-matrix/
*/
public class SearchA2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean result = false;
        for (int row = 0; row < m; row++) {

            if (matrix[row][0] <= target && matrix[row][n-1] >= target) {
                
                result = binarySearch(matrix[row], 0, n-1, target);
                break;
            }      
        }
        
        return result;
    }
    
    public static boolean binarySearch(int[] arr, int low, int upper, int target) {
        
        int mid = low + (upper-low) / 2;
        if (upper >= low) {
            
            if (arr[mid] == target)
                return true;

            if (arr[mid] < target) {
                
                low = mid+1;
                return binarySearch(arr, low, upper, target);
            }
            
            else {
                upper = mid - 1;
                return binarySearch(arr, low, upper, target);
            }
        }
        return false;     
    }

    public static void main(String[] args) {
        
        int[][] arr = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 13;
        boolean found = searchMatrix(matrix, target);
        System.out.println(found);
    }
}
