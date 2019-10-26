
public class UseTime {

	public static void main(String[] args) {
		Time timeOne = new Time();
		Time timeTwo = new Time(10, 40);
		
		System.out.println(timeOne.toString());
		System.out.println(timeTwo.toString());
		
		if(timeOne.isBefore(timeTwo))
			System.out.println(timeOne.toString());
		else
			System.out.println(timeTwo.toString());

	}

}
