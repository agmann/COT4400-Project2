import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by jonat on 11/12/2016.
 */

public class IterApproach implements Helpers {

    public static int FindOptimalScore(int[] a, int t) {

        int[][] ineqScores = new int[a.length][a.length];
        int min = Integer.MAX_VALUE;
        int tempSum;
        int tempIneqScoreSum = 0;

        //init 2D array
        for (int i = 0; i < a.length; i++){
            for( int j = 0; j < a.length; j++){
                ineqScores[i][j] = Integer.MAX_VALUE;
            }
        }

        if (a.length == 1) {

            ineqScores[0][0] = (t - a[0])*(t - a[0]);
            return ineqScores[0][0];
        }

        for(int i = 0; i < a.length; i++){

            tempSum = 0;

            for (int j = i; j < a.length; j++) {
                tempSum += a[j];
                if (tempSum <= t) {

                    ineqScores[i][j] = (t - tempSum) * (t - tempSum);
                }
                else {
                    tempSum = 0;
                    break;
                }
            }
        }

        return 0;
    }
}
