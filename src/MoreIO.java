package day8;

import java.io.File;
import java.io.IOException;


public class MoreIO {
	public static void main(String[] args) {
		try {
		File car = new File("car serviced");
		
		if(car.createNewFile()) {
			System.out.println("car came");
		}else {
			System.out.println("Yet to be done");
		}
	}catch (IOException e) {
		System.out.println("error occured")
		;
		e.printStackTrace();
	}
	}

}
