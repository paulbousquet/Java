
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author YOUR NAME HERE
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myHash = start;
		for (int k=0;k<myWords.length;k++){
			myWords[k] = source[start+k];
		}
		myToString = String.join(" ",myWords);
		// TODO: initialize all instance variable
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		if (wg.length()!=this.myWords.length){
			return false;
		}
		else {
			if (wg.myToString.equals(this.myToString)){
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public int hashCode(){
		myHash = 17;
		for (int i = 0; i < myToString.length(); i++) {
			myHash = myHash*31 + myToString.charAt(i);
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		String[] looper = new String[myWords.length];
		for (int k=0;k<myWords.length-1;k++){
			looper[k] = myWords[k+1];
		}
		looper[myWords.length-1] = last;
		WordGram wg = new WordGram(looper,0,myWords.length);
		return wg;
	}

	@Override
	public String toString(){
		return myToString;
	}
}
