import java.util.Scanner;

public class MultiItemSale {

	// instance variables
	private Sale[] sale;
	private int indexSale;

	// zero argument constructor
	public MultiItemSale() {
		sale = new Sale[100];
		indexSale = 0;
	}

	// mutator method
	public void setIndex(int indexSale) {
		this.indexSale = indexSale;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		MultiItemSale basket = new MultiItemSale();
		String name = "";
		double price, discount, totalBill = 0;
		while (!name.equals("end")) {
			System.out.println("Enter item Name:");
			name = kb.nextLine();
			if (name.equals("end"))
				break;

			
			System.out.println("Enter a price:");
			price = Math.round(kb.nextDouble());
			System.out.println("Enter a discount:");
			discount = Math.round(kb.nextDouble());
			
			if (discount == 0) {
				basket.sale[basket.indexSale] = new Sale(name, price);
				basket.indexSale++;
			} else {
				basket.sale[basket.indexSale] = new DiscountSale(name, price, discount);
				basket.indexSale++;
			}
			kb.nextLine();
		}
		System.out.println("*****************TOTAL BILL*****************");
		for (int i = 0; basket.sale[i] != null; i++) {
			System.out.println(basket.sale[i].toString() + "\n");
			totalBill += basket.sale[i].bill();
		}
		System.out.printf("The total cost of the order is: $%.2f", totalBill);
	}
}
