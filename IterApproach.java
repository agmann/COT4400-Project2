import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jonat on 11/12/2016.
 */

public class IterApproach {

    public static int FindOptimalScore(int[] a, int t) {

        //init varibles
        int tempSum;
        int tempIneqScore = 0;
        int[] holdMin = new int[a.length + 1];

        //keeps stats about partitions made;
        ArrayList<Integer> partSizes = new ArrayList<>();


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
                    tempIneqScore = (t - tempSum) * (t - tempSum) + holdMin[i];

                    //update the min array according
                    holdMin[j+1] = tempIneqScore < holdMin[j+1]? tempIneqScore: holdMin[j+1];

                } else {
                    tempSum = 0;
                    break;
                }

            }
        }

        return holdMin[a.length];
    }
}
