import java.io.*;
class ReverseLLGroup<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
	private int n = 3;
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
	Node<AnyType> reverseGroup(Node<AnyType> headref,int k)
	{
		Node<AnyType> ptr = headref;
		Node<AnyType> temp = null;
		Node<AnyType> prev = null;
		int count = 0;
		while(ptr!=null && count<k)
		{
			temp = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = temp;
			count++;
		}
		if(temp!=null)
			headref.next = reverseGroup(temp,k);
		return prev;
	}
	void _reverseGroup()   //Wrapper Function 
	{
		head = reverseGroup(head,n);
	}
	public static void main(String args[])
	{
		ReverseLLGroup<Integer> obj = new ReverseLLGroup<Integer>();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.printList();
		obj._reverseGroup();
		System.out.println("\n\n After group reverse ------------------------\n\n");
		obj.printList();
	}
}