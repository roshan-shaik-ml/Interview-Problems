public class BinarySearch {
    
    public static void main(String[] args) {
        
        int toSearch = 10;
        int[] arr = {1, 3, 4, 5, 10, 12, 34, 54, 67};

        int low = 0;
        int high = arr.length - 1;
        int mid = (high - low) / 2;
        int answer = -1;
        while(low < high) {

            mid = (low + high) / 2;
            if(arr[mid] == toSearch) {
                
                answer = mid;
                break;
            }
                
            else if(toSearch < arr[mid]) {
                
                high = mid - 1;
            }
            else{

                low = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
