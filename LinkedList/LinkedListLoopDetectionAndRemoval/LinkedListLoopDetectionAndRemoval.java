import java.io.*;
public class LinkedListLoopDetectionAndRemoval<AnyType>
{
	private  Node<AnyType> head;
	private  Node<AnyType> pointer;
	private class Node<AnyType>
	{
		protected AnyType item;
		protected Node<AnyType> next;
	}
	public boolean isEmpty()
	{
		return (head == null);
	}
	public void push(AnyType item)
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
	public int sizeOfLL()
	{
		Node<AnyType> ptr = head;
		int k =0;
		while(ptr!=null)
		{
			k++;
			ptr = ptr.next;
		}
		return k;
	}
	public boolean detectAndRemoveLoop()
	{
		Node<AnyType> fast=head;
		Node<AnyType> slow=head;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) // Loop Detected
			{
				removeLoop(slow);
				return true;
			}
		}
		return false;
	}
	public void removeLoop(Node<AnyType> loopNode)
	{
		Node<AnyType> ptr1 = loopNode;
		Node<AnyType> ptr2 = loopNode;
		int loopCount = 1;
		while(ptr1.next!=ptr2)
		{
			loopCount++;
			ptr1 = ptr1.next;
		}
		ptr1 = head;
		for(int i=0;i<loopCount;i++)
		{
			ptr1 = ptr1.next;
		}
		ptr2 = head;
		while(ptr1!=ptr2)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		// Get pointer to the last node
		ptr1 = ptr1.next; 
		while(ptr1.next!= ptr2)
		{
			ptr1 = ptr1.next;
		}
		ptr1.next = null;
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
	public void createLoop()
	{
		Node<AnyType> ptr;
		ptr = head;
		ptr.next.next.next.next.next = ptr.next.next;
	}
	public static void main(String args[])
	{
		LinkedListLoopDetectionAndRemoval<Integer> obj = new LinkedListLoopDetectionAndRemoval<Integer>();
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		obj.push(8);
		obj.printList();
		obj.createLoop();
		System.out.println("\nLoop removed and detected = " + obj.detectAndRemoveLoop());
		obj.printList();
	}
}