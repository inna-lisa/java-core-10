import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserTest {
	public static void main(String[] args) {
		List<User> userList = new ArrayList<>();

		try (BufferedReader file = new BufferedReader(new FileReader("src/main/resources/users.txt"))){
			String string;
			String[] usersParameters = new String[2];

			file.readLine();
			string = file.readLine();

			while (string != null){
				usersParameters = string.split(" ");
				User user = new User(usersParameters[0], Integer.parseInt(usersParameters[1]));
				userList.add(user);
				string = file.readLine();
			}
		}
		catch (IOException ex){
			System.out.println(ex.getMessage());
		}

		File file = new File("src/main/resources/json.txt");
		Gson json = new GsonBuilder().setPrettyPrinting().create();

		try (Writer writer = new FileWriter(file)){
			writer.write(json.toJson(userList));
			writer.flush();
		}
		catch (IOException ex){
			System.out.println( ex.getMessage());
		}
	}
}
