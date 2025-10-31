package day7;
//printing common inputs
import java.util.HashSet;
import java.util.Set;

public class SetsP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> s1 = new HashSet();
		
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		
		Set<Integer> s2 = new HashSet();

		s2.add(3);
		s2.add(4);
		s2.add(5);
		s2.add(6);
		
		Set<Integer> common = new HashSet(s1);
		common.retainAll(s2);
		
		System.out.println(common);

	}

}
