import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter; 
import java.io.IOException;

public class secret {
    public static void main(String[] args) {
    ArrayList<String> userText = new ArrayList<>();
    ArrayList<String> iDunno = new ArrayList<>();
    ArrayList<String> cypherKeyList = new ArrayList<>();
    ArrayList<String> cypheredText = new ArrayList<>();
    ArrayList<Character> cypheredAlphaText = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);
    try {
        FileWriter myWriter = new FileWriter("secretcode.txt");
        System.out.println("Successfully wrote to the file.");
    System.out.println("Write the text you want to be cyphered");
    userText.add(userInput.nextLine());
    System.out.println("Write the cypher key");
    cypherKeyList.add(userInput.nextLine());
    myWriter.write(cypherKeyList.get(0) + "\n \n");
    for (int i = 0; i < userText.get(0).length(); i++){
        while(i != 999999999){
            char eachChar = userText.get(0).charAt(i);
            int charUni = (int) eachChar;
            iDunno.add(String.valueOf(charUni));
            System.out.println(iDunno);
            break;
        }
    }
    int j = 0;
    for (int i = 0; i < iDunno.size(); i++){
        if(j < cypherKeyList.get(0).length()){
            char c = cypherKeyList.get(0).charAt(j);
            int digit = c - '0';
            cypheredText.add(String.valueOf(Integer.parseInt(iDunno.get(i)) + digit));
            System.out.println(cypheredText);
            j++;
            char b = (char) Integer.parseInt(cypheredText.get(i));
            cypheredAlphaText.add(b);
            System.out.println(cypheredAlphaText);
            myWriter.write(cypheredAlphaText.get(i));
            if(j == cypherKeyList.get(0).length()){
                j = 0;
            }
        }
    }
    myWriter.close();
} catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
    }
}