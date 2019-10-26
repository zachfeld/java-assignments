package shell;
public class ShoppingCart {
	//one static variable and four instance variables
	public static final int STANDARD_CAPACITY = 15;
	private int capacity = STANDARD_CAPACITY;
	private Fruit[] cart = null;
	private int lastUsedSpot = -1;
	private boolean priority = false;
	
	//0 argument constructor that sets an empty fruit cart to standard capacity
	ShoppingCart() {
		cart = new Fruit[capacity];
	}
	//2 argument constructor that sets a new capacity and priority for the cart
	ShoppingCart(int newCapacity, boolean newPriority) {
		if (newCapacity > 0) {
			this.capacity = newCapacity;
			cart = new Fruit[newCapacity];
		}
		else
			cart = new Fruit[capacity];
		this.priority = newPriority;
	}
	//returns true if cart is not full
	public boolean toCapacity() {
		for (int i = 0; i < this.cart.length; i++) {
			if (this.cart[i] == null) 
				return false;
		}
		return true;
	}
	//adds a fruit to the cart if the cart is not full and if it is compatible with all other fruits in the cart
	public boolean addFruit(String name, int type, int numItems, int weight) {
		Fruit temporary = new Fruit(name, type, numItems, weight);
		if (lastUsedSpot + 1 == capacity) {
			System.out.println("Cannot add fruit, cart is full.");
			return false;
		}
		for (int i = 0; i < lastUsedSpot + 1; i++) {
			if (!temporary.isCompatibleWith(this.cart[i])) {
				System.out.println("Cannot add fruit, incompatible with other fruits.");
				return false;
			}
		}
		//if you get here then you can add fruit to cart
		lastUsedSpot++;
		this.cart[lastUsedSpot] = new Fruit(name, type, numItems, weight);
		return true;
	}
	
	//returns fruit based on position of fruit asked for
	public Fruit getFruit(int position) {
		if (this.cart[position] == null)
			return null;
		else
			return this.cart[position];
	}
	
	//turns the shopping cart into a string based on all information
	public String toString() {
		String p;
		if (this.priority == true)
			p = "yes";
		else
			p = "no";
		String s = "----Shopping Cart----\nPriority: " + p + 
				"\nSpots: 0 to " + (this.capacity - 1) + ", occupied to spot " + 
				this.lastUsedSpot + "\nFruits:\n";
		for (int i = 0; i < this.lastUsedSpot + 1; i++) {
			s += cart[i].toString() + "\n";
		}
		s += "----------------------";
		return s;
	}
	
	//calculates total price of the order. if it is priority, add 9 dollars to the order.
	public double orderTotal() {
		double order = 0;
		
		for (int i = 0; i < this.lastUsedSpot + 1; i++)
			order += this.cart[i].calculatePrice();
		
		if (this.priority)
			order += 9;
		return order;
	}
	
	public static void main (String[] args) {
		ShoppingCart myOrder = new ShoppingCart(3, true);
		System.out.println(myOrder);
		System.out.println("Shopping Cart is full: " + myOrder.toCapacity());
		System.out.printf("Current Order total: $%.2f\n\n",myOrder.orderTotal());
		myOrder.addFruit("Orange", Fruit.CANNED, 5, 7);
		myOrder.addFruit("Grapes", Fruit.FRESH, 2, 20);
		System.out.println(myOrder);
		System.out.println("Shopping Cart is full: " + myOrder.toCapacity());
		System.out.printf("Current Order total: $%.2f\n\n",myOrder.orderTotal());
		myOrder.addFruit("Banana", Fruit.DRIED, 1, 6);
		System.out.println(myOrder);
		System.out.println("Shopping Cart is full: " + myOrder.toCapacity());
		System.out.printf("Current Order total: $%.2f\n\n",myOrder.orderTotal());
		myOrder.addFruit("Pears", Fruit.CANNED, 3, 14);
		myOrder.addFruit("Peaches", Fruit.CANNED, 2, 12);
		System.out.println(myOrder);
		System.out.println("Shopping Cart is full: " + myOrder.toCapacity());
		System.out.printf("Current Order total: $%.2f\n", myOrder.orderTotal());
		
	}
}
