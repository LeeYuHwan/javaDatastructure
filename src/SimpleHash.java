class Entry{
	private int value;
	public void setValue(int val) {
		value = val;
	}
	public int getValue() {
		return value;
	}
}
public class SimpleHash {
	private int hTableSize;
	private Entry[] hTable;
	
	public SimpleHash(int val) {
		hTableSize = val;
		hTable = new Entry[hTableSize];
	}
	
	public int hFunc(int val) {
		return val % hTableSize;
	}
	
	public void insert(int data) {
		int val;
		Entry entry;
		
		entry = new Entry();
		entry.setValue(data);
		
		val = hFunc(data);
		if(hTable[val] == null) {
			hTable[val] = entry;
			System.out.print(data + " 입력 \t");
		}
		else {
			System.out.print(data + " 입력 실패\t");
		}
	}
	
	public void showHashTable() {
		for(int i = 0; i < hTableSize; i++) {
			if(hTable[i] == null) System.out.print("_ ");
			else System.out.print(hTable[i].getValue() + " ");		
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	    System.out.println("This is Simple Hash");
	    
	    SimpleHash sh = new SimpleHash(11);
	    
	    sh.insert(4);
	    sh.showHashTable();
	    sh.insert(8);
	    sh.showHashTable();
	    sh.insert(12);
	    sh.showHashTable();
	    sh.insert(16);
	    sh.showHashTable();
	    sh.insert(20);
	    sh.showHashTable();
	    sh.insert(24);
	    sh.showHashTable();
	    sh.insert(28);
	    sh.showHashTable();
	    sh.insert(32);
	    sh.showHashTable();
	    
	    sh.insert(30);
	}
}
