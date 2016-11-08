/* C++ */

#include <math>

    int main () {
        int[] b = {6,4};

        int test = populate(b,10);

        System.out.println("Test out: " + test);


     }

     int populate(int[] a, int t) {
         if (a.length == 1) {
             return (t - a[0])*(t - a[0]);
         }
         int ineq = (t - a[0])*(t - a[0]) + populate(Arrays.copyOfRange(a,1,a.length),t); 
         int min = ineq;
         for (int i = 0; i < a.length-1; i++) {
             int maxlength = findMaxSub(a, t, i+2);
             if (maxlength <= 1)
                return min;
             int sum = findSubSum(a, maxlength);
             ineq = (t - sum)* (t - sum) + populate(Arrays.copyOfRange(a,maxlength,a.length),t);
             if (ineq < min)
                min = ineq;
         }
         return min;
     }

     int findMaxSub(int[] a, int t, int bound) {
         int sum = 0;
         for (int i = 0; i < bound; i++) {
             sum += a[i];
             if (sum > t) {
                 return i;
             }
         }
         return bound;
     }

     int findSubSum(int[] a, int maxlen) {
         int sum = 0;
         for (int i = 0; i < maxlen; i++) {
             sum += a[i];
         }
         return sum;
     }

