//1. Create a SmartDevice class that can both Camera and Phone features.
//Implement two interfaces Camera (with clickPhoto()) and Phone
//(with makeCa11()) and demonstrate a class Smartphone that combines both behaviors.



//2. Create a Person class with a name and displaylnfo() method. Create a Student class that extends Person, adds a rollNumber, and
//overrides displaylnfo(). Use super to call the parent class method inside the overridden method.

package Day5;

public class Smartph {

	interface Camera{
		default void CameraQual(){
			System.out.println("15mp camera");
		}
	}
		
	interface Android{
		 default void version() {
			System.out.println("runs in android 16");
		}
	}
		 
	interface battery{
		default void batterycapacity() {
			System.out.println("has 4000 MAH");
		}
	}
	
	
	static class Samsung implements Camera,Android,battery{
		void specification() {
			
			System.out.println("Smartphone specification-");
			CameraQual();
			version();
			batterycapacity();
		}
	}
	
	public static void main(String[] args) {
		Samsung S24 = new Samsung();
		S24.specification();
	}
	
}
