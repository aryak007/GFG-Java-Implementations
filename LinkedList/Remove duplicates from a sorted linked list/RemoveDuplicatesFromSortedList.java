import java.io.*;
class RemoveDuplicatesFromSortedList<AnyType>
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
	void removeDuplicates()
	{
		Node<AnyType> current = head;
		Node<AnyType> temp = null;
		if(current == null)
			return;
		while(current.next!=null)
		{
			if(current.item == current.next.item)
			{

				temp = current.next.next;
				current.next = null;
				current.next = temp;
			}
			else
			{
				current = current.next;
			}
		}
	}
	boolean isEmpty()
	{
		return head == null;
	}
	public static void main(String args[])
	{
		RemoveDuplicatesFromSortedList<Integer> obj = new RemoveDuplicatesFromSortedList<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(2);
		obj.push(4);
		obj.push(5);
		obj.push(5);
		obj.push(5);
		obj.push(8);
		obj.push(9);
		obj.push(10);
		obj.push(10);
		obj.printList();
		obj.removeDuplicates();
		System.out.println("\n\n After removing duplicates ------------------------\n\n");
		obj.printList();
	}
}