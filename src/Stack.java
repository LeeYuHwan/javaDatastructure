class StkNode{
	Object data;
	StkNode link;
}
class LinkedStack{
	StkNode top;
	String itemEmpty = "StackEmpty";
	
	void push(Object x) {
		StkNode temp;	
		
		if(top == null) {
			top = new StkNode();
			top.data = x;
			top.link = null;
		}
		else {
			temp = new StkNode();
			temp.data = x;
			temp.link = top;
			top = temp;
		}
	}
	
	void pop() {
		if(top == null)
			System.out.println("공백 스택--- pop을 수행할 수 없습니다.");
		else
			top = top.link;
	}
	
	Object Peek() {
		if(top == null) {
			System.out.println("공백 스택입니다.");
			return itemEmpty;
		}
		else
			return top.data;
	}
	
	void print() {
		StkNode temp;
		temp = top;
		while(temp != null) {
			System.out.println(temp.data + " -> ");
			temp = temp.link;
		}
		System.out.println("null");
	}
}

public class Stack {
	public static void main(String[] args) {
		LinkedStack stk = new LinkedStack();
		
		stk.push(12);
		stk.push(35);
		stk.push(67);
		System.out.println("Stack build후 출력---");
		stk.print();
		stk.push(83);
		stk.push(96);
		System.out.println("83, 96 push후 출력---");
		stk.print();
		stk.pop();
		stk.pop();
		System.out.println("pop() 연산 2번 수행후 출력---");
		stk.print();
	}
}
