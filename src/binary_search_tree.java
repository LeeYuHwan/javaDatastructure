class BinaryTree{
	int data;
	BinaryTree llink, rlink;
	BinaryTree T;
	
	void build(BinaryTree p, int x) {
		BinaryTree q = p;
		while(p != null) {
			q = p;
			if(x < p.data)
				p = p.llink;
			else
				p = p.rlink;
		}
		if(p == null) {
			p = new BinaryTree();
			p.data = x;
			p.llink = p.rlink = null;
			if(q != null) {
				if(x < q.data)
					q.llink = p;
				else
					q.rlink = p;
			}
			else T = p;
		}		
	
	}
	void preorder(BinaryTree root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.llink);
			preorder(root.rlink);
		}
	}
	void inorder(BinaryTree root) {
		if(root != null) {
			inorder(root.llink);
			System.out.print(root.data + " ");
			inorder(root.rlink);
		}
	}
	void postorder(BinaryTree root) {
		if(root != null) {
			postorder(root.llink);
			postorder(root.rlink);
			System.out.print(root.data + " ");
		}
	}
}

public class binary_search_tree {
	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		
		int x[] = {35, 12, 24, 45, 37, 48, 67};
		
		for(int i = 0; i < x.length; i++)
			obj.build(obj.T, x[i]);
		System.out.println("---preorder---");
		obj.preorder(obj.T);
		System.out.println();
		System.out.println("---inorder---");
		obj.inorder(obj.T);
		System.out.println();
		System.out.println("---postorder---");
		obj.postorder(obj.T);
		System.out.println();
	}
}
