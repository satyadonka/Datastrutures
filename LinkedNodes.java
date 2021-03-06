package dataStructures;

import java.util.Scanner;

public class LinkedNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the list size:");
		int size=sc.nextInt();
		LinkedNodes ln = new LinkedNodes();
		Node ptr = ln.getLinkedListof(size);
		ln.printList(ptr);
		//Node sptr = ln.swapElements(ptr);
		Node sptr =ln.swapElements2(ptr);
		ln.printList(sptr);
	}

	public void printList(Node ptr) {
		Node start = ptr;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
		System.out.println();
	}
/**
 * without any extra nodes effecient way
 * @param ptr
 * @return
 */
	public Node swapElements2(Node ptr){
		Node start=ptr;
		Node result=start;
		Node next=null,n1=null,n2=null,prev=null;
		if(start.next==null){
			return start;
		}
		 result=start.next;
		while(start!=null&&start.next!=null){
			next=start.next.next;
			n1=start;
			n2=start.next;
			start=n2;
			start.next=n1;
			start.next.next=next;
			start=next;
			if(prev!=null){
				prev.next=n2;
			}
			prev=n1;
		}
		return result;
	}
	
	
	
	public Node swapElements(Node ptr) {
		/**
		 * Call by Values reference... Thumb rule as long as we are not using
		 * dot operator on left side of the assignment we are not modifying the
		 * list
		 */
		Node start = new Node();

		Node ptr2 = new Node();
		/**
		 * start is an extra pointer that points the start element of the list
		 * One Node preceded to start
		 */
		start.next = ptr;
		if (ptr.next == null) {
			return ptr;
		}
		Node aux = start.next.next;
		/**
		 *  It iis just pointing from 2nd element of the list
		 */
		aux = aux.next;
		/**
		 *  it is just pointing the 3rd element of the list
		 */
		Node n1 = start.next;
		Node n2 = n1.next;
		/**
		 * since left side we are using DOT operator it changes the list
		 */
		start.next = n2;
		start.next.next = n1;
		start.next.next.next = aux;
		/**
		 * ptr2 is an alias to the start pointer ,even though start pointer
		 * changes it keeps the start of the list
		 */
		ptr2 = start;
		start = start.next.next;

		while (start.next != null) {
			aux = start.next.next;
			if (aux == null) {
				break;
			}
			aux = aux.next;
			n1 = start.next;
			n2 = n1.next;
			start.next = n2;
			start.next.next = n1;
			start.next.next.next = aux;

			start = start.next.next;

		}
		return ptr2.next;
	}

	public Node getLinkedListof(int size) {
		Node start = new Node();
		Node ptr = start;
		start.data = "1";
		int l = 2;
		for (int k = 0; k < size - 1; k++) {
			start.next = new Node();
			start.next.data = l + "";
			l++;
			start = start.next;
		}

		return ptr;
	}
}

class Node {
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString() {
		return data;
	}

	Node next;
	String data;
}
