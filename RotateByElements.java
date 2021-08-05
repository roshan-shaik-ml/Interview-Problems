public class RotateByElements {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int rotateValue = 5;
        arr = rotateArray(arr, rotateValue % arr.length);
        
        for(int element : arr) 
            System.out.print(element + " ");
    }

    public static int[] rotateArray(int[] arr, int rotateValue) {

        int start = arr.length - rotateValue;
        int end = arr.length - 1;
        arr = reverseArray(arr, start, end);
        
        end = start - 1;
        start = 0;
        arr = reverseArray(arr, start, end);
        
        arr = reverseArray(arr, 0, arr.length-1);

        return arr;
    }

    public static int[] reverseArray(int[] arr, int start, int end) {

        int temp = 0;
        for(int front = start, back = end; front < back; front++, back--) {

            temp = arr[front];
            arr[front] = arr[back];
            arr[back] = temp;
        }

        return arr;
    }
}
