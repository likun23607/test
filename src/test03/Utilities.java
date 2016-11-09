package test03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utilities {
	
	static List<String> list=Arrays.asList("one Two three Four five six one".split(" "));
	
	public static void main(String[] args) {
		System.out.println(list);
		System.out.println(Collections.disjoint(list, Arrays.asList("FUCK A BUSSHIT".split(" "))));
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		System.out.println(Collections.min(list, String.CASE_INSENSITIVE_ORDER));


	}

}
