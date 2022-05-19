// Name: Tayeeb Islam
// Student Number: c2003538
//Q1(b)

import java.util.*;

public class TestMagicSquare {
   public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     System.out.println("Welcome to the Magic Square Game!");
     System.out.print("Give an odd number: ");
     int n = in.nextInt();
     //checks the input to be odd
     if (n % 2 == 0){
       System.out.print("Give an odd number: ");
       n = in.nextInt();
     }

     magicSquareGame ms = new magicSquareGame(n);
     int [][] s = ms.makeMagicSquare();
     s = ms.shuffle(s);
     ms.printMagicSquare(s);
     int count = 0;
     boolean running = true;

     //loop to run the game
     while(running == true){

        System.out.println(" Make your swaps in the format (i j direction) Don't forget the spaces between them");
        System.out.println(" Where i and j specify the row and column of an element to be swapped, and direction (either U, D ,L ,R representing up, down, left and right) specifies which direction it should be swapped with.");
        count += 1;
        Scanner m = new Scanner(System.in);
        String move = m.nextLine();
        System.out.println("");
        //array to identify the move the user wishes to make
        String playersMove[] = move.split(" ");
        int a = Integer.valueOf(playersMove[0]);
        int b = Integer.valueOf(playersMove[1]);

        //if the players chooses to swapUp
        if (playersMove[2].equalsIgnoreCase("U")){
          ms.swapUp(s, (a-1), (b-1));
          ms.printMagicSquare(s);

        }
        //if the players chooses to swapDown
        else if(playersMove[2].equalsIgnoreCase("D")){
          ms.swapDown(s, (a -1), (b-1) );
          ms.printMagicSquare(s);

        }
        //if the players chooses to swapRight
        else if(playersMove[2].equalsIgnoreCase("R")){
          ms.swapRight(s, (a -1), (b-1) );
          ms.printMagicSquare(s);

        }
        //if the players chooses to swapLeft
        else if (playersMove[2].equalsIgnoreCase("L")){
          ms.swapLeft(s, (a -1), (b-1) );
          ms.printMagicSquare(s);

        }
        else{
          //validating wrong inputs
          System.out.println("Enter in correct format");
        }

        //checks if the game has been completed, then it will leave the loop
        if (ms.MagicSquareCheck(s) == true){
          running = false;
        }

    }
    //count represents the number of moves made
    System.out.println("You win and completed it in " + count + " moves.");









   }


}
