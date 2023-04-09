import java.util.Iterator;

public class MyArrays {

	
	public static void main(String[] args) {
		
		int [] a= {3,4,1};
		int [] b= {7,3,9};
		int k;
		
		int [] c = new int[a.length+b.length];
		
		for (int i = 0; i < c.length; i++) {
			
			if (a[i]<b[i] )
			{
			k =	a[i];
			a[i]=b[i];
			b[i]=k;
			
			
			
			
		     }
			
		}
		
		
	}
	
	
}
