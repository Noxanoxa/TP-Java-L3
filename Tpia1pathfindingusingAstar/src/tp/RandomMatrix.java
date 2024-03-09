package tp;

import java.util.Random;

public class RandomMatrix {
  public static void main(String[] args) {
    Random rand = new Random();
    int numRows = rand.nextInt(10) + 1; // Randomly choose number of rows between 1 and 10 (inclusive)
    int numCols = rand.nextInt(10) + 1; // Randomly choose number of columns between 1 and 10 (inclusive)
    int[][] matrix = new int[numRows][numCols]; // Create matrix with dynamic dimensions
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        matrix[i][j] = rand.nextInt(35) + 1; // Fill matrix with random values between 0 and 99 (inclusive)
      }
    }
    
    
    int[] matri = new int[7]; // Create matrix with dynamic dimensions
      for (int j = 0; j < 7; j++) {
        matri[j] = rand.nextInt(35) + 1; // Fill matrix with random values between 0 and 99 (inclusive)
        System.out.print(matri[j] + " ");

      }
      for (int j = 0; j < 7; j++) {
    	  int[] matr = new int[7]; // Create matrix with dynamic dimensions
    	  matri[j] = rand.nextInt(35) + 1; // Fill matrix with random values between 0 and 99 (inclusive)
    	  System.out.print(matri[j] + " ");
    	  
      }
    
    
//    // Print the matrix
//    for (int i = 0; i < numRows; i++) {
//      for (int j = 0; j < numCols; j++) {
//        System.out.print(matrix[i][j] + " ");
//      }
//      System.out.println();
//    }
  }
}