import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Anagram {

	public static boolean isAnagram(String str1,String str2)
	{
		str1=formatString(str1);
		str2=formatString(str2);
		if(str1.length()!=str2.length())
		{
			return false;
		}
		List<Character> lst1,lst2;
		lst1=stringToCharList(str1);
		lst2=stringToCharList(str2);
		Collections.sort(lst1);
		Collections.sort(lst2);
		
		return lst1.equals(lst2);
	}

	public  static List<Character> stringToCharList(String str1) {
		 List<Character> lst1=new ArrayList<Character>();
		for (Character character : str1.toCharArray()) {
			lst1.add(character);
		}
		return lst1;
	}
	
	public static String formatString(String str)
	{
		return str.trim().toLowerCase();
	}
	
	
}
