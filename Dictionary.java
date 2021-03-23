
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/**
 * A simple dictionary of all known words to verify spelling.
 * 
 * <p>
 * Objects of this type read a file of words to seed the dictionary. The
 * dictionary file is a simple list of words, such as <i> jack <br>
 * sally <br>
 * sophie </i>
 * </p>
 * 
 * @author parks
 *
 */
public class Dictionary {

	/**
	 * Default file name for the default constructor
	 */
	public static final String FILE_NAME = "dictionary3000.txt"; // short dictionary
	// public static final String FILE_NAME = "wordsEn.txt"; // big dictionary

	private TreeSet<String> dict = new TreeSet<>();

	/**
	 * Constructor reads the dictionary words from the default dictionary file
	 * 
	 * @throws IOException
	 */
	public Dictionary() throws IOException {
		this(FILE_NAME);
	}

	/**
	 * Constructor reads a given dictionary file.
	 * 
	 * @param filename
	 *            dictionary file name
	 * 
	 * @throws IOException
	 */
	public Dictionary(String filename) throws IOException {
		File dFile = new File(filename);
		FileReader fr = new FileReader(dFile);
		new BufferedReader(fr).lines().forEach(e -> dict.add(e));
		fr.close();
	}

	/**
	 * Determine if a given word is in the dictionary
	 * 
	 * @param word
	 *            is checked to see if it is in the dictionary
	 * 
	 * @return true if the given word was found, false otherwise
	 */
	public boolean contains(String word) {
		return dict.contains(word);
	}

	/**
	 * Add a given word to the dictionary
	 * 
	 * @param word
	 *            is added to the dictionary
	 * 
	 * @return true if the dictionary is changed as a result of this method, false
	 *         otherwise
	 */
	public boolean add(String word) {
		return dict.add(word);
	}

}
