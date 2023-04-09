
public class MergeSortedTwoArrays {

	
	public static int[] mergeArrays(int[] arr1,int[] arr2) {
		
		
		int mergedLength=arr1.length+arr2.length;
		System.out.println(mergedLength);
		int[] mergedArr=new int[mergedLength];
		
		int i=0;
		int j=0;
		int k=0;
		
		while(k<mergedLength) {
			
			
			if(j>=arr2.length||(i<arr1.length&&arr1[i]<arr2[j])) {
				
				if(j<arr2.length && i<arr1.length) {				
					System.out.println(arr1[i] +" aaa "+arr2[j]);
                }
				mergedArr[k]=arr1[i];
				i++;
				k++;
			}else {
				if(i<arr1.length) {				
					System.out.println(arr1[i] +" bbb "+arr2[j]);
                }

				mergedArr[k]=arr2[j];
				j++;
				k++;
			}
			/*
			 * int[] arr1= {1,3,6,21}; int[] arr2= {4,7,9};
			 */
			
			
		}
		
		return mergedArr;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr1= {1,3,6,21};
		int[] arr2= {4,7,9,43};
		
		int[] merged=mergeArrays(arr1, arr2);
		
		for(Object a:merged) {
			
			System.out.print((int)a+" ");
		}
		
	}
}
