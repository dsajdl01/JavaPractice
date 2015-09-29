package OOP.comparator;


/**
 * class Shirts.
 * 
 * @author David Sajdl 
 * @version 7
 */
public class Shirts implements Shirt{
    private String id;
    private String color;
    private String sleevSize;
    private int qual;
    private int price;
    private int quan;
    
    public Shirts(String id, String color, String sleevs, int qual, int price, int quan){
        this.id = id;
        this.color = color;
        this.sleevSize = sleevs;
        this.qual = qual;
        this.price = price;
        this.quan = quan;
    }
    
    @Override
    public String getShirtId(){
        return this.id;
    }
    
    @Override
    public String getShirtColor(){
        return this.color;
    }
    
    @Override
    public String getSleevsSize(){
        return this.sleevSize;
    }
    
    @Override
    public int getCotonQual(){
        return this.qual;
    }
    
    @Override
    public int getPrice(){
        return this.price;
    }
    
    @Override
    public int getStockQuantity(){
        return this.quan;
    }
    
    @Override
    public String toString(){
        return "[shirt_id = " + this.id +",  shirt_color = " + this.color +
                ",  shirt has " + this.sleevSize + " sleevs,  shirt has " + this.qual +
                "% coton,  shitr cost = $" + this.price +".00,  shitrs on the stock = " + this.quan +"]";  
    }
}
