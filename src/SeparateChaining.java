class H_Node{
	private int value;
	public H_Node link;
	
	public void setValue(int val) {
		value = val;
	}
	public int getValue() {
		return value;
	}
}

public class SeparateChaining {
	private int hTableSize;
	private H_Node[] hTable;
	
	public SeparateChaining(int val){
		hTableSize = val;
		hTable = new H_Node[hTableSize];
	}
	
	public int hFunc(int key) {
		return key % hTableSize;
	}
	
	public int getKey(int data) {
		return data;
	}
	
	public int insert(int data) {
		int key, hVal;
		H_Node InsNode;
		H_Node pre, cur;
		
		key = getKey(data);
		hVal = hFunc(key);
		
		InsNode = new H_Node();
		InsNode.setValue(data);
		
		if(hTable[hVal] == null) {
			hTable[hVal] = InsNode;
			return 0;
		}
		
		pre = null;
		cur = hTable[hVal];
		
		while(true) {
			if(cur == null) {
				pre.link = InsNode;
				return 0;
			}
			else if(cur.getValue() < key) {
				pre = cur;
				cur = cur.link;
			}
			else {
				if(cur == hTable[hVal]) {
					InsNode.link = cur;
					hTable[hVal] = InsNode;
					return 0;
				}
				else {
					InsNode.link = cur;
					pre.link = InsNode;
					return 0;
				}
			}
		}
	}
	
	public int search(int data) {
		int key, hVal;
		H_Node cur;
		
		key = getKey(data);
		hVal = hFunc(key);
		cur = hTable[hVal];
		
		while(true) {
			if(cur == null) {
				System.out.println(key + " : 찾지 못하고 리스트의 끝에 닿음");
				return -1;
			}
			else if(cur.getValue() == key) {
				System.out.println(cur.getValue() + " 찾음");
				return 0;
			}
			else if(cur.getValue() > key) {
				System.out.println(key + " : 찾지 못하고 더 큰 자료를 만남");
				return -1;
			}
			else cur = cur.link;
		}
	}
	
	@SuppressWarnings("unused")
	public H_Node searchForDel(int data) {
		int key, hVal;
		H_Node pre, cur;
		key = getKey(data);
		hVal = hFunc(key);
		pre = hTable[hVal];
		cur = pre.link;
		
		while(true) {
			if(cur.getValue() == key) return pre;
			else if(cur == null) return null;
			else if(cur.getValue() > key) return null;
			else {
				pre = cur;
				cur = cur.link;
			}
		}
	}
	
	public int delete(int data) {
		int key, hVal;
		H_Node pre, cur;
		key = getKey(data);
		hVal = hFunc(key);
		
		if((pre = searchForDel(data)) == null) {
			System.out.println(data + " 자료가 존재하지 않습니다.");
			return -1;
		}
		
		cur = pre.link;
		pre.link = cur.link;
		
		return 0;
	}
	
	public void showHashTable() {
		H_Node cur;
		
		for(int i = 0; i < hTableSize; i++) {
			System.out.print("|" + i + "|\t");
			cur = hTable[i];
			if(cur == null) System.out.print("n ");
			else {
				while(cur != null) {
					System.out.print(cur.getValue() + " ");
					cur = cur.link;
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("This is Separate Chaining");
		
		SeparateChaining sc = new SeparateChaining(11);
		
		sc.insert(12);
		sc.showHashTable();
		sc.insert(1);
		sc.showHashTable();
		sc.insert(13);
		sc.showHashTable();
		sc.insert(4);
		sc.showHashTable();
		sc.insert(28);
		sc.showHashTable();
		sc.insert(37);
		sc.showHashTable();
		sc.insert(7);
		sc.showHashTable();
		sc.insert(29);
		sc.showHashTable();
		sc.insert(18);
		sc.showHashTable();
		sc.delete(29);
		sc.showHashTable();
		sc.search(29);
		sc.insert(40);
		sc.showHashTable();
		sc.search(29);
	}
}
