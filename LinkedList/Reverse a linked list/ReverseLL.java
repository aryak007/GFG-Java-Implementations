import java.io.*;
class ReverseLL<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
	private Node<AnyType>prev=null;
	private static class Node<AnyType>
	{
		private AnyType item;
		private Node<AnyType> next;
	}
	void push(AnyType item)
	{
		if(isEmpty())
		{
			head = new Node<AnyType>();
			head.item = item;
			head.next = null;
			pointer = head;
		}
		else
		{
			Node<AnyType> newNode = new Node<AnyType>();
			newNode.item = item;
			newNode.next = null;
			pointer.next = newNode;
			pointer = pointer.next;
		}
	}
	public void printList()
	{
		Node<AnyType> ptr = head;
		while(ptr.next != null)
		{
			System.out.print(ptr.item + "-->");
			ptr = ptr.next;
		}
		System.out.print(ptr.item);
	}
	boolean isEmpty()
	{
		return head == null;
	}
	void reverseIterative() //Iterative way of reversing LL 
	{
		Node<AnyType>prev=null;
		Node<AnyType> ptr= head;
		Node<AnyType> temp = null;
		while(ptr!=null)
		{
			temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
		}
		head = prev;
	}
	void reverseRecursive(Node<AnyType> headref)
	{
		if(headref == null)
			return;
		Node<AnyType> first = headref;
		Node<AnyType> ptr= first.next;
		if(ptr == null)
			return;
		reverseRecursive(ptr);
		first.next.next  = first;  
    	first.next  = null;          
    	headref = ptr;   
	}
	void _reverseRecursive() //wrapper function
	{
		reverseRecursive(head);
		head = prev;
	}
	public static void main(String args[])
	{
		ReverseLL<Integer> obj = new ReverseLL<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.printList();
		/*obj.reverseIterative();
		System.out.println("\n\n After reverse Iterative------------------------\n\n");
		obj.printList();*/
		obj._reverseRecursive();
		System.out.println("\n\n After reverse recursive------------------------\n\n");
		obj.printList();
	}
}