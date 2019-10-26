package shell;
/*
 * X.Page, FAll 2018 solutions
 * This is the Fruit class that is described in assignment 6
 * Use it as starter code for assignment 7 (or use your own code if you are confident it 
 * meets the requirements EXACTLY).
 */

public class Fruit {

	// ONLY THESE INSTANCE VARIABLES SHOULD BE IN CLASS FRUIT
	private String name;
	private int type;
	private int numItems;
	private int itemWeight;
	
	// ONLY THESE STATIC VARIABLES SHOULD BE IN CLAsS FRUIT
	public static final int FRESH = 1;
	public static final int FROZEN = 2;
	public static final int CANNED = 3;
	public static final int DRIED = 4;
	
	//zero argument constructor method that does nothing
	public Fruit() {}
	
	/*four argument constructor that accepts four values for a fruit then
	 * calls the setters to assign the passed values
	 */
	public Fruit(String name, int type, int numItems, int itemWeight) {
		this.setName(name);
		this.setType(type);
		this.setNumItems(numItems);
		this.setWeight(itemWeight);
	}
	
	/* Mutator method: Sets name of the fruit
	 * input: String that is the name 
	 * assumptions: name is greater than length 0 otherwise this method does nothing
	 * output: will set the name of the fruit to the one passed in. returns nothing
	 */
	public void setName(String newName) {
		if(newName.length() > 0)
			name = newName.toUpperCase();
		else
			System.out.println("Invalid name.");
	}
	
	/* Mutator method: Sets type of the fruit
	 * input: int that is the type 
	 * assumptions: type is 1,2,3,or 4. Otherwise it is set to 1
	 * output: will set the type to the one passed in (see assumptions). returns nothing
	 */
	public void setType(int newType) {
		if (newType > 0 && newType < 5) 
			type = newType;
		else {
			System.out.println("Invalid type, setting to type \"Fresh\"");
			type = FRESH; 
		}
	}
	
	/* Mutator method: Sets weight of the fruit
	 * input: int that is the weight of a single item in ounces 
	 * assumptions: weight is a positive number, otherwise does nothing
	 * output: will set itemWeight to the one passed in (see assumptions). returns nothing
	 */
	public void setWeight(int newWeight) {
		if (newWeight > 0) 
			itemWeight = newWeight;
		else
			System.out.println("Invalid weight.");
	}
	
	/* Mutator method: Sets numItems of the fruit
	 * input: int that is the number of items of this fruit that will be ordered
	 * assumptions: items is a positive number, otherwise does nothing
	 * output: will set numItems to the one passed in (see assumptions). returns nothing
	 */
	public void setNumItems(int items) {
		if (items > 0) 
			numItems = items;
		else
			System.out.println("Invalid number of items.");
	}
	
	/* Accessor methods: returns the value requested (method named accordingly)
	 * input: none
	 * output: returns the instance variable value requested
	 */
	public String getName () {
		return name;
	}
	
	public int getType () {
		return type;
	}
	
	public int getNumItems () {
		return numItems;
	}
	
	public int getItemWeight () {
		return itemWeight;
	}
	
	/* isPerishable(): returns whether this fruit is perishable and thus needs to be delivered quickly
	 * input: none
	 * output: if fruit is fresh or frozen, returns true. otherwise, returns false
	 */
	public boolean isPerishable() {
		if(type == FRESH || type == FROZEN)
			return true;
		else 
			return false;
	}
	
	/* calculatePrice(): returns the price of this fruit
	 * input: none
	 * Logic: All fresh fruit is $1.98 a pound, Frozen fruit is half the price of fresh, 
	 * Canned fruit is a third the price of fresh fruit, and dried fruit is twice the price of fresh. 
	 * Converts weight from ounces to pounds (16 ounces equals 1 pound), then multiplies by price 
	 * per pound of that type of fruit.
	 * output: price of fruit. If type is invalid, returns zero.  
	 */
	public double calculatePrice() {
		double pricePerLb = 1.98;
		
		switch (type) {
		case FRESH:
			break;
		case FROZEN: 
			pricePerLb /= 2; 
			break;
		case CANNED:
			pricePerLb /= 3;
			break;
		case DRIED: 
			pricePerLb *= 2;
			break;
		default: 
			pricePerLb = 0;	
			System.out.println("Invalid type, cannot calculate price.");
		}
		
		double price = pricePerLb * (numItems * itemWeight) / 16.0;
		
		return price;
	}
	
	/* isCompatibleWith(): checks if fruits are compatible to be delivered in the same type of truck
	 * input: object of type Fruit to compare with
	 * Logic: There are two criteria for being compatible: 
	 * First, frozen foods must be delivered in a freezer truck and the other types must use a regular truck (non freezer). 
	 * Secondly, perishable fruits must be delivered quickly (see previous definition of isPerishable) and 
	 * so cannot be placed in the same truck as non perishable fruits.
	 * output: if calling object is compatible with Fruit object argument, returns true. otherwise, returns false
	 */
	public boolean isCompatibleWith(Fruit other) {
		if (!this.isPerishable() && !other.isPerishable())	// both are non perishable
			return true;
		if (this.isPerishable() != other.isPerishable())	// one is perishable, the other is not
			return false;
		if (this.getType() == other.getType())	// if you've gotten here, both are perishable
			return true;
		return false;	
	}
	
	//Method returns a string based on the type of the fruit
	public String getTypeString() {
		switch(this.getType()) {
			case FRESH:
				return "fresh";
			case FROZEN:
				return "frozen";
			case CANNED:
				return "canned";
			case DRIED:
				return "dried";
			default:
				return "no type found";
		}
	}
	
	//method returns a string with information about the fruit
	public String toString() {
		String fruitInfo;
		fruitInfo = this.getName() + " (" + this.getTypeString() + ") " + this.getItemWeight() + " ounces each: Ordering " + this.getNumItems();
		return fruitInfo;
	}
	
	
	
	/*
	 * This main method will test all of the methods in this class.
	 * You could have done it differently - as long as you test all of your methods.
	 */
	public static void main(String[] args) {
		
		Fruit f3 = new Fruit("mango", 2, 3, 10);
		Fruit f4 = new Fruit("orange", 3, 4, 5);
		
		System.out.println(f3.getTypeString());
		System.out.println(f4.toString());
		

	}

}
