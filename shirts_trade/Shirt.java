package shirt_trade;

/**
 * Class Shirt
 * 
 * @author David Sajdl 
 * @version 7
 */
public class Shirt implements Product {
	
	private int id; 
	private String color; 
	private String sleevSize; 
	private int qual; 
	private double price; 
	private int quan; 
	
	public Shirt(int id, String color, String sleevs, int qual, double price, int quan){ 
	       this.id = id; 
	       this.color = color; 
	       this.sleevSize = sleevs; 
	       this.qual = qual; 
	       this.price = price; 
	       this.quan = quan; 
	} 


	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getShirtColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public String getSleevesSize() {
		// TODO Auto-generated method stub
		return this.sleevSize;
	}

	@Override
	public int getCotonQual() {
		// TODO Auto-generated method stub
		return this.qual;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return this.price;
	}
	public void addPrice(double price){
		this.price += price;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return this.quan;
	}
	
	public void plusQuantity(int q){
		this.quan += q;
	}

}
