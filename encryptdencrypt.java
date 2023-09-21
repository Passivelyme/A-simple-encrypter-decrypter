// importing packages
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
class encryptdencrypt 
{
    // declaring necessary io class and required collections
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // hashmap to store the encryption and decryption reference table
    HashMap<String, String> Reference_map = new HashMap<>();
    ArrayList<String> Actual_list = new ArrayList<String>();
    // input function to take input from user
    void input() throws IOException 
    {
        System.out.print("Enter the text to encrypt: ");
        String input_text = br.readLine();
        //converrting the input sentence to individual word and adding to arraylist
        StringTokenizer st = new StringTokenizer(input_text, " ");
        while (st.hasMoreTokens()) {
            Actual_list.add(st.nextToken());
        }
        //orisave.addAll(Actual_list);
    }
    //creating a reference table for encryption.
    void reference_table()
    {
        //mapping alphabet and symbol for encryption.
        String alphabet[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String symbol[] = { "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010",
                "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100",
                "10101", "10110", "10111", "11000", "11001", "11010" };

        // inserting both arrays into a hashmap and also checking for case sensitivity
        for (int i = 0; i < alphabet.length; i++) {
            Reference_map.put(alphabet[i], symbol[i]);
            Reference_map.put(alphabet[i].toUpperCase(), symbol[i]);
        }
    }
    // creating reverse reference table for decryption
    void reverse_reference_table()
    { 
        //creating decryption reference table.
        String alphabet[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String symbols[] = { "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010",
                "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100",
                "10101", "10110", "10111", "11000", "11001", "11010" };
        for(int i = 0; i<symbols.length; i++)
        {
            Reference_map.put(symbols[i],alphabet[i]);
        }
    }
    // processing encryption
    void encrypt() throws IOException 
    {
        ArrayList<String> Encrypted_list = new ArrayList<String>();
        input();
        reference_table();
        ArrayList<Character> workinglist = new ArrayList<Character>();
        // initializing the variable and storing the length of input
        int listlength = Actual_list.size();
        int i = 0;
        String current_working_word;
        while (i < listlength)
        {
            // extracting word by word and working on that
            current_working_word = Actual_list.get(i);
            // length of extracted word
            int word_length = current_working_word.length();
            int j;
            // converting the word to individual characters and adding them to a temporary list to work on
            for (j = 0; j < word_length; j++) {
                workinglist.add(current_working_word.charAt(j));
            }
            // adding a space to account for word end
            workinglist.add(' ');
            // encrypting the characters and adding them to the final list, and adding a space for word change
            for (Character ch : workinglist) {
                String value = Reference_map.get(String.valueOf(ch));
                Encrypted_list.add(value != null ? value : ""); // Check for null value and replace with an empty string
            }
            Encrypted_list.add(" ");
            // clearing the list for working on the next word
            workinglist.clear();
            i++;
        }
        // clearing the working list so it can be used in dcryption
        workinglist.clear();
        // printing the final encrypted message
        for (String code : Encrypted_list)
        {
            System.out.print(code);
        }
        System.out.println();
    }
    //taking encoded input from user
    void decrypt_input() throws IOException
    {
        System.out.print("Enter the text to decrypt: ");
        String input_text = br.readLine();
        //converrting the input sentence to individual word and adding to arraylist
        StringTokenizer st = new StringTokenizer(input_text, " ");
        while (st.hasMoreTokens()) {
            Actual_list.add(st.nextToken());
        }
        //orisave.addAll(Actual_list);
    }
    // processing decryption
    void decrypt()throws IOException
    {
        decrypt_input();
        //calling reverse reference table
        reverse_reference_table();
        ArrayList <String> Decodedmsg = new ArrayList<>();
        Decodedmsg.clear();
        Actual_list.size();
        StringBuilder conString = new StringBuilder();
        for(String working_coded_msg: Actual_list)
        {
            String[] part = working_coded_msg.split("(?<=\\G.{5})");
            for(String pat:part)
            {
                conString.append(Reference_map.get(String.valueOf(pat)));
            }
            Decodedmsg.add(conString.toString());
            Decodedmsg.add(" ");
        }
        for( String str:Decodedmsg)
        {
            String message = str;
            int currentIndex = 0;

            while (currentIndex < message.length()) 
            {
                char currentChar = message.charAt(currentIndex);
                System.out.print("\r" + message.substring( 0,currentIndex + 1));
                currentIndex++;
                try {
                    Thread.sleep(100); // Add a delay for the animation effect
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Decodedmsg.clear();
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        encryptdencrypt obj = new encryptdencrypt();
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1:
                        obj.encrypt();
                        break;
                    case 2:
                        obj.decrypt();
                        break;
                    case 3:
                        System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                choice = 0; // Reset choice to loop again
            }
        } while (choice != 3);
    }

    private static void displayMenu() {
        System.out.println("\nMenu\n----------");
        System.out.println("1- Encrypt");
        System.out.println("2- Decrypt");
        System.out.println("3- Exit");
    }
}
