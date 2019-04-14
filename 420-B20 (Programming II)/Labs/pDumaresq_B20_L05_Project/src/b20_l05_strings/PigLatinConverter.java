package b20_l05_strings;

/**
 * Uses string methods to convert a sentence to pig latin.
 * Algorithm:
 * Look at each word in the sentence. If its first letter is a vowel, simply
 * add "yay" to it. Otherwise, remove all the letters from the beginning of
 * the word, and up to the first vowel. Put them after the word. Then add "ay".
 */
public class PigLatinConverter
{
  public PigLatinConverter()
  {
  } // PigLatinConverter()

  /**
   * Breaks a sentence into separate words and converts each word to pig latin.
   * @param sentence - the sentence to be converted to pig latin
   * @return the sentence in pig latin
   */
  public static String toPigLatin(String sentence)
  {
    return sentence;
  } // toPigLatin(String)

  /**
   * Converts a single word into pig latin
   * @param word - a word to be converted into pig latin
   * @return the word translated into pig latin
   */
  private static String wordToPigLatin(String word)
  {
    return word;
  } // wordToPigLatin(String)

  /**
   * Determines whether or not a character is a vowel
   * @param c - the character to be tested
   * @return true if the character is a vowel and false if the character is not 
   * a vowel
   */
  private static boolean isVowel(char c)
  {
		char lowerCaseC = Character.toLowerCase(c);
		if (lowerCaseC == 'a' || lowerCaseC == 'e' || lowerCaseC == 'i' || lowerCaseC == 'o' || lowerCaseC == 'u' || lowerCaseC == 'y')
      return true;
    else
      return false;
  } // isVowel(char)
} // PigLatinConverter class
