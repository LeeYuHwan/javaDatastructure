
class Entry3{
	private int value;
	
	public void setValue(int val) {
		value = val;
	}
	
	public int getValue() {
		return value;
	}
}

public class DoubleHashing {
	private int hTableSize;
	private Entry3[] hTable;
	
	public DoubleHashing(int val) {
		hTableSize = val;
		hTable = new Entry3[hTableSize];
	}
	
	public int hFunc(int key) {
		return key % hTableSize;
	}
	
	public int hFunc2(int key) {
		int f2val = 7;
		return f2val - (key % f2val);
	}
	
	public int getKey(int data) {
		return data;
	}
	
	public Entry3 getEntry(int val) {
		return hTable[val];
	}
	
	public int insert(int data) {
		int key, hVal;
		int point;
		Entry3 entry;
		
		key = getKey(data);
		hVal = hFunc(key);
		
		entry = new Entry3();
		entry.setValue(data);
		
		point = hVal;
		
		for(int i = 0; i < hTableSize; i++) {
			if(hTable[point] == null) {
				hTable[point] = entry;
				System.out.print(data + " 삽입 성공\t");
				return 0;
			}
			else if(hTable[point].getValue() == '*') {
				hTable[point] = entry;
				System.out.print(data + " 삽입 성공\t");
				return 0;
			}
			else point += hFunc2(key);
			if(point > hTableSize - 1) point = point - hTableSize;
		}
		System.out.println(data + " 삽입 실패\t");
		return -1;
	}
	
	public int searchForDel(int data) {
		int key, hVal;
		int point;
		
		key = getKey(data);
		hVal = hFunc(key);
		point = hVal;
		
		for(int i = 0; i < hTableSize; i++) {
			if(hTable[point] == null) return -1;
			else if(hTable[point].getValue() == '*') return -1;
			else if(hTable[point].getValue() == data) return point;
			else point += hFunc2(key);
			if(point > hTableSize - 1) point = point - hTableSize;
		}
		System.out.println("탐색 실패");
		return -1;
	}
	
	public int search(int data) {
		int key, hVal;
		int point;
		
		key = getKey(data);
		hVal = hFunc(key);
		
		point = hVal;
		for(int i = 0; i < hTableSize; i++) {
			if(hTable[point] == null) {
				System.out.println(data + " 탐색 실패");
				return -1;
			}
			else if(hTable[point].getValue() == '*') {
				System.out.println(data + " 탐색 실패");
				return -1;
			}
			else if(hTable[point].getValue() == data) {
				System.out.println(data + " 탐색 성공");
				return point;
			}
			else point += hFunc2(key);
			if(point > hTableSize - 1) point = point - hTableSize;
		}
		System.out.println("탐색 실패");
		return -1;
	}
	
	public int delete(int data) {
		int find = searchForDel(data);
		
		if(find == -1) {
			System.out.print(data + " 자료가 존재하지 않습니다.\t");
			return -1;			
		}
		else {
			hTable[find].setValue('*');
			System.out.print(data + " 삭제 성공\t");
			return 0;
		}
	}
	
	public void showHashTable() {
		for(int i = 0; i < hTableSize; i++) {
			if(hTable[i] == null) System.out.print("_ ");
			else if(hTable[i].getValue() == '*') System.out.print("* ");
			else System.out.print(hTable[i].getValue() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("This is Linear Probing");
		
		LinearProbing lp = new LinearProbing(11);
		
		lp.insert(4);
		lp.showHashTable();
		lp.insert(8);
		lp.showHashTable();
		lp.insert(12);
		lp.showHashTable();
		lp.insert(16);
		lp.showHashTable();
		lp.insert(24);
		lp.showHashTable();
		lp.insert(28);
		lp.showHashTable();
		lp.insert(15);
		lp.showHashTable();
		lp.insert(27);
		lp.showHashTable();
		lp.delete(27);
		lp.showHashTable();
		lp.search(15);
		lp.delete(15);
		lp.showHashTable();
		lp.search(15);
	}
}