/* Authors: Jack Burger, Austin Mann, Jonathan Valencia
 *
 * This class solves the variation of the Integer Partition problem using iterative dynamic programming
 *
 */

import java.util.*;

public class IterApproach {

    public static PartInfo FindOptimalScore(int[] a, int t) {

        //init varibles
        int tempSum;
        int tempIneqScore = 0;
        int[] holdMin = new int[a.length + 1];

        //keeps stats about partitions made;
        ArrayList<Integer> partSizes = new ArrayList<Integer>();

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


                if (tempSum <= t) {

                    numInPart++;

                    //store the ineq score plus the previous partition's scores
                    tempIneqScore = (t - tempSum) * (t - tempSum) + holdMin[i];
                    
                    if (tempIneqScore < holdMin[j+1]) {

                        holdMin[j+1] = tempIneqScore;

                        try {
                            partSizes.set(j, j - i + 1);
                        }catch (Exception ex){
                            partSizes.add(j-i+1);
                        }
                    }

                } else {
                    numInPart--;
                    tempSum = 0;
                    break;
                }
            }
        }

        int minIndex = a.length -1;

        ArrayList<Integer> solutionArray = new ArrayList<>();

        while(minIndex >= 0){

            solutionArray.add(partSizes.get(minIndex));

            minIndex -= partSizes.get(minIndex) ;

        }
        Collections.reverse(solutionArray);

        return (new PartInfo(holdMin[a.length], solutionArray));
    }
}
