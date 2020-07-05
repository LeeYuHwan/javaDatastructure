
class Node{
	int data;
	Node link;
	
	Node build() {
		Node L = null, temp, end;
		int x = 0;
		end = L;
		int[] Data = {5, 16, 38, 52, 69};
		int no = Data.length;
		for(int i = 0; i < no; i++) {
			temp = new Node();
			x = Data[i];
			temp.data = x;
			if(L == null) {
				L = temp;
				end = L;
			}
			else {
				end.link = temp;
				end = temp;
			}			
		}
		System.out.println("*** 리스트 L 출력");
		print(L);
		return L;		
	}
	
	Node Search(Node L, int x) {
		Node Temp = L;
		Node Pos = L;
		
		while(Temp != null && x > Temp.data) {
			Pos = Temp;
			Temp = Temp.link;
		}
		return Pos;
	}
	
	Node insert(Node p, int x) {
		Node Pos, InsNode, Temp = null;
		InsNode = new Node();
		InsNode.data = x;
		if(x < p.data) {
			InsNode.link = p;
			p = InsNode;
		}
		else {
			Pos = Search(p, x);
			Temp = Pos.link;
			Pos.link = InsNode;
			InsNode.link = Temp;
		}
		System.out.println("*** 원소 "+ x +" 삽입 후 리스트 L 출력");
		print(p);
		return p;
	}
	
	Node DelSearch(Node L, int x) {
		Node Temp = L;
		Node Pos = L;
		
		while(Temp != null && x != Temp.data) {
			Pos = Temp;
			Temp = Temp.link;
		}
		return Pos;
	}
	
	Node delete(Node p, int x) {
		Node Pos, Temp = null;
		boolean flag = false;
		Pos = DelSearch(p, x);
		if(x == p.data) 
			p = p.link;
		else {
			if(Pos.link != null) {
				Temp = Pos.link;
				Pos.link = Temp.link;
			}
			else {
				System.out.println("삭제할 원소 "+ x +"가 없습니다.");
				flag = true;
			}			
		}
		if(flag == false) {
			System.out.println("*** 원소 "+ x +" 삭제 후 리스트 L 출력");
			print(p);
		}
		return p;
	}
	
	void print(Node p) {
		Node Temp = p;
		while(Temp != null) {
			System.out.print(Temp.data + " -> ");
			Temp = Temp.link;
		}
		System.out.println("null");
	}
}

public class LinkedList {
	public static void main(String[] args) {
		Node obj = new Node();
		Node L = null;
		L = obj.build();
		L = obj.insert(L, 27);
		L = obj.insert(L, 12);
		L = obj.delete(L, 27);
		L = obj.delete(L, 3);
		L = obj.delete(L, 7);
		L = obj.insert(L, 6);
	}
}
