import java.io.*;
class MergeAlternate<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
	private class Node<AnyType>
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
	void printList()
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
	void insertAfter(Node<AnyType> ptr1,Node<AnyType> ptr2)
	{
		
	}
}