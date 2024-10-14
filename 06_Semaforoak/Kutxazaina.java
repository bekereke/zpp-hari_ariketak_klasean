package unieibar;

import java.util.concurrent.Semaphore;

public class Kutxazaina {

	// Gehienez Pertsona Bat
	static Semaphore semaphore = new Semaphore(1); //permits 1 MUTEX

	static class NireKutxazainHaria extends Thread {
		// Izena
		private String name = "";
		
		// Sortzailea
		NireKutxazainHaria(String name) {
			this.name = name;
		}

		public void run() {
			try {
				System.out.println(name + " : baimena lortu nahian...");
				System.out.println(name + " : eskuragarri dauden Semaforoak orain bertan: " + semaphore.availablePermits());
				semaphore.acquire();
				System.out.println(name + " : lortu dut baimena!");
				try {
					for (int i = 1; i <= 10; i++) {
						System.out.println(name + " : kutxazainean lanean " + i 
								+ ", eskuragarri dauden Semaforoak : "
								+ semaphore.availablePermits());
						
						// denbora tarte bera itxaron beharrean 1 eta 3 segundu artean itxaron dezatela auzazko funtzio matematiko baten bitartez 
						// Math.random() * (max - min) + min;
						long denbora = (long) ((Math.random() * (2000)) + 1000);
						Thread.sleep(denbora);
					}
				} 
				finally {
					// calling release() after a successful acquire()
					System.out.println(name + " : baimena askatzen...");
					semaphore.release();
					System.out.println(name + " : eskuragarri dauden Semaforoak orain bertan: " + semaphore.availablePermits());
				}
			} 
			catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}
		
	public static void main(String[] args) {
		System.out.println("Guztira eskuragarri dauden Semaforoak: " + semaphore.availablePermits());

		NireKutxazainHaria t1 = new NireKutxazainHaria("A");
		t1.start();

		NireKutxazainHaria t2 = new NireKutxazainHaria("B");
		t2.start();

		NireKutxazainHaria t3 = new NireKutxazainHaria("C");
		t3.start();

		NireKutxazainHaria t4 = new NireKutxazainHaria("D");
		t4.start();

		NireKutxazainHaria t5 = new NireKutxazainHaria("E");
		t5.start();

		NireKutxazainHaria t6 = new NireKutxazainHaria("F");
		t6.start();
		
		NireKutxazainHaria t7 = new NireKutxazainHaria("G");
		t7.start();

		NireKutxazainHaria t8 = new NireKutxazainHaria("H");
		t8.start();

		NireKutxazainHaria t9 = new NireKutxazainHaria("I");
		t9.start();

		NireKutxazainHaria t10 = new NireKutxazainHaria("J");
		t10.start();
	}

}
