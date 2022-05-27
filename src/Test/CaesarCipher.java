package Test;

public class CaesarCipher {
    String encryptAlphabet(int key) {
        //Get the standard alphabet
        String standAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Shift the end of the alphabet to the start of the alphabet
        String encryptAlpha = standAlpha.substring(key) + standAlpha.substring(0 , key);

        //Return the encrypted alphabet
        return encryptAlpha;
    }

    String encryptMessage(int key, String message) {

        //Get the standard alphabet
        String standAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Get the encrypted alphabet
        String encryptAlpha = encryptAlphabet(key);

        //Convert the message to uppercase as the alphabet is in uppercase
        String messageUpper = message.toUpperCase();

        //Set a stringBuilder with the message
        StringBuilder encryptSb = new StringBuilder(messageUpper);

        int i;
        int index;
        char currentChar;
        char newChar;

        //Loop over the message
        for (i = 0; i < encryptSb.length(); i = i + 1) {

            //Get the character of the encrypted message
            currentChar = encryptSb.charAt(i);

            //Get the index of the currentChar in the standard alphabet
            index = standAlpha.indexOf(currentChar);

            //If the currentChar is present in the standard alphabet
            if (index != -1) {

                //Get the character of the encrypted alphabet from the index of the standard alphabet
                newChar = encryptAlpha.charAt(index);

                //Replace the character from i index with the new character
                encryptSb.setCharAt(i, newChar);
            }
        }

        //Return the StringBuilder to the main code
        return encryptSb.toString();
    }


    String decryptMessage(int key, String encryptMessage) {

        //Get the standard alphabet
        String standAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Get the encrypted alphabet
        String encryptAlpha = encryptAlphabet(key);

        //Convert this message to uppercase
        String encryptMessageUpper = encryptMessage.toUpperCase();

        StringBuilder sbDecrypt = new StringBuilder(encryptMessageUpper);


        int i;
        int index;
        char currentChar;
        char newChar;

        //Loop through the message
        for (i = 0; i < sbDecrypt.length(); i++) {

            //Get the encrypted character
            currentChar = sbDecrypt.charAt(i);

            //Get the index in the encrypted alphabet
            index = encryptAlpha.indexOf(currentChar);

            //If the currentchar is present in the alphabet
            if (index != -1) {

                //Get the character in the standard alphabet
                newChar = standAlpha.charAt(index);

                //Replace the character
                sbDecrypt.setCharAt(i, newChar);
            }
        }
        return sbDecrypt.toString();
    }


    void decryptBruteforce(String encryptMessage) {

        //Get the standard alphabet
        String standAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Convert this message to uppercase
        String encryptMessageUpper = encryptMessage.toUpperCase();

        StringBuilder sbDecrypt = new StringBuilder(encryptMessageUpper);


        int key;
        int i;
        int index;
        char currentChar;
        char newChar;

        //Loop through the 26 keys in the alphabet.
        for (key = 1; key < 27; key++) {

            //To not edit the already shifted string, call the same encrypted string each time
            sbDecrypt = new StringBuilder(encryptMessageUpper);

            //Loop through the encrypted message
            for (i = 0; i < sbDecrypt.length(); i++) {

                //Get the encrypted character
                currentChar = sbDecrypt.charAt(i);

                //Get the index in the alphabet
                index = standAlpha.indexOf(currentChar);

                //If the currentchar is in the alphabet
                if (index != -1) {

                    //Reduce the character by the key in the alphabet
                    index = index - key;

                    //If the character goes below 0, aka 'A', go back to the end of the alphabet
                    if (index < 0) {
                        index = index + 26;

                        //Get the new character in the alphabet
                        newChar = standAlpha.charAt(index);

                        //Set the character in the stringbuilder
                        sbDecrypt.setCharAt(i, newChar);
                    }

                    else {

                        //Get the new character in the alphabet
                        newChar = standAlpha.charAt(index);

                        //Set the character in the stringbuilder
                        sbDecrypt.setCharAt(i, newChar);
                    }
                }
            }

            //Print the key and the resulting string
            System.out.println("Key: " + key + " Decrypted String: " + sbDecrypt);
        }
    }
}


