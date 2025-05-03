import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberTest {
	public static void main(String[] args) {
		List <String> numbers;

		try (BufferedReader file = new BufferedReader (new FileReader("src/main/resources/numberPhone.txt"))){
			String line = file.readLine();
			numbers = new ArrayList<>();

			while (line != null){
				if(validNumber(line) != null){
					System.out.println(line);
				}
				numbers.add(line);
				line = file.readLine();
			}
			System.out.println("numbers = " + numbers);
		}
		catch (IOException ex){
			System.out.println( ex.getMessage());
		}
	}

	public static String validNumber(String number) {
		String regex = "((\\(\\d{3}\\)\\s?)|(\\d{3}-))\\d{3}-\\d{4}";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(number);

		if(matcher.find()) {
			return number;
		}
		return null;
	}
}
