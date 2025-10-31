package Day5;

public class SingleInheriance {
	
	
	static class car{
		
		void wheels() {
			System.out.println("car has 4 wheels ++++++++Parent");
			
		}
	}
	
	static class mahindra extends car{
		void suv() {
			System.out.println("mahindra are all suv ------------MAHINDRA");
		}
	}
	
	static class vw extends car{
		void sedans(){
			System.out.println("vw are all sedans ------------ VW");
		}
	}
	
	static class hundaii extends vw{
		void all(){
			System.out.println("it has both sedans and suv --------- HUNDAI");
		}
	}

	
	public static void main(String[] args) {
		vw car1 = new vw();
		car1.sedans();

		hundaii car2= new hundaii();
		car2.all();
		
	}
}
