package interfaces;

import java.util.concurrent.Semaphore;

public class child implements duplicate, SealedClass {

	Semaphore s;

	@Override
	public void fn() {

		System.out.println("1and2");
	}

	public static void main(String[] args) {

		child c = new child();
		c.fn();
	}

}
