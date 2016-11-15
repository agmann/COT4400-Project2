/* This is the java source file used for our project 2 submission. 
 *
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections.*;
import java.util.Arrays;
import java.util.Scanner;

 public class ProjectMain {

     public static void main(String args[]) {

         int[] b = {6, 5, 4};
         int[] c = {7};
         int[] d = {7, 3};
         int[] e = {5, 2, 3, 4, 10, 5, 3};
         int[] f = {8, 2, 3, 4, 5, 9, 1, 10, 3, 4, 2, 8};

         Scanner scan = null;
         File inputFile = null;
         File outputFile = null;
         FileWriter writer = null;

         try {
             inputFile = new File("input.txt");
             outputFile = new File("output.txt");
             outputFile.createNewFile();
             writer = new FileWriter(outputFile);
             scan = new Scanner(inputFile);
         } catch (Exception ex) {
             System.out.println("Error with the input/output files.");
         }

         int numOfProblems = Integer.parseInt(scan.nextLine().trim());

         for (int problems = 0; problems < numOfProblems; problems++) {

             int arrLength = scan.nextInt();
             int t = Integer.parseInt(scan.nextLine().trim());

             String[] arrayString = scan.nextLine().trim().split(" ");
             int[] arr = new int[arrLength];

             for (int i = 0; i < arr.length; i++) {
                 arr[i] = Integer.parseInt(arrayString[i]);
             }

             PartInfo test1 = (IterApproach.FindOptimalScore(arr, t));

             try {

                 writer.write(test1.psizes.size() + " ");

                 for (int x : test1.psizes) {
                     writer.write(x + " ");
                 }

                 writer.write("\n");

             } catch (Exception ex) {
                 ex.printStackTrace();
             }
         }

         try {
             //cleaning up
             writer.flush();
             writer.close();
             scan.close();
         }catch (Exception ex){
             ex.printStackTrace();
         }
     }
 }