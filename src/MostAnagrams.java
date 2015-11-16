import java.util.Scanner;
import java.io.*;

public class MostAnagrams {
	public static void main(String[] args) throws FileNotFoundException
	{
		String input = "src/words.txt";
		File file = new File(input);
		Scanner inFile = new Scanner(file);
		Elist <String> words = new Elist <String>();
		
		while(inFile.hasNext())
		{
			String x = inFile.next();	
			words.addToEnd(x);
		}
		Elist <String> mostAnagrams = new Elist <String> ();
		String mostAnagramsWord = null;
		for(int i = 0; i < words.size(); i++)
		{
			Elist <String> tempList = anagrams(words.get(i), words);
			if(mostAnagrams.size() < tempList.size())
			{
				mostAnagrams = tempList;
				mostAnagramsWord = words.get(i);
				System.out.println(i + " " + mostAnagramsWord + " " + mostAnagrams.size());
			}
			if(i % 10000 == 0)
				System.out.println("Processed " + (i + 1) + " words");
		}
		System.out.println("The word with most anagrams in English dictionary is: " + mostAnagramsWord);
		
		inFile.close();
		
	}
	
	public static Elist<String> anagrams(String letters, Elist<String> words)
	{
		
		int letterReplaced;
		Elist <String> letterThere = new Elist <String> ();
		for (int i = 0; i < words.size(); i++)//go through the whole dictionary
		{
			String checkLetters = letters; //assign letters to check letters to point to the
			String word = words.get(i);
			letterReplaced = 0;
			if(word.length() != letters.length())
				continue;
			for(int j = 0; j < word.length(); j++) 
			{
				for(int k = 0; k < checkLetters.length(); k++)
				{
					if(word.charAt(j) == checkLetters.charAt(k))
					{
						checkLetters = checkLetters.replaceFirst(checkLetters.charAt(k) + "", " ");
						letterReplaced++;
						break;
					}
					
				}
				if (letterReplaced == letters.length())
				{
					letterThere.addToEnd(word);
					//System.out.println(word +" " + letterReplaced);
					break;
				}
				
			}
		}
		return letterThere;
	}
}
			
	
