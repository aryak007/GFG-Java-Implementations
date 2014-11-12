import java.io.*;
class DeleteAlternateNodes<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
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
	void deleteAlternate()
	{
		Node<AnyType> ptr = head;
		Node<AnyType> temp = null;
		while(ptr.next!=null)
		{
			if(ptr.next.next==null)
				ptr.next = null;
			else
			{
				temp = ptr.next.next;
				ptr.next.next= null;
				ptr.next = temp;
				ptr = temp;
			}
		}
	}
	public static void main(String args[])
	{
		DeleteAlternateNodes<Integer> obj = new DeleteAlternateNodes<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(4);
		obj.push(5);
		obj.push(3);
		obj.push(6);
		obj.push(7);
		obj.printList();
		obj.deleteAlternate();
		System.out.println("\n\n After removing elements ------------------------\n\n");
		obj.printList();
	}
}