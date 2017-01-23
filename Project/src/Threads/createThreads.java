package Threads;

public class createThreads {
	
	public static void main(String[] args) {
		
		// Create new thread objects with their name arguments
		Thread thread1 = new Thread(new threads("one"));
		Thread thread2 = new Thread(new threads("two"));
		Thread thread3 = new Thread(new threads("three"));
		Thread thread4 = new Thread(new threads("four"));
		
		// Starting the threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}

}
