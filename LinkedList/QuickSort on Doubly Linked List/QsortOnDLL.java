import java.io.*;
class QsortOnDLL<AnyType>
{
	private Node<AnyType> head;
	private Node<AnyType> pointer;
	private static class Node<AnyType>
	{
		private int item;
		private Node<AnyType> prev;
		private Node<AnyType> next;
	}
	boolean isEmpty()
	{
		return (head == null);
	}
	void add(int item)
	{
		if(isEmpty())
		{
			head = new Node<AnyType>();
			head.item = item;
			head.next = null;
			head.prev = null;
			pointer = head;
		}
		else
		{
			Node<AnyType> newNode = new Node<AnyType>();
			newNode.item = item;
			newNode.next = null;
			pointer.next = newNode;
			newNode.prev = pointer;
			pointer = newNode;
		}
	}
	boolean compare(int a,int b)
	{
		return (a<=b);
	}
	Node<AnyType> lastNode()
	{
		Node<AnyType> ptr = head;
		while(ptr.next!=null)
		{
			ptr=ptr.next;
		}
		return  ptr;
	}
	void _quickSort(Node<AnyType> low,Node<AnyType> high)
	{
		Node<AnyType> l =low;
		Node<AnyType> h =high;
		if(h!=null && l!=h && l!=h.next)
		{
			Node<AnyType> p = partition(l,h);
			_quickSort(l,p.prev);
			_quickSort(p.next,h);
		}
	}
	void quickSortDLL() /* wrapper fucntion*/
	{
		_quickSort(head,lastNode());
	}
	Node<AnyType> partition(Node<AnyType> low,Node<AnyType> high)
	{
		int x = high.item;
		Node<AnyType> i = low.prev;
		for(Node<AnyType> j = low;j!=high;j=j.next)
		{
			if(compare(j.item,x))
			{
				i = (i == null)? low : i.next;
				swapDLL(i,j);
			}
		}
		i = (i == null)? low : i.next;
		swapDLL(i,high);
		return i;
	}
	void swapDLL(Node<AnyType> ptr1, Node<AnyType> ptr2)
	{
		int temp = ptr1.item;
		ptr1.item = ptr2.item;
		ptr2.item = temp;
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
	public static void main(String[] args) 
	{
		QsortOnDLL<Integer> obj = new QsortOnDLL<Integer>();
		obj.add(8);
		obj.add(5);
		obj.add(3);
		obj.add(7);
		obj.add(8);
		
		obj.printList();
		obj.quickSortDLL();
		System.out.println("\n\nAfter sorting \n\n---------------------- \n\n");
		obj.printList();
	}
}