/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author mia
 */
public class GenerateFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
        int a,b,c;
        PrintWriter writer = new PrintWriter("D:\\Matrix2.txt", "UTF-8");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the first Matrix rows");
             a=reader.nextInt();
             writer.println(a);
            System.out.println("Enter the first Matrix Columns");
             b=reader.nextInt();
             writer.println(b);
            System.out.println("Enter the Second Matrix Columns");
             c=reader.nextInt();
             writer.println(c);
   for(int i=1;i<=a*b;i++) {
       writer.print(i);
       if(i!=a*b)
       writer.print(",");
   } 
   writer.println();
      for(int i=1;i<=c*b;i++) {
       writer.print(i);
       if(i!=c*b)
       writer.print(",");
   }

writer.close();
    }
    
}
