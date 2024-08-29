/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Lucas Ying
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        int shift = 9; // Hand solved for shift of 9

        for (char c: encrypted.toCharArray()){ // Found a handy method that takes a string and splits it into chars
            if (c >= 'a' && c <= 'z') { // Checks for lowercase letters to be converted to their decrypted letter using the shift of 9
                decrypted += (char) (((c-'a'+shift)%26)+'a');
            } else if (c >= 'A' && c <= 'Z') { // Checks for uppercase letters to be converted to their decrypted letter
                decrypted += (char) (((c-'A'+shift)%26)+'A');
            } else { // If the char is not a letter let it remain the same as is and add it to the decrypted message
                decrypted += c;
            }
        }
        System.out.println(decrypted); // Printed the decrypted message to test my work
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        String[] numbers = encrypted.split(" "); // Split the encrypted String into numbers seperated by spaces

        for (String number : numbers){
            int asciiValue = Integer.parseInt(number); // Parse Int helps me convert each string number into an integer
            char character = (char) asciiValue; // Convert Integer into its corresponding ASCII value

            decrypted += character;
        }

        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        for (int i = 0; i < encrypted.length(); i+=8) { // Process String by every 8 bits
            String number = encrypted.substring(i, i+8); // Extract next chunk
            int ascii = 0;
            for (int j = 0; j < 8; j++) {
                if (number.charAt(j) == '1') { // Binary string converted to decimal ASCII value
                    ascii += (1<<(7-j)); // Left shift to calculate decimal value
                }
            }

            decrypted += (char) ascii;
        }

        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";
        int shift = 0x2700-'A'; // Find the shift based on Unicode point of A
        for (char c: encrypted.toCharArray()) {
            int unicode = (int) c; // Get unicode value
            char decoded = (char) (unicode - shift); // Apply shift to find the decoded character
            decrypted += decoded; // Add it
        }
        System.out.println(decrypted);
        return decrypted;
    }
}
