
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.*;
import static java.util.function.Function.identity;


public class FrequentWords {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter filename: ");
		String filename = in.next();
		if (args.length == 1) {
			filename = args[0];
		}
		try {
			List<String> incoming = Utilities.readAFile(filename.trim());
			
			// TODO replace the following loop with a single statement using streams
			Map<String, Long> wordFrequency = incoming.stream()
					.filter(w -> !"".equals(w.trim()))
					.map(w -> w.toLowerCase())
					.collect(groupingBy(identity(), counting()));
			

			// TODO add a single statement that uses streams to determine maxCnt
			int maxCnt = incoming.stream()
					.filter(w -> wordFrequency.get(w) != null)
					.mapToInt(w -> wordFrequency.get(w).intValue())
					.max()
					.getAsInt();
			

			System.out.print("Words that appear " + maxCnt + " times: ");
			
//			// TODO replace the following loop with a single statement using streams
//			// that prints the most frequent words in the document
			wordFrequency.keySet().stream()
			.filter(w -> wordFrequency.get(w) == maxCnt)
			.forEach(w -> System.out.print(w + " "));
		} catch (FileNotFoundException e){
			System.out.println("Incorrect file name: " + filename);
			e.printStackTrace();
		} finally {
			in.close();
		}
		
		
		


	}

}
