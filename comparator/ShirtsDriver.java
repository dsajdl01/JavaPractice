package OOP.comparator;
import java.util.Map;
import java.util.*;

/**
 *  class ShirtsDriver.
 * 
 * @author David Sajdl 
 * @version 7
 */
public class ShirtsDriver {
    
    public static void main(String[]args){
        // read shirts.scv file
        SCVReader file = new SCVReader();
        Map<Integer, Shirts> shirts = file.readDataFronSCVShitrFile();
        Shirts[] s = new Shirts[shirts.size()];
        // print .scv file values
        for(int i = 0; i < shirts.size(); i++){
            System.out.println(shirts.get(i));
            s =  shirts.values().toArray(new Shirts[i]); 
        }
        // sort array by shirt's id "attribute id" 
        Arrays.sort(s, new CompareID());
        System.out.println("\nArray after sorting by shirt id:");
        for(int i = 0; i < s.length; i++){
            System.out.println(s[i]);
        }
        // shuffle array
        Shuffle sffl = new Shuffle();
        s = sffl.shuffle(s);
        // convert array to list
        List<Shirts> shList = Arrays.asList(s);
        // printout list with shuffles values
        System.out.println("\nShirts array after shuffling:");
        for (Shirts srt : shList) {
            System.out.println(srt);
        }
       // sotr list by shirt's colour and chirt's Quantity
       Collections.sort(shList, new ShirtsChainedComparator(
                new ComparebyColor(),
                new CompareByQuality()));
       // print out sorted list 
       System.out.println("\nlist after sorting by color and quality id is:");
        for (Shirts l : shList) {
            System.out.println(l);
        }
       
    }
  
}
