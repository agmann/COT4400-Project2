import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by jonat on 11/12/2016.
 */

public class IterApproach {

    public static int FindOptimalScore(int[] a, int t) {

        //init varibles
        int[][] ineqScores = new int[a.length][a.length];
        int tempSum;
        int tempIneqScoreSum = 0;
        int[] holdMin = new int[a.length + 1];

        //keeps stats about partitions made;
        ArrayList<int> partSizes = new ArrayList<int>();


        //init 2D array
        for (int i = 0; i < a.length; i++){
            for( int j = 0; j < a.length; j++){
                ineqScores[i][j] = Integer.MAX_VALUE;
            }
        }

        //init array that will hold the min column value of the inequScores
        for(int i = 0; i < holdMin.length; i++){
            holdMin[i] = Integer.MAX_VALUE;
        }

        holdMin[0] = 0;

        for(int i = 0; i < a.length; i++){

            tempSum = 0;
            int numInPart = 0;
            for (int j = i; j < a.length; j++) {
                //use this to compute the sum of the partition
                tempSum += a[j];
                numInPart++;

                if (tempSum <= t) {
                    //store the ineq score plus the previous partition's scores
                    ineqScores[i][j] = (t - tempSum) * (t - tempSum) + holdMin[i];

                    //update the min array according
                    holdMin[j+1] = ineqScores[i][j] < holdMin[j+1]? ineqScores[i][j]: holdMin[j+1];

                } else {
                    tempSum = 0;
                    break;
                }

            }
        }

        return holdMin[a.length];
    }
}
