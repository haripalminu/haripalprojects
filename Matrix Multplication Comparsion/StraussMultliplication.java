/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mia
 */
public class StraussMultliplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        long lStartTime = System.nanoTime()/1000000;
            int rowsInA = 0,columnsInA = 0,columnsInB = 0;
       int [] elementsA = null,elementsB = null;
       BufferedReader reader = new BufferedReader(new FileReader("D:\\Matrix2.txt"));
        String line = null;
        int h=0;
        while ((line = reader.readLine()) != null) {
            
            if(h==0){
                 rowsInA=Integer.valueOf(line);
                
            }
            if(h==1){
                  columnsInA=Integer.valueOf(line);
                 
            }
            if(h==2){
                 columnsInB=Integer.valueOf(line);
                
            }
            if(h==3){
                String [] valuesA=(line.split(","));
                elementsA = new int[valuesA.length];
                for (int i=0; i < valuesA.length; i++) {
        elementsA[i] = Integer.parseInt(valuesA[i]);
    }
                
            }
            
          if(h==4){
                String [] valuesB=(line.split(","));
                elementsB = new int[valuesB.length];
                for (int i=0; i < valuesB.length; i++) {
        elementsB[i] = Integer.parseInt(valuesB[i]);
    }
                
            }
          h++;
     }
       int m = nextPowerOfTwo(rowsInA);
       int[][] a = new int[m][m];
       int[][] b = new int[m][m];
       System.out.println("Enter matrix A");
      int k=0;
       for (int i = 0; i < rowsInA; i++) {
           for (int j = 0; j <rowsInA ; j++) {
               
               a[i][j] =elementsA[k];
               k++;
           }
       }
       k=0;
       System.out.println("Enter matrix B");
       
      for (int i = 0; i < rowsInA; i++) {
           for (int j = 0; j <rowsInA ; j++) {
               b[i][j] =elementsB[k];
               k++;
           }
       }
        
     
            	
	PrintMatrix(strassen(a, b));
	long lEndTime = System.nanoTime()/1000000;
 
	long difference = lEndTime - lStartTime;
 
	System.out.println("Elapsed Nanoseconds: " + difference);
      
       
        
      
    }
    
     public static void PrintMatrix(int[][] a){
        
          for (int[] c1 : a) {
           for (int j = 0; j < a[0].length; j++) {
               System.out.print(c1[j] + " ");
           }
           System.out.println();
       }
       
    
   }
//    public static int[][] ikjAlgorithm(int[][] A, int[][] B) {
//    int n = A.length;
//
//    // initialise C
//    int[][] C = new int[n][n];
//
//    for (int i = 0; i < n; i++) {
//        for (int k = 0; k < n; k++) {
//            for (int j = 0; j < n; j++) {
//                C[i][j] += A[i][k] * B[k][j];
//            }
//        }
//    }
//    return C;
//}

private static int[][] add(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = A[i][j] + B[i][j];
        }
    }
    return C;
}

private static int[][] subtract(int[][] A, int[][] B) {
    int n = A.length;
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = A[i][j] - B[i][j];
        }
    }
    return C;
}

private static int nextPowerOfTwo(int n) {
    int log2 = (int) Math.ceil(Math.log(n) / Math.log(2));
    return (int) Math.pow(2, log2);
}

public static int[][] strassen(int[][] A, int[][] B) {
    // Make the matrices bigger so that you can apply the strassen
    // algorithm recursively without having to deal with odd
    // matrix sizes
   
int n=A[0].length;
    int[][] CPrep = strassenR(A, B);
    int[][] C = new int[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i][j] = CPrep[i][j];
        }
    }
    return C;
}
private static int[][] strassenR(int[][] A, int[][] B) {
    
    int number = A[0].length;
 int[][] C = new int[number][number];
    if (number == 1) {
               
            C[0][0] = A[0][0] * B[0][0];
    } else {
        // initializing the new sub-matrices
        int newSize = number / 2;
        int[][] a11 = new int[newSize][newSize];
        int[][] a12 = new int[newSize][newSize];
        int[][] a21 = new int[newSize][newSize];
        int[][] a22 = new int[newSize][newSize];

        int[][] b11 = new int[newSize][newSize];
        int[][] b12 = new int[newSize][newSize];
        int[][] b21 = new int[newSize][newSize];
        int[][] b22 = new int[newSize][newSize];

        int[][] aResult = new int[newSize][newSize];
        int[][] bResult = new int[newSize][newSize];

        // dividing the matrices in 4 sub-matrices:
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                a11[i][j] = A[i][j]; // top left
                a12[i][j] = A[i][j + newSize]; // top right
                a21[i][j] = A[i + newSize][j]; // bottom left
                a22[i][j] = A[i + newSize][j + newSize]; // bottom right

                b11[i][j] = B[i][j]; // top left
                b12[i][j] = B[i][j + newSize]; // top right
                b21[i][j] = B[i + newSize][j]; // bottom left
                b22[i][j] = B[i + newSize][j + newSize]; // bottom right
            }
        }

        // Calculating p1 to p7:
        aResult = add(a11, a22);
        bResult = add(b11, b22);
        int[][] p1 = strassenR(aResult, bResult);
        // p1 = (a11+a22) * (b11+b22)

        aResult = add(a21, a22); // a21 + a22
        int[][] p2 = strassenR(aResult, b11); // p2 = (a21+a22) * (b11)

        bResult = subtract(b12, b22); // b12 - b22
        int[][] p3 = strassenR(a11, bResult);
        // p3 = (a11) * (b12 - b22)

        bResult = subtract(b21, b11); // b21 - b11
        int[][] p4 = strassenR(a22, bResult);
        // p4 = (a22) * (b21 - b11)

        aResult = add(a11, a12); // a11 + a12
        int[][] p5 = strassenR(aResult, b22);
        // p5 = (a11+a12) * (b22)

        aResult = subtract(a21, a11); // a21 - a11
        bResult = add(b11, b12); // b11 + b12
        int[][] p6 = strassenR(aResult, bResult);
        // p6 = (a21-a11) * (b11+b12)

        aResult = subtract(a12, a22); // a12 - a22
        bResult = add(b21, b22); // b21 + b22
        int[][] p7 = strassenR(aResult, bResult);
        // p7 = (a12-a22) * (b21+b22)

        // calculating c21, c21, c11 e c22:
        int[][] c12 = add(p3, p5); // c12 = p3 + p5
        int[][] c21 = add(p2, p4); // c21 = p2 + p4

        aResult = add(p1, p4); // p1 + p4
        bResult = add(aResult, p7); // p1 + p4 + p7
        int[][] c11 = subtract(bResult, p5);
        // c11 = p1 + p4 - p5 + p7

        aResult = add(p1, p3); // p1 + p3
        bResult = add(aResult, p6); // p1 + p3 + p6
        int[][] c22 = subtract(bResult, p2);
        // c22 = p1 + p3 - p2 + p6

        // Grouping the results obtained in a single matrix:
       
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                C[i][j] = c11[i][j];
                C[i][j + newSize] = c12[i][j];
                C[i + newSize][j] = c21[i][j];
                C[i + newSize][j + newSize] = c22[i][j];
            }
        }
     
    
}
           return C;
    
}
}
