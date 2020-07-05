
public class ArrayQueue {
	private int front;
	private int rear;
	private int count;
	private int size;
	private int increment;
	private Object[] itemQueue;
	private Object itemEmpty = "empty";
	
	public ArrayQueue() {
		front = 0;
		rear = 0;
		count = 0;
		size = 50;
		increment = 10;
		itemQueue = new Object[size];
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public void insert(Object x) {
		if(count == size) {
			int oldsize = size;
			size += increment;
			Object[] tempArray = new Object[size];
			for(int i = 0; i < count; i++, front = (front + 1) % oldsize)
				tempArray[i] = itemQueue[front];
			itemQueue = tempArray;
			front = 0;
			rear = count;
		}
		itemQueue[rear] = x;
		rear = (rear + 1) % size;
		count++;
	}
	
	public Object delete() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return itemEmpty;
		}
		Object tempItem = itemQueue[front];
		front = (front + 1) % size;
		count--;
		return tempItem;
	}
	
	public Object Peek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return itemEmpty;
		}
		else
			return itemQueue[front];
	}
   
	public void Print() {
		for(int i = front; i < rear; i++) 
			System.out.print(itemQueue[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayQueue aq = new ArrayQueue();
		Object temp;
		aq.insert("lee");
		aq.insert("yu");
		aq.insert("hwan");
		System.out.println("String insert() 연산 3회 수행 후 프린트---");
		aq.Print();
		aq.insert(1996);
		aq.insert(8);
		aq.insert(5);
		System.out.println("Integer insert() 연산 3회 수행 후 프린트---");
		aq.Print();
		temp = aq.delete();
		System.out.println("delete() 연산 1회 수행 후 프린트--- 삭제된 value : " + temp);
		aq.Print();
		System.out.println("Peek() 연산 수행(현재 front 값) : " + aq.Peek());

	}
}
