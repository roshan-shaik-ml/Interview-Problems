public class RemoveSpaces {
    
    public static void main(String[] args) {
        
        String string = "Hello \t sorry \n world";
        String newString = removeSpaces(string);
        System.out.println(newString);

    }

    public static String removeSpaces(String string) {

        int length = string.length();
        StringBuilder newString = new StringBuilder();
        for(int index = 0; index < length; index++) {

            if(string.charAt(index) != ' ' && 
                    string.charAt(index) != '\t' && string.charAt(index) != '\n') {

                    newString.append(string.charAt(index));
            }
        }
        
        String finalString = newString.toString();
        return finalString;
    }
}

