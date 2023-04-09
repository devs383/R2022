
public class Recursion5 {
   //0,1,1,2,3,5,8,13
	
	public static void fibonacci(int l,int c,int n) {
		
	  if (n==0) {
		
		  return;
	  }
	
	  int sum=l+c;
	  System.out.print(sum);
	  fibonacci(c, sum, n-1);
	  
	}
	
	public static void main(String[] args) {

		System.out.print(0);
		System.out.print(1);
		
		fibonacci(0, 1, 6);

	}

}
