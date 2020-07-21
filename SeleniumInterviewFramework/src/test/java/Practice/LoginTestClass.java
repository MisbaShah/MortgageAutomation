package Practice;

public class LoginTestClass {
	 public static void main(String[] args) {
		 int arr[] = {32,43,53,54,32,65,63,98,43,23};
		 int largestnum = arr[0] ;
		 int Smallestnum =arr[0];
		 
		 for (int i = 0 ;i <arr.length; i++) {
			 if (arr[i]> largestnum) {
				 largestnum = arr[i];
			 }else if ( Smallestnum >arr[i]){
				 Smallestnum = arr[i];
				 
				 
			 }
					 
				 
			 
		 }System.out.println("Largetst number in array is==>"	+  largestnum);
		 	
		 System.out.println("Smallestnum number in array is ==> "+Smallestnum);
	}

}
