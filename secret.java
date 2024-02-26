import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter; 
import java.io.IOException;

public class secret {
    public static void main(String[] args) {
        // all arraylists
        ArrayList<String> userText = new ArrayList<>();
        ArrayList<String> iDunno = new ArrayList<>();
        ArrayList<String> cypherKeyList = new ArrayList<>();
        ArrayList<String> cypheredText = new ArrayList<>();
        ArrayList<Character> cypheredAlphaText = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        //makes the textfile
        try {
            FileWriter myWriter = new FileWriter("secretcode.txt");
        //user input
        System.out.println("Write the text you want to be cyphered");
        userText.add(userInput.nextLine());
        System.out.println("Write the cypher key");
        cypherKeyList.add(userInput.nextLine());
        myWriter.write(cypherKeyList.get(0) + "\n \n");
        //turns the text into ascii numbers
        for (int i = 0; i < userText.get(0).length(); i++){
            while(i != 999999999){
                char eachChar = userText.get(0).charAt(i);
                int charUni = (int) eachChar;
                iDunno.add(String.valueOf(charUni)); 
                break;
            }
        }
        int j = 0;
        for (int i = 0; i < iDunno.size(); i++){
            if(j < cypherKeyList.get(0).length()){
                //Uses the cypher key to modify the numbers
                char c = cypherKeyList.get(0).charAt(j);
                int digit = c - '0';
                cypheredText.add(String.valueOf(Integer.parseInt(iDunno.get(i)) + digit));
                j++;
                //turns it back to letters but cyphered and puts it in the code file
                char b = (char) Integer.parseInt(cypheredText.get(i));
                cypheredAlphaText.add(b);
                myWriter.write(cypheredAlphaText.get(i));
                //if the cypher key numbers run out, start from the first number again
                if(j == cypherKeyList.get(0).length()){
                    j = 0;
                }
            }
        }
        myWriter.close();
    //catches and prints errors
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
        }
}
