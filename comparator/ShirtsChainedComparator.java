package OOP.comparator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Class ShirtsChainedComparator is the key to multysorting.
 * 
 * Comparator takes a list of comparators passed via its constructor; 
 * and the compare() method iterates over this comparators list to compare two 
 * Shitrs objects by each individual comparator. 
 * 
 * it is created separate comparators for each field 
 * by which we want to sort: id, color or quality.
 * 
 * @author David Sajdl 
 * @version 7
 */
public class ShirtsChainedComparator  implements Comparator<Shirts> {
   private List<Comparator<Shirts>> listComparators;
 
    @SafeVarargs
    public ShirtsChainedComparator(Comparator<Shirts>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    @Override
    public int compare(Shirts s1, Shirts s2) {
        for (Comparator<Shirts> comparator : listComparators) {
            int result = comparator.compare(s1, s2);
            if (result != 0) {
                return result;
            }
        }
        return 0;   
    }
}
