import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.io.*;


public class Driver {
	public static void main(String[] args) {
		List<Product> array = new ArrayList<Product>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a new item with the following format: '1 book at 12.49'.\nPress the return key to enter more items.\nType 'done' to print the receipt.\n");
		System.out.print("Item: ");
		while(!(sc.hasNext("done"))) {
			String name = "";
			double price = 0;
			int count = 0;
			boolean isExempt;
			boolean isImported;
			String x = sc.nextLine();
			if (x.contains("chocolate") || x.contains("pill") || x.contains("book")) {
				isExempt = true;
			} else {
				isExempt = false;
			}
			if (x.contains("imported")) {
				isImported = true;
			} else {
				isImported = false;
			}
			count = Character.getNumericValue(x.charAt(0));
			int index = x.indexOf(" at ");
			name = x.substring(2, index);
			price = Double.parseDouble((x.substring(index + 4)));
		
			
			array.add(new Product(name, price, count, isExempt, isImported));
	
			System.out.print("Item: ");
			
		}
		System.out.println();
		String receipt = "";
		double tax = 0;
		double total = 0;
		NumberFormat formatter = new DecimalFormat("#0.00");     
		for (Product product : array) {
		    receipt += product.getCount() + " " + product.getName() + ": " + formatter.format(product.getPrice()) + "\n";
		    tax += product.getTax();
		    total += product.getPrice();
		}
		receipt += "Sales Taxes: " + formatter.format(tax) + "\n" + "Total: " + formatter.format(total);
		System.out.print(receipt);
		
	}
}
