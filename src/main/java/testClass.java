import java.util.HashMap;

import com.github.javafaker.Faker;

public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Long> capitalCities = new HashMap<String, Long>();
		capitalCities.put("England", (long) 120);
		capitalCities.put("Germany", (long) 8932);
		//capitalCities.put("Norway", "Oslo");
		//capitalCities.put("USA", "Washington DC");
		//System.out.println(capitalCities);
		 Faker random = new Faker();
		 random.name().username();
		 
	
	}
	
	
	//long a = 24124124.22523523533;
}
