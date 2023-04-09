
public class Recursion2 {
    
	public static int factorial(int n) {
		
		if (n==1||n==0) {
			
			return 1;
		}
		int factNm1= factorial(n-1);
		int factN=n*factNm1;
		
		return  factN;
	}
	
	
	
	public static void main(String[] args) {
		
		int factorial=factorial(5);
		System.out.println(factorial);
	}
	
}
