package day7;

import java.util.HashSet;
import java.util.Set;

public class SetsDemo {

	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet();
	//	Set<Integer> s2 = new LinkedHashSet();
//		Set<Integer> s3 = new TreeSet();
		
		s1.add(12);
		s1.add(24);
		s1.add(12);
		s1.add(null);
		s1.add(null);
		s1.add(34);
//		
//		s2.add(null);
//		s2.add(2);
//		s2.add(45);
//		s2.add(null);
		
		
		// System.out.println(s2.toString());
		
		System.out.println(s1.addAll(s1));
		System.out.println(s1.contains(24));

		System.out.println(s1.toString());
	}

}
