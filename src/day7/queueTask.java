package day7;

import java.util.LinkedList;
import java.util.Queue;

//Given a string, find the first non - repeating character using a Set.
//Input:
//" swiss "
//Output :
//"w"

//
//Create a queue of integers. Perform the following operations:
//Add 3 elements (10, 20, 30)
//Remove one element
//Print the front element
//- Print the entire queue
public class queueTask {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(10);
		q.add(20);
		q.add(30);
		
		int removed = q.poll();
		
		
		System.out.println(q.peek());
		System.out.println(q);
		
	}

}
