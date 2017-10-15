import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
class Node {
	int data;
	Node left,right;
	public Node(int item){
		data = item;
		left = right = null;
	}

}

class BinaryTree{
	Node root;
	public BinaryTree(){
		root = null;
	}

	void printLevelOrder(){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node tempNode = q.poll();
			System.out.println(tempNode.data + "  ");
			if(tempNode.left!=null){
				q.add(tempNode.left);
			}
			if(tempNode.right!=null){
				q.add(tempNode.right);				
			}
		}
	}

	   public static void main(String args[]) 
    {
        /* creating a binary tree and entering 
         the nodes */
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);
 
        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}

