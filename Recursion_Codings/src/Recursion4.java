
public class Recursion4 {
	//abcd;
    public static void reverse(String str,int lIndx) {
    	
    	if(lIndx==0) {
    		
    		System.out.println(str.charAt(lIndx));
    		return;
    	}
    	
    	System.out.print(str.charAt(lIndx));
    	reverse(str, lIndx-1);
    	
    }
	public static void main(String[] args) {
		String str="abcd";
		reverse(str, str.length()-1);
		
	}
	
}
