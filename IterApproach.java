import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by jonat on 11/12/2016.
 */

public class IterApproach implements Helpers {
    /* FIXME: clean up self checking code
      *
      */

    public int FindOptimalScore(int[] a, int t) {

        int[][] storeScores = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++){
            for( int j = 0; j < a.length; j++){
                storeScores[i][j] = Integer.MAX_VALUE;
            }
        }

        int min;
        int temp;

        if (a.length == 1) {

            storeScores[0][0] = (t - a[0])*(t - a[0]);
            return storeScores[0][0];
        }

        for(int i = 0; i < a.length; i++){

            min = Integer.MAX_VALUE;
            temp = 0;

            for (int j = i; j < a.length; j++) {
                temp += a[j];
                if (temp <= t) {

                    storeScores[i][j] = (t - temp) * (t - temp);
//                    we are going to need to find the optimal solution. this will only fill in the table I think.
//                    if (ineq < min) {
//                        //System.out.println("ineq (" + ineq + ") is less than min (" + min + ")");
//                        min = ineq;
//                    }
                }
                else {
                    temp = 0;
                    break;
                }
            }
        }

        //System.out.println("returning " + min);
        return 0;
    }
}
