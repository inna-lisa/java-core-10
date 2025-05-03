import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordsTest {
	public static void main(String[] args) {
		String content = " ";
		try {
			Path file = Paths.get("src/main/resources/words.txt");
			content = Files.readString(file).replace("\n", " ");
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}

		String[] contentArray = content.split(" ");
		Map<String, Integer> contentMap = new HashMap<>();

		for (int i = 0; i < contentArray.length; i++) {
			if (!contentArray[i].isEmpty()) {
				if (contentMap.isEmpty()) {
					contentMap.put(contentArray[i], 1);
				} else {
					if (contentMap.containsKey(contentArray[i])) {
						contentMap.replace(contentArray[i], contentMap.get(contentArray[i]) + 1);
					} else {
						contentMap.put(contentArray[i], 1);
					}
				}
			}
		}
		System.out.println("contentMap = " + contentMap);
		WordsTest test = new WordsTest();
		test.sort(contentMap);

	}
	public void sort(Map map){
		List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
		Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (Map.Entry<String, Integer> stringIntegerEntry : sortedList) {
			System.out.println(stringIntegerEntry);
		}

	}
}
