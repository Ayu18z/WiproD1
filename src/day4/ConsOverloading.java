package day4;


//
//Write a class VolumeCalculator that calculates the volume of different 3D shapes. The class should have the following methods:
//Calculate the volume of a cube (side length).
//Calculate the volume of a sphere (radius).
//Calculate the volume of a cylinder (radius and height).


public class ConsOverloading {
	
	
	static class shape{
		int length;
		int breadth;
		int base;
		int height;
		
		shape(int length){
			System.out.println("area = " + length*length);
			
		}
		
		shape(int length, int breath){
			System.out.println("area = "+ length*breath);
		}
	}
	
	
	public static void main(String[] args) {
		shape rect = new shape(5, 32);
		
		shape sq = new shape(4);
		
	}

}
