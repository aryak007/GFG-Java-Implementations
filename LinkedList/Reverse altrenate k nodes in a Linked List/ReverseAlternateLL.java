import java.io.*;
public class ReverseAlternateLL<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
	private static class Node<AnyType>
	{
		private Node<AnyType> next;
		private AnyType item;
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
	Node<AnyType> reverseAlternate(Node<AnyType> headref,int k)
	{
		Node<AnyType> ptr = headref;
		Node<AnyType> prev = null;
		Node<AnyType> temp = null;
		int count = 0;
		while(ptr!=null && count<k)
		{
			temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
			count++;
		}
		count =0;
		headref.next = temp;
		while(temp!=null && count<k)
		{
			temp = temp.next;
			count++;
			headref = headref.next;
		}

		if(temp!=null)
			headref.next = reverseAlternate(temp,k);
		return prev;
	}

	void _reverseAlternate()   //wrapper function
	{
		head = reverseAlternate(head,3);
	}
	public static void main(String args[])
	{
		ReverseAlternateLL<Integer> obj = new ReverseAlternateLL<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.push(8);
		obj.push(9);
		obj.push(10);
		obj.push(11);
		obj.printList();
		obj._reverseAlternate();
		System.out.println("\n\n After group reverse ------------------------\n\n");
		obj.printList();
	}
}