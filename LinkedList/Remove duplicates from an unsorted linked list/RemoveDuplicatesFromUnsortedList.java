import java.io.*;
import java.util.*;
class RemoveDuplicatesFromUnsortedList<AnyType>
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
	void removeDuplicates()
	{
		HashSet<AnyType> hs = new HashSet<AnyType>();
		Node<AnyType> prev = head;
		Node<AnyType> temp = head.next;
		Node<AnyType> ptr = null;
		hs.add(head.item);
		while(temp!=null && prev.next!=null)
		{
			if(hs.contains(temp.item))
			{
				ptr = temp.next;
				temp.next = null;
				prev.next = ptr;
				temp = prev.next;
			}
			else
			{
				hs.add(temp.item);
				temp = temp.next;
				prev = prev.next;
			}
		}
	}
	}
	public static void main(String args[])
	{
		RemoveDuplicatesFromUnsortedList<Integer> obj = new RemoveDuplicatesFromUnsortedList<Integer>();
		obj.push(1);
		obj.push(5);
		obj.push(4);
		obj.push(5);
		obj.push(3);
		obj.push(4);
		obj.push(7);
		obj.push(7);
		obj.printList();
		obj.removeDuplicates();
		System.out.println("\n\n After removing duplicate elements ------------------------\n\n");
		obj.printList();
	}
}