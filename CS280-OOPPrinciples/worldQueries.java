import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class worldQueries {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://frodo.bentley.edu:3306/world";
		String username = "CS280";
		String password = "CS280";
		String countryCode = "", countryPopulation = "";

		try { // load driver into VM memory
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load MySQL driver.");
			return;
		}

		// try with resources
		try (Connection con = DriverManager.getConnection(URL, username,
				password)) {
			Statement stmt = con.createStatement();
			ResultSet result = stmt
					.executeQuery("SELECT * FROM City WHERE Name=\"Nonsan\";");

			if (!result.isBeforeFirst()) { // returns false if there are no
										   // rows in the result set
				System.out.println("Result set did not return any rows");
				System.exit(0);
			} else {
				while (result.next()) {
					countryCode = result.getString("CountryCode");
					countryPopulation = result.getString("Population");
					System.out.println("Country Code: " + countryCode);
					System.out.println("Population: " + countryPopulation);
				}
			}
			result.close();

			ResultSet resultPstmt = null;
			PreparedStatement pstmt = con
					.prepareStatement("SELECT * FROM Country WHERE Code=?;");
			pstmt.setString(1, countryCode);
			resultPstmt = pstmt.executeQuery();

				while (resultPstmt.next()) {
					System.out.println(
							"Country Name: " + resultPstmt.getString("Name"));
					System.out.println(
							"Continent: " + resultPstmt.getString("Continent"));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
