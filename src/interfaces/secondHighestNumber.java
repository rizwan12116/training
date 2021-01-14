package interfaces;

public class secondHighestNumber {

	public static void main(String[] args) {
		int[] numarray = { 2, 10, 13, 15, 19,4, 5, 7, 15, 19,1, 2, 10, 11, 13 };
		int len = numarray.length;

		int temp;
		try {
			

			for (int i = 0; i < len; i++) {

				for (int j = 0; j < len-1; j++) {

					if (numarray[j+1] > numarray[j]) {
						temp = numarray[j+1];
						numarray[j+1] = numarray[j];
						numarray[j] = temp;
					}
				}
			}

			
			
			System.out.println(numarray[0] + " first highest");
			
			for (int i = 1; i < len; i++) {
				if(numarray[i-1] !=  numarray[i])
				{
					System.out.println(numarray[i] + " second highest");
					break;
				}
			}
			
			
			
			
			System.out.println(numarray[len-1] + " smallest");
		} catch (Exception ex) {
			System.out.println();
		}

	}

}
