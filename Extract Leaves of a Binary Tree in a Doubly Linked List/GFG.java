class Node{
	int data;
	Node left,right;

	Node(int item){
		data = item;
		right=left=null;
	}

}

public class GFG{
	Node root;
	Node head;
	Node prev;

	public Node extractLeavesToDLL(Node root){
		if(root ==null)
			return null;
		if(root.left==null && root.right==null){
			if(head==null)
			{
				head = root;
				prev = root;
			}
			else{
				prev.right = root;
				root.left = prev;
				prev = root;
			}
			return null;

		}
		root.left = extractLeavesToDLL(root.left);
        root.right = extractLeavesToDLL(root.right);
        return root;
	}

	public void printDLL(Node head) 
    {
        Node last = null;
        while (head != null) 
        {
            System.out.print(head.data + " ");
            last = head;
            head = head.right;
        }
    }
  
    void inorder(Node node) 
    {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
  
    // Driver program to test above functions
    public static void main(String args[]) 
    {
        GFG tree = new GFG();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
  
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.right.right.left = new Node(9);
        tree.root.right.right.right = new Node(10);
  
        System.out.println("Inorder traversal of given tree is : ");
        tree.inorder(tree.root);
        tree.extractLeavesToDLL(tree.root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        tree.printDLL(tree.head);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree is : ");
        tree.inorder(tree.root);
    }
}