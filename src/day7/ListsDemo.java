package day7;

import java.util.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListsDemo {
public static void main(String[] args) {
	List<Integer> ls = new ArrayList<>();
	ls.add(10);
	ls.add(20);
	ls.add(30);
	ls.add(20);
	ls.add(10);
	ls.add(20);
	ls.add(10);
	ls.add(40);

	
	List<Integer> result = new ArrayList<>();
	
	for(int i : ls) {
		if(!result.contains(i)) {
			result.add(i);
		}
	}
	
	System.out.println(ls.toString());
	System.out.println(result.toString());
	
	
}
}
