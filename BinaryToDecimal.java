public class BinaryToDecimal {
    
    public static void main(String[] args) {
        
        String binary = "10100101111";
        int decimal = binaryToDecimal(binary);
        System.out.print("Decimal value of binary number " + binary + ": " + decimal);
        
    }

    public static int binaryToDecimal(String binary) {

        /*  Iterate from right to left, 
            raise each digit to their respective 2 powers and add them
        **/
        int length = binary.length();
        int twoPower = 1;
        int decimal = 0;
        for(int index = length-1; index >= 0; index--, twoPower *= 2) {

            int number = Character.getNumericValue(binary.charAt(index));
            decimal += (number * twoPower);
        }
        
        return decimal;
    }
}
