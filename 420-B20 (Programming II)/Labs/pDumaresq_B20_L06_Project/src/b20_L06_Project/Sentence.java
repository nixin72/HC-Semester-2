package b20_L06_Project;

public class Sentence {
	private String inString;
	private static char VOWEL[] = { 'a', 'e', 'i', 'o', 'u' };
	private int countVowel[];
		
	public Sentence() {
		countVowel = new int[VOWEL.length];
		for (int i = 0 ; i < countVowel.length ; i++) {
			countVowel[i] = 0;
		}
		inString = "";
	} // Sentence()

	public Sentence(String in) {
		countVowel = new int[VOWEL.length];
		for (int i = 0 ; i < countVowel.length ; i++) {
			countVowel[i] = 0;
		}
		inString = in;
	} // Sentence(String)

	private void countVowels() {
		for (int k = 0 ; k < VOWEL.length ; k++) {
			 System.out.println("There are " + VOWEL[k] 
					 + "'s in the sentence.");
		}
	} // countVowels()

	public void displayVowelCounts() {
		countVowels();
		System.out.println("There are " + inString.length() + " characters in the sentence.");

		 for (int k = 0; k < VOWEL.length; ++k)
			 if (countVowel[k]==1)
				 System.out.println("There is " + countVowel[k] + " " + VOWEL[k]
						 + " in the sentence.");
			 else
				 System.out.println("There are " + countVowel[k] + " " + VOWEL[k]
						 + "\'s in the sentence.");

	} // displayVowelCounts()

	/**
	 * Reverse the order of the words in the sentence and put a period at the
	 * end. For example, if the sentence is "Today is Monday.", then
	 * "Monday is today." will be returned.
	 * 
	 * @return the sentence in reverse
	 */
	public String reverse() {
		return null;
	} // reverse()
} // Sentence class