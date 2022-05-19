// Name: Tayeeb Islam
// Student Number: c2003538
//Q1(a)

import java.util.*;

public class magicSquare {
   public static void main(String[] args) {

    System.out.print("Give an odd number: ");
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    if (n % 2 == 0){
      System.out.print("Give an odd number: ");
      n = in.nextInt();
    }

    int[][] magicSquare = new int[n][n];

    int number = 1;
    int x = 0;
    int y = n / 2;
    int curr_row;
    int curr_col;
    while (number <= n * n) {
        magicSquare[x][y] = number;
        number++;
        curr_row = x;
        curr_col = y;
        x -= 1;
        y += 1;
        if (x == -1) {
            x = n - 1;
        }
        if (y == n) {
            y = 0;
        }
        if (magicSquare[x][y] != 0) {
            x = curr_row + 1;
            y = curr_col;
            if (x == -1) {
                x = n - 1;
            }
        }
    }

    for (int i = 0; i < magicSquare.length; i++) {
      System.out.print("| ");
        for (int j = 0; j < magicSquare.length; j++) {
            System.out.print(magicSquare[i][j] + " | ");
        }
        System.out.println();

    }


   }

}
