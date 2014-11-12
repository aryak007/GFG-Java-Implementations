import java.io.*;
class NthNodeFromEnd<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
	private class Node<AnyType>
	{
		protected AnyType item;
		protected Node<AnyType> next;
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
	boolean isEmpty()
	{
		return head == null;
	}
	AnyType printNthLastNode(int n)
	{
		Node<AnyType> ptr1 = head;
		Node<AnyType> ptr2 = head;
		for(int i =0;i<n;i++)
		{
			ptr1 = ptr1.next;
		}
		while(ptr1!=null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr2.item;
	}
	public static void main(String args[])
	{
		NthNodeFromEnd<Integer> obj = new NthNodeFromEnd<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		System.out.println("The nth item is = "+obj.printNthLastNode(5));
	}
}