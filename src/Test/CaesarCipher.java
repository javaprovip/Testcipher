package Test;

public class CaesarCipher {
    String encryptalphabet(int key) {
        //Get the standard alphabet
        String standalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Shift the end of the alphabet to the start of the alphabet
        String encryptalpha = standalpha.substring(key) + standalpha.substring(0 , key);

        //Return the encrypted alphabet
        return encryptalpha;
    }

    String encryptmessage(int key, String message) {

        //Get the standard alphabet
        String standalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Get the encrypted alphabet
        String encryptalpha = encryptalphabet(key);

        //Convert the message to uppercase as the alphabet is in uppercase
        String messageupper = message.toUpperCase();

        //Set a stringbuilder with the message
        StringBuilder encryptsb = new StringBuilder(messageupper);

        int i;
        int index;
        char currentchar;
        char newchar;

        //Loop over the message
        for (i = 0; i < encryptsb.length(); i = i + 1) {

            //Get the character of the encrypted message
            currentchar = encryptsb.charAt(i);

            //Get the index of the currentchar in the standard alphabet
            index = standalpha.indexOf(currentchar);

            //If the currentchar is present in the standard alphabet
            if (index != -1) {

                //Get the character of the encrypted alphabet from the index of the standard alphabet
                newchar = encryptalpha.charAt(index);

                //Replace the character from i index with the new character
                encryptsb.setCharAt(i, newchar);
            }
        }

        //Return the Stringbuilder to the main code
        return encryptsb.toString();
    }


    String decryptmessage(int key, String encryptmessage) {

        //Get the standard alphabet
        String standalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Get the encrypted alphabet
        String encryptalpha = encryptalphabet(key);

        //Convert this message to uppercase
        String encryptmessageupper = encryptmessage.toUpperCase();

        StringBuilder sbdecrypt = new StringBuilder(encryptmessageupper);


        int i;
        int index;
        char currentchar;
        char newchar;

        //Loop through the message
        for (i = 0; i < sbdecrypt.length(); i++) {

            //Get the encrypted character
            currentchar = sbdecrypt.charAt(i);

            //Get the index in the encrypted alphabet
            index = encryptalpha.indexOf(currentchar);

            //If the currentchar is present in the alphabet
            if (index != -1) {

                //Get the character in the standard alphabet
                newchar = standalpha.charAt(index);

                //Replace the character
                sbdecrypt.setCharAt(i, newchar);
            }
        }
        return sbdecrypt.toString();
    }


    void decryptbruteforce(String encryptmessage) {

        //Get the standard alphabet
        String standalpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !.,:";

        //Convert this message to uppercase
        String encryptmessageupper = encryptmessage.toUpperCase();

        StringBuilder sbdecrypt = new StringBuilder(encryptmessageupper);


        int key;
        int i;
        int index;
        char currentchar;
        char newchar;

        //Loop through the 26 keys in the alphabet.
        for (key = 1; key < 27; key++) {

            //To not edit the already shifted string, call the same encrypted string each time
            sbdecrypt = new StringBuilder(encryptmessageupper);

            //Loop through the encrypted message
            for (i = 0; i < sbdecrypt.length(); i++) {

                //Get the encrypted character
                currentchar = sbdecrypt.charAt(i);

                //Get the index in the alphabet
                index = standalpha.indexOf(currentchar);

                //If the currentchar is in the alphabet
                if (index != -1) {

                    //Reduce the character by the key in the alphabet
                    index = index - key;

                    //If the character goes below 0, aka 'A', go back to the end of the alphabet
                    if (index < 0) {
                        index = index + 26;

                        //Get the new character in the alphabet
                        newchar = standalpha.charAt(index);

                        //Set the character in the stringbuilder
                        sbdecrypt.setCharAt(i, newchar);
                    }

                    else {

                        //Get the new character in the alphabet
                        newchar = standalpha.charAt(index);

                        //Set the character in the stringbuilder
                        sbdecrypt.setCharAt(i, newchar);
                    }
                }
            }

            //Print the key and the resulting string
            System.out.println("Key: " + key + " Decrypted String: " + sbdecrypt);
        }
    }
}


