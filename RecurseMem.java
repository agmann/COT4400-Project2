import java.util.Arrays;
import java.util.Map;

public class RecurseMem {

     /** FIXME: modify this algorithm to be memoized
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