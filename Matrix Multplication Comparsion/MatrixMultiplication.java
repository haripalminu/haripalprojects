/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment1;

/**
 *
 * @author mia
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MatrixMultiplication {

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
       
       int[][] a = new int[rowsInA][columnsInA];
       int[][] b = new int[columnsInA][columnsInB];
       System.out.println("Enter matrix A");
      int k=0;
       for (int[] a1 : a) {
           for (int j = 0; j < a[0].length; j++) {
               a1[j] =elementsA[k];
               k++;
           }
       }
       k=0;
       System.out.println("Enter matrix B");
       
       for (int[] b1 : b) {
           for (int j = 0; j < b[0].length; j++) {
               b1[j] =elementsB[k];
               k++;
           }
       }
        
       	
	int[][] c = Multiply(a, b);
         System.out.println("Product of A and B is");
        PrintMatrix(c);
	long lEndTime = System.nanoTime()/1000000;
 
	long difference = (lEndTime - lStartTime)/1000;
 
	System.out.println("Elapsed Nanoseconds: " + difference);
       
   }

   public static int[][] Multiply(int[][] a, int[][] b){
       
       int rowsInA = a.length;
       int columnsInA = a[0].length; // same as rows in B
       int columnsInB = b[0].length;
       int[][] c = new int[rowsInA][columnsInB];
       for (int i = 0; i < rowsInA; i++) {
           for (int j = 0; j < columnsInB; j++) {
               for (int k = 0; k < columnsInA; k++) {
                   c[i][j] = c[i][j] + a[i][k] * b[k][j];
               }
           }
       }
       return c;
   }
   
    public static void PrintMatrix(int[][] a){
        
          for (int[] c1 : a) {
           for (int j = 0; j < a[0].length; j++) {
               System.out.print(c1[j] + " ");
                }
           System.out.println();
       }
       
    
   }
}
