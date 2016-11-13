/**
 * Created by jonat on 11/12/2016.
 */
public class Helpers {
    static int getScore(int[] a, int t, int sizeSubset) {
        int sum = getSubsetSum(a, sizeSubset);
        return (t - sum)*(t - sum);
    }

    static int getSubsetSum(int[] a, int sizeSubset) {
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
