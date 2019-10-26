import java.util.Scanner;

public class Administrator extends SalariedEmployee {
	// instance variables
	private String title;
	private String responsibility;
	private String supervisor;

	// zero argument constructor
	public Administrator() {
		super();
		title = "no title";
		responsibility = "no responsibility";
		supervisor = "no supervisor";
	}
	// three argument constructor
	public Administrator(String t, String r, String s) {
		super();
		title = t;
		responsibility = r;
		supervisor = s;
	}
	// six argument constructor
	public Administrator(String theName, Date theDate, double theSalary,
			String theTitle, String theResponsibility, String theSupervisor) {
		super(theName, theDate, theSalary);
		
		title = theTitle;
		responsibility = theResponsibility;
		supervisor = theSupervisor;
	}
	//copy constructor 
	public Administrator(Administrator OriginalObject) {
		super(OriginalObject);
		title = OriginalObject.title;
		responsibility = OriginalObject.responsibility;
		supervisor = OriginalObject.supervisor;
	}
	// mutator methods
	public void setTitle(String theTitle) {
		title = theTitle;
	}
	public void setResponsibility(String theResponsibility) {
		responsibility = theResponsibility;
	}
	public void setSupervisor(String theSupervisor) {
		supervisor = theSupervisor;
	}

	// accessor methods
	public String getTitle() {
		return title;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public String getSupervisor() {
		return supervisor;
	}

	// toString
	public String toString() {
		return super.toString() + "\nTitle: " + getTitle()
				+ "\nResponsibility: " + getResponsibility() + "\nSupervisor: "
				+ getSupervisor();
	}
	// proper equals method
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		else if (this.getClass() != otherObject.getClass())
			return false;
		else {
			Administrator otherAdministrator = (Administrator) otherObject;
			return (super.equals(otherAdministrator)
					&& (title == otherAdministrator.title)
					&& (responsibility == otherAdministrator.responsibility)
					&& (supervisor == otherAdministrator.supervisor));
		}
	}
	//Scans all info
	public void scanInfo() {
		Scanner kb = new Scanner(System.in);
		Date d = new Date();
		d.readInput();
		setHireDate(d);
		
		System.out.print("Please enter a name: ");
		setName(kb.nextLine());
		
		System.out.print("Please enter a Salary: ");
		setSalary(kb.nextInt());
		kb.nextLine();
		
		System.out.print("Please enter a Title: ");
		setTitle(kb.nextLine());
		
		System.out.print("Please enter a Responsibility: ");
		setResponsibility(kb.nextLine());
		
		System.out.print("Please enter a Supervisor: ");
		setSupervisor(kb.nextLine());
		
		kb.close();
	}
}
