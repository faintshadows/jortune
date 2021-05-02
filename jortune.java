/** Reads in the % delimited fortune files
 *  and picks a random one, much like the
 *  actual fortune program.
 *  
 *  @author faintshadows
 *  @date 2021/4/9
 * 
 */

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class jortune {

	/**read in the File and spit out an ArrayList of Strings from the file
	 * 
	 * @param file 			the file being read
	 * @return	   			an ArrayList of Strings of every quote
	 * @throws IOException	in case the file is broke or something idk
	 */
	public static ArrayList<String> readFile(File file) throws IOException {
		//The ArrayList that will store all the quotes
		ArrayList<String> megaQuote = new ArrayList<String>();
		//Putting the scanner in a try block automatically closes it when finished
		try (Scanner in = new Scanner(file)){
			//fortune files use % on a newline as the delimiter
			in.useDelimiter("%\n");
			//run through the entire file, adding all text between "%\n"
			while(in.hasNext()) {
				megaQuote.add(in.next());
			}
		}
		return megaQuote;
	}
	
	/**Pick and return a random quote
	 * 
	 * @param quotes 		the ArrayList of quotes
	 * @return				the randomly selected quote
	 */
	public static String randQuote(ArrayList<String> quotes) {
		int index;
		index = (int) (Math.random() * quotes.size());
		return quotes.get(index);
	}
	
	public static void main(String[] args) throws IOException {		
		//use the first argument given to the program as the filename	
		File src = new File(args[0]);
		//create the list of quotes, read the file in
		ArrayList<String> quotes = readFile(src);
		//print out the selected quote
		System.out.println(randQuote(quotes));
	}

}
