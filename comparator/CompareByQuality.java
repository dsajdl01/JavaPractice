package OOP.comparator;

import java.util.Comparator;
/**
 * Class CompareByQuality.
 * 
 * @author David Sajdl 
 * @version 7
 */
public class CompareByQuality implements Comparator<Shirts>{
    

    @Override
    public int compare(Shirts s, Shirts s1){
        return s.getCotonQual() - s1.getCotonQual();
    }
    
}