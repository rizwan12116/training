package interfaces;

public class palindrome {

	public static void main(String[] args){
		
		int num = 1221;
		int temp = num;
		
		int rev  =0;
		
		while(num != 0){
			
			int digit = num %10;
			rev= rev*10 + digit;
			num=num/10;
			
		}
		
		if(rev == temp){
			System.out.println("Given number is a Palindrome");
		}
		else{
			System.out.println("Given number is not a Palindrome");
		}
		
	}
	
}
