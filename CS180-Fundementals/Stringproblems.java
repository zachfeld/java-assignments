
public class Stringproblems {

	public static void main(String[] args) {
		String phoneNumber = "7813456789";
		String name = "Charlie Brown";
		String evenLength = "boxcar";
		String parenthesis = "\"There was snow ( a lot of it! ) last week\"";
		String change = "DO NOT LITTER";
		
		
		System.out.println(phoneNumber.substring(0,3) + "-" + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10));
		System.out.println(name.charAt(0) + "." + name.charAt(name.indexOf(" ") + 1) + ".");
		System.out.println(evenLength.substring(0, evenLength.length()/2) + " " + evenLength.substring(evenLength.length()/2));
		parenthesis = parenthesis.substring(parenthesis.indexOf("(") + 1, parenthesis.indexOf(")"));
		System.out.println(parenthesis.trim());
		
		
		String probFive = "HEllo World!";
		System.out.println(probFive.replaceAll("[aeiouAEIOU]", "_"));

		System.out.println(change.substring(0, change.indexOf(" ")).toLowerCase()+ 
				change.substring(change.indexOf(" ")));
		
		System.out.println(change.substring(0, change.lastIndexOf(" ")) + 
				change.substring(change.lastIndexOf(" ")).toLowerCase());
		
		System.out.println(change.substring(0, change.indexOf(" ", change.indexOf(" ") + 1)  ).toLowerCase() + 
				change.substring(change.indexOf(" ", change.indexOf(" ") + 1)));
		
						

	}

}
