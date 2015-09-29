package OOP.comparator;

import java.util.Comparator;

/**
 * Class ComparebyColor.
 * 
 * @author David Sajdl 
 * @version 7
 * 
 */
public class ComparebyColor implements Comparator<Shirts>{
    

    @Override
    public int compare(Shirts s, Shirts s1){
        String cl = s.getShirtColor();
        String cl1 = s1.getShirtColor();
        return cl.compareTo(cl1);
    }
    
}