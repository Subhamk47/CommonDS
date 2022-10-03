package org.subham.MyCollection;

/*
 * Author : Subham Kumar
 */
public class MyStack<T> {
	
	private Node<T> head ;
	private int size;
	MyStack(){
		head = null;
		size = 0;
	}
	public void push(T element) {
		if(head == null) {
			head = new  Node<T>(element);
			size++;
			return;
		}
		Node<T> node = new Node<T>(element);
		node.next = head;
		head = node;
		size++;
	}
	public T pop() {
		if(isEmpty()) throw new NullPointerException("Stack is empty");
		Node<T> temp = head;
		head = head.next;
		size--;
		return temp.value;
	}
	public T peek() {
		if(isEmpty()) throw new NullPointerException("Stack is empty");
		return head.value;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public String toString() {
		StringBuilder sb = new  StringBuilder("[");
		Node<T> curr = head;
		while(curr.next!=null) {
			sb.append(curr.value+", ");
			curr = curr.next;
		}
		sb.append(curr.value+"]");
		return sb.toString();
	}
	
}
