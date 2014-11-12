/*
Given two numbers represented by two lists, write a function that returns sum list. The sum list is list representation of addition of two input numbers.

Example 1

Input:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248
Output
  Resultant list: 3->1->6  // represents number 613
Example 2

Input:
  First List: 7->5->9->4->6  // represents number 64957
  Second List: 8->4 //  represents number 48
Output
  Resultant list: 5->0->0->5->6  // represents number 65005

*/


import java.io.*;
class LinkedListAddition1
{
	private Node head;
	private Node pointer;
	public static class Node
	{
		int item;
		Node next;
	}	
	void push(int item)
	{
		if(head == null)
		{
			head = new Node();
			head.item = item;
			head.next = null;
			pointer = head;
		}
		else
		{
			Node newNode = new Node();
			newNode.item = item;
			newNode.next = null;
			pointer.next = newNode;
			pointer = pointer.next;
		}
	}
	void displayLinkedList()
	{
		Node ptr = head;
		if(head == null)
			return;
		while(ptr.next!=null)
		{
			System.out.print(ptr.item + "-->");
			ptr = ptr.next;
		}
		System.out.print(ptr.item);
	}
	static int getLinkedListLength(LinkedListAddition1 ptr)
	{
		Node x1 = ptr.head;
		int c = 0;
		if(x1==null)
			return 0;
		while(x1!=null)
		{
			c++;
			x1 = x1.next;
		}
		return c;
	}
	static void addLinkedLists(LinkedListAddition1 ptr1,LinkedListAddition1 ptr2)
	{
		Node x1 = ptr1.head;
		Node x2 = ptr2.head;
		int carry = 0;
		LinkedListAddition1 result = new LinkedListAddition1();

		while(x1!=null && x2!=null)
		{
			int sum = x1.item + x2.item;
			if(carry!=0)
			{
				sum = sum + carry;
			}
			if(sum>9)
			{
				carry = sum/10;
				sum = sum%10;
			}
			else
			{
				carry = 0;
			}
			result.push(sum);
			x1 = x1.next;
			x2 = x2.next;
		}
		if(x1!=null)
		{
			while(x1!=null)
			{
				int sum1 = x1.item;
				if(carry!=0)
					sum1 = sum1+ carry;
				if(sum1>9)
				{
					carry = sum1/10;
					sum1 = sum1%10;
				}
				else
					carry = 0;

				result.push(sum1);
				x1=x1.next;
			}
		}
		if(x2!=null)
		{
			while(x2!=null)
			{
				int sum2 = x2.item;
				if(carry!=0)
					sum2 = sum2+ carry;
				if(sum2>9)
				{
					carry = sum2/10;
					sum2 = sum2%10;
				}
				else
				{
					carry = 0;
				}
				result.push(sum2);
				x2=x2.next;
			}
		}
		if(carry!=0)
		{
			result.push(carry);
		}
		System.out.println("\nPrinting the added list --> \n");
		result.displayLinkedList();
	}
	public static void main(String args[])
	{
		LinkedListAddition1 LL1 = new LinkedListAddition1();
		LinkedListAddition1 LL2 = new LinkedListAddition1();
		

		LL1.push(7);
		LL1.push(5);
		LL1.push(9);
		LL1.push(4);
		LL1.push(6);
		
		LL1.displayLinkedList();
		System.out.println("\n");
		LL2.push(8);
		LL2.push(4);
		
		LL2.displayLinkedList();
		addLinkedLists(LL1,LL2);
	}
}