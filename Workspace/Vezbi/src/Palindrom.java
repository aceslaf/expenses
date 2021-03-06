import java.util.Collections;
import java.util.List;


public class Palindrom {

	public static boolean IsPalindrome(String str)
	{
		str=formatString(str);
		if(str.length()==1)
		{
			return true;
		}
		
		if(str.length()==2)
		{
			return str.charAt(0)==str.charAt(1);
		}
		
		boolean hasOddNumberOfChars=(str.length()%2)!=0;
		int midleIndex=str.length()/2;
		int firstHalfEndIndex=midleIndex;
		int secondHalfBeginIndex=hasOddNumberOfChars?midleIndex+1:midleIndex;
		String firstHalf=str.substring(0,firstHalfEndIndex);
		String secondHalf=str.substring(secondHalfBeginIndex);
		List<Character> firstList=Anagram.stringToCharList(firstHalf);
		List<Character> secondList=Anagram.stringToCharList(secondHalf);
		Collections.reverse(secondList);
		
		
		return firstList.equals(secondList);
	}
	public static String formatString(String str)
	{
		return str.trim();
	}
}

