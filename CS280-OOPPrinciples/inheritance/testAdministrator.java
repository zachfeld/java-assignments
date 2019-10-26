
public class testAdministrator {

	public static void main(String[] args) {
		//test zero arg constructor
		Administrator zach = new Administrator();
		System.out.println(zach + "\n");
		
		//test 3 arg constructor
		Administrator tiger = new Administrator("manager", "manage", "zach");
		System.out.println(tiger + "\n");
		
		//test 6 arg constructor
		Date d = new Date(1, 22, 2019);
		Administrator james = new Administrator("James", d, 15000, "CEO", "run things", "board");
		
		//test copy constructor
		Administrator clone = new Administrator(james);
		
		//test mutators
		tiger.setSupervisor("james");
		tiger.setResponsibility("work");
		
		//test accessors
		System.out.println(james.getResponsibility());
		System.out.println(james.getSupervisor());
		
		//test equals
		System.out.println(james.equals(clone));
		System.out.println(james.equals(tiger));
		
		//test toString
		System.out.println(james + "\n");
		
		//test scan of information using Scanner class
		zach.scanInfo();
		System.out.println(zach);
		
		//test accessors

	}

}
