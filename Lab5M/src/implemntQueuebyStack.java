import java.util.Stack;

import javax.management.RuntimeErrorException;

public class implemntQueuebyStack {

	public static void main(String[] args) {

	}

}

class SQueue<AnyType> {
	
	public static final int DEF_MAX_QUEUE_SIZE = 10;// Default maximum queue size
	Stack<AnyType> s1;
	Stack<AnyType> s2;
	int maxSize;
	
	
	public SQueue ( ){
		this (DEF_MAX_QUEUE_SIZE);
	}
	
	public SQueue ( int size ){
		
		this.maxSize = size;
		s1 = new Stack<>();
		s2 = new Stack<>();
	} 

	// Enqueue element at rear
	public void enqueue ( AnyType newElement ) {
		
		if (newElement == null) throw new RuntimeException("new element is null");
		if (isFull()) throw new RuntimeException("the queue is full");
		
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}	
		s1.push(newElement);		
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	// Dequeue element from front
	public AnyType dequeue () {
		
		if (isEmpty()) throw new RuntimeException("the queue is empty");
		return s1.pop();
		
	}
	
	// Remove all elements from queue
	public void clear ( ) {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}
	
	//Is Queue empty?
	public boolean isEmpty ( ) {
		return s1.isEmpty();
	}
	//Is Queue full?
	public boolean isFull ( ) {
		return s1.size() >= maxSize;		
	}

}
