package Test;

import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        //Path path = Path.of("C:\Users\Сергей\Desktop\test.txt");
        //Scanner input = new Scanner(path);

        Scanner input = new Scanner(System.in);

        CaesarCipher caesar = new CaesarCipher();

        //Ask the user the Caesar key
        System.out.println("Enter the Caesar key:");
        int key = input.nextInt();

        //Consume the \n from nextInt
        input.nextLine();

        //Ask the user the pre-encrypted message
        System.out.println("Enter your message: ");
        String message = input.nextLine();

        System.out.println("The original message is: " + message);

        String encryptmessage = caesar.encryptmessage(key, message);

        System.out.println("The encrypted message is: " + encryptmessage);


        //Ask the user if the encrypted message is to be decrypted
        System.out.println("Do you wish to decrypt this message?\n1.) Yes\n2.)No");
        int decryptchoice = input.nextInt();

        //Consume the \n from nextInt
        input.nextLine();


        if (decryptchoice == 1) {

            //Ask the user if there is a key
            System.out.println("Do you have the key? If yes, please enter the number. If no, please enter -1");
            int decryptkey = input.nextInt();

            //Consume the \n from nextInt
            input.nextLine();


            if (decryptkey != -1) {

                String decryptmessage = caesar.decryptmessage(decryptkey, encryptmessage);

                System.out.println("The decrypted message is: " + decryptmessage);
            }

            //Since there is no key, use the brute force method
            else {

                caesar.decryptbruteforce(encryptmessage);
            }
        }
    }
}
