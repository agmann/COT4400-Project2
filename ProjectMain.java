/* This is the java source file used for our project 2 submission. 
 *
 */
import java.util.Collections.*;
import java.util.Arrays;

 public class ProjectMain {

     public static void main(String args[]) {
         System.out.println("Hello World!");

        int[][] totals = new int[5][5]; 

        int[] b = {5,6,4};

        int test = populate(b,10);

        System.out.println("Test out: " + test);


     }

     public static int populate(int[] a, int t) {
         if (a.length == 1) {
            return (t - a[0]); 
         }
         int lhs = (t - a[0]) * (t - a[0]);
         int rhs = populate(Arrays.copyOfRange(a,1,a.length-1),t);
         int ineq = lhs + rhs; 
         int min = ineq;
         int i = 0;
         while (i < a.length-1) {
             if (a[i] + a[i+1] <= t) {
                lhs = (t - (a[i]+a[i+1])) * (t - (a[i]+a[i+1]));
                rhs = populate(Arrays.copyOfRange(a,1,a.length-1),t);
                ineq = lhs + rhs; 
                if (ineq < min) 
                    min = ineq;
                i++;
             }
         } 
         return min;
     }

 }