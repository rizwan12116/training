package interfaces;


public class mainClass {

	public static void main(String[] args) {
		
		class1Thread c1 = new class1Thread();
		Class2Thread c2 = new Class2Thread();

		c1.start();
		try{Thread.sleep(5);}catch(Exception ex){}
		c2.start();
		
	}

}
