/* This is the java source file used for our project 2 submission. 
 *
 */
import java.util.Collections.*;
import java.util.Arrays;

 public class ProjectMain {

     public static void main(String args[]) {
        System.out.println("Hello World!");

        int[] b = {6,5,4};

        int test = populate(b,10);

        System.out.println("Test out: " + test);


     }
     /* FIXME: uggghhh
      *
      */
     public static int populate(int[] a, int t) {
         if (a.length == 1) {
             System.out.println("Size is 1!");
             int ineq = (t - a[0])*(t - a[0]);
             System.out.println("ineq is " + ineq);
             return ineq;
         }
         System.out.println("Size isn't' 1!");
         System.out.println("This: " + a[0] + " and " + a[1]);
         int ineq = (t - a[0])*(t - a[0]) + populate(Arrays.copyOfRange(a,1,a.length),t); 
         int min = ineq;
         for (int i = 0; i < a.length-1; i++) {
             int maxlength = findMaxSub(a, t, i+2);
             if (maxlength <= 1)
                return min;
             int sum = findSubSum(a, maxlength);
             ineq = (t - sum)* (t - sum) + populate(Arrays.copyOfRange(a,maxlength-1,a.length),t);
             if (ineq < min)
                min = ineq;
         }
         return min;
     }

     private static int findMaxSub(int[] a, int t, int bound) {
         int sum = 0;
         for (int i = 0; i < bound; i++) {
             sum += a[i];
             if (sum > t) {
                 return i;
             }
         }
         return bound;
     }

     private static int findSubSum(int[] a, int maxlen) {
         int sum = 0;
         for (int x : a) {
             sum += x;
         }
         return sum;
     }

 }