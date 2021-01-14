package interfaces;

import java.util.concurrent.Semaphore;

public class thread extends Thread {

	private static SingletonDemo obj = null;
	private Semaphore sem;

	public void myThread(Semaphore sem) {
		this.sem = sem;
	}

	@Override
	public void run() {
		try {
			sem.acquire();

			if (obj == null) {
				synchronized (SingletonDemo.class) {
					if (obj == null) {
						//obj = new SingletonDemo();
					}
				}
			}
			sem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
