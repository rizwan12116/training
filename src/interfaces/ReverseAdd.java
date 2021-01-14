package interfaces;

public class ReverseAdd {

	public static void main(String[] args){
		int num = 56783420;
		
		int rev = 0;
		
		int count =0;
		String numstring ="";
		
		while(num!= 0){
			
			int digit = num %10;
			numstring=numstring + String.valueOf(digit);
			
			rev =rev*10 + digit;
			num = num/10;
			
			if(num!=0){
				numstring=numstring + "+";
				
			}
			count=count+digit;
		}
		System.out.println(rev);
		System.out.println(numstring + " = " + count);
	}
	
}
