package OOP.comparator;

import java.util.Random;

/**
 * Class Shuffle enable shuffle an arrat with type Shirts.
 * 
 * @author David Sajd 
 * @version 7
 */
public class Shuffle {
  
    public Shirts[] shuffle(Shirts[] s){
		int N = s.length;
		for(int i = 0; i< N; i++){
			int r = uniform(i +1);
			exch(s,i, r);
		}
		return s;
	}
	
	private int uniform(int N) {
		 Random rand = new Random();
		 if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
		 int randomNum = rand.nextInt(N);
       return randomNum;
   }
   private void exch(Shirts[] a, int b, int c){
		Shirts swop = a[b];
		a[b] = a[c];
		a[c] = swop;
	}
}
    