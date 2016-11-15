/* Authors: Jack Burger, Austin Mann, Jonathan Valencia
 *
 * This class represents a solution.
 */
import java.util.*;

public class PartInfo {
    public int ineq;
    public ArrayList<Integer> psizes;

    public PartInfo(int i, ArrayList<Integer> ps) {
        psizes = ps;
        ineq = i;
    }
}