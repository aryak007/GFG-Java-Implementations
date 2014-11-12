import java.io.*;
class SortedMerge
{
	private Node head;
	private Node tail;
	private static class Node
	{
		private int item;
		private Node next;
	}
	void push(int item)
	{
		if(isEmpty())
		{
			head = new Node();
			head.item = item;
			head.next = null;
			tail = head;
		}
		else
		{
			Node newNode = new Node();
			newNode.item = item;
			newNode.next = null;
			tail.next = newNode;
			tail = tail.next;
		}
	}
	void printList()
	{
		Node ptr = head;
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
	int findLength(Node ptr)
	{
		int count = 0;
		while(ptr!=null)
		{
			count++;
			ptr = ptr.next;
		}
		return count;
	}
	static void merge(SortedMerge A,SortedMerge B) // Using dummy node
	{
		SortedMerge resulthead = new SortedMerge();
		Node result = resulthead.head;
		Node a = A.head;
		Node b = B.head;
		while(a!=null && b!=null)
		{
			if(a.item<=b.item)
			{
				MoveNode(resulthead,A);
				result.next = null;
				a = A.head;
			}
			else
			{
				MoveNode(resulthead,B);
				result.next = null;
				b = B.head;
			}
		}
		if(a==null)
		{
			result = b;
			result.next = null;
		}
		if(b==null)
		{
			result = a;
			result.next = null;
		}
		
		System.out.println("\n\nPRINTING THE LINKED LIST");
		resulthead.printList();
	}
	static void MoveNode(SortedMerge obj1,SortedMerge obj2)
	{
		Node sourceref = obj2.head;
		Node destref = obj1.head;
		Node temp = sourceref.next;
		sourceref.next = destref;
		obj1.head = sourceref;
		obj2.head = temp;
	}

	public static void main(String args[])
	{
		SortedMerge obj1 = new SortedMerge();
		SortedMerge obj2 = new SortedMerge();
		obj1.push(1);
		obj1.push(2);
		obj1.push(3);
		obj2.push(4);
		obj2.push(5);
		obj2.push(6);
		obj1.printList();
		System.out.println("\n");
		obj2.printList();
		
		/*MoveNode(obj1,obj2);
		System.out.println("\nAfter moving nodes we get\n");
		obj1.printList();
		System.out.println("\n");
		obj2.printList();*/
		merge(obj1,obj2);
	}
}