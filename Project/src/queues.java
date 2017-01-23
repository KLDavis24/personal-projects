import java.util.*;

public class queues {
	
	public static void main(String[] args) {
		
		// Create a new queue and populate it with items in priority order
		PriorityQueue<String> queue = new PriorityQueue<String>();
		queue.offer("first");
		queue.offer("second");
		queue.offer("third");
		
		// Print out the queue
		System.out.printf("%s ", queue);
		System.out.println();
		
		// Print out the element in 'queue' with the highest priority
		System.out.printf("%s ", queue.peek());
		System.out.println();
		
		// Search through the queue, and remove the element with the highest priority
		queue.poll();
		System.out.printf("%s ", queue);	
	}

}
