/* This is the java source file used for our project 2 submission. 
 *
 */
import java.util.Collections.*;
import java.util.Arrays;

 public class ProjectMain {

     public static void main(String args[]) {
        System.out.println("Hello World!");

        int[] b = {6,5,4};
        int[] c = {7};
        int[] d = {7,3};
        int[] e = {5,2,3,4,10,5,3};
        int[] f = {8,2,3,4,5,9,1,10,3,4,2,8};

        int test = FindOptimalScore(b,10);

        System.out.println("Test out: " + test);


     }
     /* FIXME: clean up self checking code
      *
      */
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
             if (t >= getSubsetSum(a,i)) {
                 int ineq = getScore(a,t,i);
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

     private static int getScore(int[] a, int t, int sizeSubset) {
         int sum = getSubsetSum(a, sizeSubset);
         return (t - sum)*(t - sum);
     }

     private static int getSubsetSum(int[] a, int sizeSubset) {
         int sum = 0;
         if (a.length < sizeSubset) {
             return sum; 
         }
         for (int i = 0; i < sizeSubset; i++) {
             sum += a[i];
         }
         return sum;
         
     }



 }