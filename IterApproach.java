import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by jonat on 11/12/2016.
 */

public class IterApproach {

    public static int FindOptimalScore(int[] a, int t) {

        int[][] ineqScores = new int[a.length][a.length];
        int min = Integer.MAX_VALUE;
        int tempSum;
        int tempIneqScoreSum = 0;
        int[] holdMin = new int[a.length + 1];
        int tempMin = 0;

        //init 2D array
        for (int i = 0; i < a.length; i++){
            for( int j = 0; j < a.length; j++){
                ineqScores[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < holdMin.length; i++){
            holdMin[i] = Integer.MAX_VALUE;
        }
        holdMin[0] = 0;

        for(int i = 0; i < a.length; i++){

            tempSum = 0;

            for (int j = i; j < a.length; j++) {
                tempSum += a[j];


                if (tempSum <= t) {

                    ineqScores[i][j] = (t - tempSum) * (t - tempSum) + holdMin[i];
                    holdMin[j+1] = ineqScores[i][j] < holdMin[j+1]? ineqScores[i][j]: holdMin[j+1];

                } else {
                    tempSum = 0;
                    break;
                }

            }
            min = tempIneqScoreSum < min? tempIneqScoreSum: min;
        }

        return holdMin[a.length];
    }
}
