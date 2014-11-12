import java.io.*;
class DeleteNAfterM<AnyType>
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
	void skipDeleteN(int m,int n)
	{
		Node<AnyType> ptr = head;
		Node<AnyType> temp = null;
		while(ptr!=null)
		{
			int count = 1;
			while(ptr!=null && count < m)
			{
				ptr = ptr.next;
				count ++;
			}
			 if(ptr == null)
			 	return;
			count = 1;
			temp = ptr.next;
			while(count<=n && temp!=null)
			{
				temp = temp.next;
				count++;
			}
			ptr.next = temp;
			ptr = temp;
		}
	}
	public static void main(String args[])
	{
		DeleteNAfterM<Integer> obj = new DeleteNAfterM<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(4);
		obj.push(5);
		obj.push(3);
		obj.push(6);
		obj.printList();
		obj.skipDeleteN(3,2);
		System.out.println("\n\n After removing duplicates ------------------------\n\n");
		obj.printList();
	}
}