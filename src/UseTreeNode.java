class TreeNode{
	Object data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode build(TreeNode tr1, Object data, TreeNode tr2) {
		TreeNode temp = new TreeNode();
		temp.data = data;
		temp.left = tr1;
		temp.right = tr2;
		return temp;
	}
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data);
			inorder(root.right);
		}	
	}
	
	public void postorder(TreeNode root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data);
		}
	}
}

public class UseTreeNode {
	public static void main(String[] args) {		
		TreeNode T = new TreeNode();

		TreeNode n8 = T.build(null, 5, null);
		TreeNode n7 = T.build(n8, 8, null);
		TreeNode n6 = T.build(null, 9, null);
		TreeNode n5 = T.build(null, 3, null);
		TreeNode n4 = T.build(null, 1, n7);
		TreeNode n3 = T.build(null, 6, n6);
		TreeNode n2 = T.build(null, 2, n5);
		TreeNode n1 = T.build(n3, 4, n4);
		TreeNode root = T.build(n1, 7, n2);
		
		System.out.print("*** Preorder  : ");
		T.preorder(root);
		System.out.println();
		System.out.print("*** Inorder   : ");
		T.inorder(root);
		System.out.println();
		System.out.print("*** Postorder : ");
		T.postorder(root);
        System.out.println();
	}
}
