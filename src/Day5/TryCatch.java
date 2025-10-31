package Day5;

public class TryCatch {
	
	public static void main(String[] args) {
		
		
		int[] arr = {3,4,1,4};
		
		
		try {
			System.out.println(arr[5]);
			
		} catch (Exception e) {
			System.out.println("not available");
		}
		
		finally {
			System.out.println("Try finding the index between 0 and " +( arr.length - 1) + " only");
		}
	}

}
