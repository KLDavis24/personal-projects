import java.util.*;

public class stacks {
	
	public static void main(String[] args) {
		
		// Create a new stack and populate it with 'bottom'
		Stack<String> stack = new Stack<String>();
		stack.push("bottom");
		printStack(stack);
		
		// Push the item 'second' into the stack
		stack.push("second");
		printStack(stack);
		
		// Push the item 'third' into the stack
		stack.push("third");
		printStack(stack);
		
		// Pop the top item off of the stack (third)
		stack.pop();
		printStack(stack);
		
		// Pop the top item off of the stack (second)
		stack.pop();
		printStack(stack);
		
		// Pop the top item off of the stack (bottom)
		stack.pop();
		printStack(stack);
		
	}
	
	private static void printStack(Stack<String> stack) {
		
		if (stack.isEmpty()) {
			System.out.println("You have nothing in your stack");
		}
		else {
			System.out.printf("%s TOP\n", stack);
		}
		
	}

}
