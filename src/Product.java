
public class Product {
	
	  private final String name;
	  private double price;
	  private final int count;
	  private final boolean isExempt;
	  private final boolean isImported;
	  
	  public Product(String name, double price, int count, boolean isExempt, boolean isImported) {
	    this.name = name;
	    this.price = price;
	    this.count = count;
	    this.isExempt = isExempt;
	    this.isImported = isImported;
	    
	  }
	  
	  public String getName() {
		  return name;
	  }
	  
	  public int getCount() {
		  return count;
	  }
	  
	  public double getPrice() {
		  double temp = getCount() * price;
		  return temp += getTax();
	  }
	  
	  public boolean isExempt() {
		  return isExempt;
	  }

	  public boolean isImported() {
		  return isImported;
	  }
	  
	  public double getTax() {
		  double tax = 0;
		  if (this.isExempt == false && this.isImported == true) {
			  tax = (price * 0.10) + (price * 0.05);
			  return getCount() * Math.round(tax * 20.0) / 20.0;
		  } else if (this.isExempt == true && this.isImported == true) {
			  tax = price * 0.05;
			  return getCount() * Math.round(tax * 20.0) / 20.0;
		  } else if (this.isExempt == false && this.isImported == false) {
			  tax = price * 0.10;
			  return getCount() * Math.round(tax * 20.0) / 20.0;
		  } else {
			  return tax;
		  }
		  
	  }
}
