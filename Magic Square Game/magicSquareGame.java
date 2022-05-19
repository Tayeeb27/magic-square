// inputame: Tayeeb Islam
// Student inputumber: c2003538
//Q1(b)

import java.util.*;

public class magicSquareGame {
  private int input;

//constructor
public magicSquareGame(int input) {
  this.input = input;

}

//Method to print Magic Square
public int[][] printMagicSquare(int [][] square){
  for (int i = 0; i < square.length; i++) {
    System.out.print("| ");
      for (int j = 0; j < square.length; j++) {
          System.out.print(square[i][j] + " | ");

      }
      System.out.println();

  }
  System.out.println();
  return square;
}
//Method to make Magic Square
public int[][] makeMagicSquare(){

    System.out.println("The Magic Square for n = " + input);
    System.out.println("with the sum of each row, column and diagonal = " + input*(input*input +1)/2);
    int[][] magicSquare = new int[input][input];

    int number = 1;
    int x = 0;
    int y = input / 2;
    int curr_row;
    int curr_col;
    while (number <= input * input) {
        magicSquare[x][y] = number;
        number++;
        curr_row = x;
        curr_col = y;
        x -= 1;
        y += 1;
        if (x == -1) {
            x = input - 1;
        }
        if (y == input) {
            y = 0;
        }
        if (magicSquare[x][y] != 0) {
            x = curr_row + 1;
            y = curr_col;
            if (x == -1) {
                x = input - 1;
            }
        }
    }


return magicSquare;
}
//Method to shuffle
public int[][] shuffle(int[][] shuffledMagicSquare){


     Random random = new Random();
     int numberOfValues = shuffledMagicSquare.length * shuffledMagicSquare[0].length;
     for (int i = numberOfValues - 1; i > 0; i--) {
        int index = random.nextInt(i);
        int row = i / shuffledMagicSquare[0].length;
        int column = i - row * shuffledMagicSquare[0].length;
        int randomRow = index / shuffledMagicSquare[0].length;
        int randomColumn = index - randomRow * shuffledMagicSquare[0].length;
        int temp = shuffledMagicSquare[row][column];
        shuffledMagicSquare[row][column] = shuffledMagicSquare[randomRow][randomColumn];
        shuffledMagicSquare[randomRow][randomColumn] = temp;
}




     return shuffledMagicSquare;


}


public int[][] swapUp(int[][] shuffledMagicSquare, int a, int b){
  if (a == 0){
    int temp = shuffledMagicSquare[0][b];
    shuffledMagicSquare[0][b] = shuffledMagicSquare[shuffledMagicSquare.length -1][b];
    shuffledMagicSquare[shuffledMagicSquare.length-1][b] = temp;
  } else
  {
    int temp = shuffledMagicSquare[a-1][b];
    shuffledMagicSquare[a-1][b] = shuffledMagicSquare[a][b];
    shuffledMagicSquare[a][b] = temp;
  }
  return shuffledMagicSquare;
}
public int[][] swapDown(int[][] shuffledMagicSquare, int a, int b){
  if (a == shuffledMagicSquare.length - 1){
    int temp = shuffledMagicSquare[shuffledMagicSquare.length -1][b];
    shuffledMagicSquare[shuffledMagicSquare.length -1][b] = shuffledMagicSquare[0][b];
    shuffledMagicSquare[0][b] = temp;
  } else
  {
  int temp = shuffledMagicSquare[a+1][b];
  shuffledMagicSquare[a+1][b] = shuffledMagicSquare[a][b];
  shuffledMagicSquare[a][b] = temp;
}
  return shuffledMagicSquare;
}
public int[][] swapRight(int[][] shuffledMagicSquare, int a, int b){
  if (b == shuffledMagicSquare.length - 1){
    int temp = shuffledMagicSquare[a][shuffledMagicSquare.length -1];
    shuffledMagicSquare[a][shuffledMagicSquare.length -1] = shuffledMagicSquare[a][0];
    shuffledMagicSquare[a][0] = temp;
  } else
  {
    int temp = shuffledMagicSquare[a][b+1];
    shuffledMagicSquare[a][b+1] = shuffledMagicSquare[a][b];
    shuffledMagicSquare[a][b] = temp;
  }
  return shuffledMagicSquare;
}
public int[][] swapLeft(int[][] shuffledMagicSquare, int a, int b){
  if (b == 0){
    int temp = shuffledMagicSquare[a][0];
    shuffledMagicSquare[a][0] = shuffledMagicSquare[a][shuffledMagicSquare.length-1];
    shuffledMagicSquare[a][shuffledMagicSquare.length-1] = temp;
  } else
  {
    int temp = shuffledMagicSquare[a][b-1];
    shuffledMagicSquare[a][b-1] = shuffledMagicSquare[a][b];
    shuffledMagicSquare[a][b] = temp;
  }

  return shuffledMagicSquare;

}
//Method to check whether the user has completed the task
public boolean MagicSquareCheck(int[][] shuffledMagicSquare){
  int total = 0;
  int total2 = 0;
  //Prime diagonal
  for (int i = 0; i < input; i++){
    total = total + shuffledMagicSquare[i][i];
  }
  //secondary diagnol
  for (int i = 0; i < input; i++){
    total2 = total2 + shuffledMagicSquare[i][input-1-i];
  }
  if(total != total2){
      return false;
  }

  // RowTotal
  for (int i = 0; i < input; i++) {
    int rowTotal = 0;
    for (int j = 0; j < input; j++){
      rowTotal += shuffledMagicSquare[i][j];
    }
    if (rowTotal != total)
      return false;
   }

    // Column Toto
    for (int i = 0; i < input; i++) {
      int colTotal = 0;
      for (int j = 0; j < input; j++){
        colTotal += shuffledMagicSquare[j][i];
      }
      if (total != colTotal){
        return false;
      }
    }

        return true;
    }
}
