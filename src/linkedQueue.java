class Node3{
	Object data;
	Node3 link;
}

class Queue{
	Node3 front, rear;
	private Object itemEmpty = "empty";
	
	void insert(Object x) {
		Node3 temp;
		
		if(front == null) {
			front = new Node3();
			front.data = x;
			rear = front;
		}
		else {
			temp = new Node3();
			temp.data = x;
			rear.link = temp;
			rear = temp;
			rear.link = null;
		}
	}
	
	void delete() {
		if(front == null) {
			System.out.println("���� ����Ʈ �Դϴ�.");
		}
		else {
			front = front.link;
			if(front == null)
				rear = null;
		}
	}
	
	Object Peek() {
		if(front == null) {
			System.out.println("���� ����Ʈ �Դϴ�.");
		    return itemEmpty;
		}
		else return front.data;
	}
	
	void print() {
		Node3 temp;
		temp = front;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.link;
		}
		System.out.println("null");
	}
}

public class linkedQueue {
	public static void main(String[] args) {
		Queue que = new Queue();
		
		que.front = null;
		que.insert("Lee");
		que.insert("Yu");
		que.insert("Hwan");
		que.insert(1996);
		System.out.println("insert�� ť ��� ---");
		que.print();
		System.out.println("delete�� ť ��� --- ������ ���� : "+ que.Peek());
		que.delete();	
		que.print();
		que.insert(2015);
		System.out.println("insert�� ť ��� ---");
		que.print();
		System.out.println("Peek ���� ���� : "+ que.Peek());
	}
}
