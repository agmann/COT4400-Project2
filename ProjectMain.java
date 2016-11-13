/* This is the java source file used for our project 2 submission. 
 *
 */
import java.io.File;
import java.io.IOException;
import java.util.Collections.*;
import java.util.Arrays;
import java.util.Scanner;

public class ProjectMain implements Helpers {

     public static void main(String args[]) {

         //test data
        int[] b = {6,5,4};
        int[] c = {7};
        int[] d = {7,3};
        int[] e = {5,2,3,4,10,5,3};
        int[] f = {8,2,3,4,5,9,1,10,3,4,2,8};

         Scanner scan = null;
         File inputFile = null;
         File outputFile = null;

         try {
             inputFile = new File("input.txt");
             outputFile = new File("output.txt");
             scan = new Scanner(inputFile);
         }catch (Exception ex){
             System.out.println("Error with the input/output files.");
         }

         int numOfProblems = Integer.parseInt(scan.nextLine().trim());

         for(int problems = 0; problems < numOfProblems; problems++) {

             int arrLength = scan.nextInt();
             int t = Integer.parseInt(scan.nextLine().trim());

             String[] arrayString = scan.nextLine().trim().split(" ");
             int[] arr = new int[arrLength];

             for (int i = 0; i < arr.length; i++) {
                 arr[i] = Integer.parseInt(arrayString[i]);
             }

             //from here we should be able to use arr as the file input
             //once we are done testing.
             int test1 = IterApproach.FindOptimalScore(e, 10);
             int test2 = FindOptimalScore(b, 10);

             System.out.println("Recursive test out: " + test1);
             System.out.println("Iterative test out: " + test2);
         }

        scan.close();
     }


     public static int FindOptimalScore(int[] a, int t) {
         if (a.length == 1) {
             //System.out.println("length is 1");
             int ineq = (t - a[0])*(t - a[0]);
             //System.out.println("returned " + ineq);
             return ineq;
         }
         int min = (t - a[0])*(t - a[0]) + FindOptimalScore(Arrays.copyOfRange(a,1,a.length),t);
         //Known that a.length is at least 2, so attempt to consolidate
         for (int i = 2; i <= a.length; i++) {
             if (t >= Helpers.getSubsetSum(a,i)) {
                 int ineq = Helpers.getScore(a,t,i);
                 //System.out.println("ineq is " + ineq);
                 if (i <= a.length-1) {
                     //System.out.println("recurse...");
                     ineq += FindOptimalScore(Arrays.copyOfRange(a,i,a.length),t);
                 }
                 if (ineq < min) {
                     //System.out.println("ineq (" + ineq + ") is less than min (" + min + ")");
                     min = ineq;
                 }
             }
         }
         //System.out.println("returning " + min);
         return min;
     }
 }