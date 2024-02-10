import java.util.Scanner;
import java.util.ArrayList;

public class multiplytable {
    public static void main(String[] args) {
        int x = 0;
        // all array lists (array lists are important because you cant increase the amount of elements in an array so you need to make new ones)
        ArrayList<Integer> horizontalLines = new ArrayList<>();
        ArrayList<Integer> verticalLines = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        //Scanners which check for inputs
        Scanner userNumber = new Scanner(System.in);
        Scanner addHzLn = new Scanner(System.in);
        Scanner addVrLn = new Scanner(System.in);
        while (x != 1){
            System.out.println("Type your choice: \n1. Add to horizontal line \n2. Add to vertical line \n3. Display multiplication table \n4. Stop the code\n(Code cant display number with more than 5 digits)");
            String userChoice = userNumber.nextLine();

            if (userChoice.equals("1")){
                System.out.println("What number would you like to add?");
                String horizontalAdd = addHzLn.nextLine();
                // turns the input into integers and puts them in the array
                int i=Integer.parseInt(horizontalAdd);
                horizontalLines.add(i);
                //prints out all the written down numbers in the array
                System.out.println("Current numbers in horziontal line:");
                for (int element: horizontalLines) {
                    System.out.println(element);
                }
            }

            else if (userChoice.equals("2")){
                System.out.println("What number would you like to add?");
                String verticalAdd = addVrLn.nextLine();
                // turns the input into integrs and puts them in the array
                int v=Integer.parseInt(verticalAdd);
                verticalLines.add(v);
                //prints out all the written down numbers in the array
                System.out.println("Current numbers in vertical line:");
                for (int element2: verticalLines) {
                    System.out.println(element2);
                }
            }
            else if (userChoice.equals("3")){
                for (int k = 0; k < horizontalLines.size(); k++){
                    for (int l = 0; l < verticalLines.size(); l++){
                        //multiplies all verticles with the first horizontal, once no more verticles it moves onto the next horizontal and continues again
                        result.add(horizontalLines.get(k) * verticalLines.get(l));
                    }
                }
                // Times table making
                for (int i = 0, j = 0; i < result.size(); i++, j++){
                    //First divider
                    if (i == 0){
                        System.out.print("||");
                    }
                    //Checks how many digits are in the numbers, adjusts the string size accordingly not to mess up the appearance of the table
                    if (String.valueOf(result.get(i)).length() == 1){
                        System.out.print("  "+result.get(i)+"  ");
                    }
                    else if (String.valueOf(result.get(i)).length() == 2){
                        System.out.print("  "+result.get(i)+" ");
                    }
                    else if (String.valueOf(result.get(i)).length() == 3){
                        System.out.print(" "+result.get(i)+" ");
                    }
                    else if (String.valueOf(result.get(i)).length() == 4){
                        System.out.print(" "+result.get(i)+"");
                    }
                    else if (String.valueOf(result.get(i)).length() == 5){
                        System.out.print(""+result.get(i)+"");
                    }
                    else if (String.valueOf(result.get(i)).length() > 5){
                        System.out.print("  x  ");
                    }
                    //Divider
                    System.out.print("||");

                    if(j == horizontalLines.size() - 1){
                        //if it runs out of numbers it breaks instead of making one last divider on a new line
                        if (result.get(i) == result.get(result.size() - 1)){
                            break;
                        }
                        System.out.print("\n");
                        // makes the verticle divider
                        int mon = 1;
                        while (mon != horizontalLines.size()+ 1){
                            System.out.print("───────");
                            mon++;
                        }
                        System.out.print("\n");
                        //reset value so it can start over on the next line
                        mon = 1;
                        System.out.print("||");
                        //j is a variable that resets so the new lines can exist, this rests them
                        if (i == horizontalLines.size()){
                            j = 0;
                        }
                        else{
                            j = -1;
                        }
                    }
                    
                }
                System.out.print("\n");
                break;
            }

            else if (userChoice.equals("4")){
                x ++;
            }

        }
        System.out.println("Booting down :)");
    }
}
