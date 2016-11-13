/* This is the java source file used for our project 2 submission. 
 *
 */
import java.util.Collections.*;
import java.util.Arrays;

 public class ProjectMain implements Helpers {

     public static void main(String args[]) {

        int[] b = {6,5,4};
        int[] c = {7};
        int[] d = {7,3};
        int[] e = {5,2,3,4,10,5,3};
        int[] f = {8,2,3,4,5,9,1,10,3,4,2,8};
    
        int test1 = IterApproach.FindOptimalScore(e,10);
     
        int test2 = RecurseApproach.FindOptimalScore(e,10);

        int test3 = RecurseMem.FindOptimalScore(e,10);

        System.out.println("Recursive, Memoized test out: " + test3);
        System.out.println("Recursive test out: " + test2);
        System.out.println("Iterative test out: " + test1);


     }
     
 }