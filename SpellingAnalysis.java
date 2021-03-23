
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class SpellingAnalysis {

	public static void main(String[] args) throws IOException {
		Dictionary dict;
		WordFrequencyCounter spelledCorrectly = new WordFrequencyCounter();
		Set<String> misspelled = new TreeSet<>();
		String fileToRead = "BillOfRights.txt";
		if (args.length > 0)
			fileToRead = args[0];
		if (args.length == 2) {
			String dictFile = args[1];
			dict = new Dictionary(dictFile);
		} else {
			dict = new Dictionary();
		}

		List<String> incoming = Utilities.readAFile(fileToRead);

		// TODO replace the following loop with a single statement that uses streams
		incoming.stream()
		.filter(e -> !"".equals(e.toLowerCase().trim()))
		.forEach(e -> {
			if(dict.contains(e.toLowerCase())) {
				spelledCorrectly.add(e.toLowerCase());
			} else {
				misspelled.add(e);
			}
		});

		System.out.println("most frequent words ");
		int highestFreq = spelledCorrectly.highestFrequency();
		System.out.println(spelledCorrectly.findByFrequency(highestFreq));

		// TODO replace the following loop with a single statement that uses streams
				
				spelledCorrectly.values().stream()
				.filter(i -> !spelledCorrectly.findByFrequency(i).isEmpty())
				.sorted((x1, y1) -> y1.compareTo(x1))
				.distinct()
				.forEach(i -> System.out.println("\nfrequency " + i + "\n" + spelledCorrectly.findByFrequency(i)));
		

		System.out.println("\nmisspelled words");
		System.out.println(misspelled);
	}

}
