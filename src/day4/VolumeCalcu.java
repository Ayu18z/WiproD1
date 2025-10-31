package day4;

public class VolumeCalcu {
	
	
	static class Volume{
		int sidelength;
		float radius;
		int height;
		
		
		
		Volume(int sidelength){
			this.sidelength = sidelength;
		}
		
		Volume(float radius){
			this.radius = radius;
		}
		
		Volume(float radius, int height){
			this.height = height;
			this.radius = radius;
		}
	}

}

//
//Write a class VolumeCalculator that calculates the volume of different 3D shapes. The class should have the following methods:
//Calculate the volume of a cube (side length).
//Calculate the volume of a sphere (radius).
//Calculate the volume of a cylinder (radius and height).

