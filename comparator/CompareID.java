package OOP.comparator;

import java.util.Comparator;

/**
 *  class CompareID.
 * 
 * @author David Sajd 
 * @version 7
 * 
 */
  public class CompareID implements Comparator<Shirts>{
    
    @Override
    public int compare(Shirts s, Shirts s1){
        String id = s.getShirtId();
        String id1 = s1.getShirtId();
        return id.compareTo(id1);
    }
    
}
