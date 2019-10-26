import java.util.ArrayList;
import java.util.Scanner;
public class GPS {
	

	public static void main(String[] args) {
		ArrayList<Waypoint> coordinates = new ArrayList<Waypoint>();
		Scanner kb = new Scanner(System.in);
		double destX = 0, destY = 0, totalDistance = 0, distancePerPoint = 0.0, averageSpeed, speedSum = 0; 
		int destT = 0;
		
		//add starting point of 0, 0, 0
		coordinates.add(new Waypoint());
		System.out.println("Welcome to the Yellowstone trail! You are currently located: " + coordinates.get(0).toString());
			
		do {
			System.out.println("Where would you like to travel on X axis?");
			destX = kb.nextDouble();
			if (destX < 0) break;
			System.out.println("Where would you like to travel on Y axis?");
			destY = kb.nextDouble();
			System.out.println("What time would you like to set up camp?");
			destT = kb.nextInt();
			coordinates.add(new Waypoint(destX, destY, destT));
		}while(destX > 0);
		
		for(int i = 1; i < coordinates.size(); i++) {
			
			distancePerPoint = (Math.hypot(coordinates.get(i).getX() - coordinates.get(i - 1).getX(), 
					coordinates.get(i).getY() - coordinates.get(i - 1).getY()) / 10);
			
			totalDistance += distancePerPoint;
			
			speedSum += (distancePerPoint * 3600) / ((coordinates.get(i).getT() - coordinates.get(i-1).getT()));
		}
		averageSpeed = speedSum / (coordinates.size() - 1);
		
		System.out.printf("Traveled a total of %.2f miles at an average speed of %.2f miles per hour"
					, (totalDistance), (averageSpeed));
	}
	static private class Waypoint {
		private double X, Y;
		private int T;

		public Waypoint() {
			X = 0;
			Y = 0;
			T = 0;
		}
		public Waypoint(double X, double Y, int T) {
			this.X = X;
			this.Y = Y;
			if (T > 0)
				this.T = T;
		}
		public double getX(){
			return this.X;
		}
		public double getY(){
			return this.Y;
		}
		public int getT(){
			return this.T;
		}
		public String toString() {
			String s = "X: " + this.getX() + " Y: " + this.getY() + " T: " + this.getT();
			return s;
		}
	}

}