package org.subham.MyCollection;

/*
 * Author : Subham Kumar
 * Dequeue is a Data Structure which allow Insert and remove th both the end but we cannot do any modification in the middle of the queue.
 * 
 * Created Date :- 03-10-2022
 */
public class MyDeque<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	public MyDeque() {
		head = null;
		tail = null;
		size = 0;
	}
	public void offerFirst(T element) {
		if(head == null) {
			head = new Node<T>(element);
			tail = head;
			size++;
			return;
		}
		Node<T> node = new  Node<T>(element) ;
		node.next = head;
		head.prev = node;
		head = node;
		size++;
	}
	public void offerLast(T element) {
		if(head == null) {
			head = new Node<T>(element);
			tail = head;
			size++;
			return;
		}
		tail.next = new  Node<T>(element);
		tail.next.prev = tail;
		tail = tail.next;
		size++;
	}
	public T peekFirst() {
		if(isEmpty()) throw new NullPointerException("Empty Deque");
		return head.value;
	}
	public T peekLast() {
		if(isEmpty()) throw new NullPointerException("Empty Queue");
		return tail.value;
	}
	public T popFirst() {
		if(isEmpty()) throw new NullPointerException("Empty Queue");
		size--;
		Node<T> temp = head;
		head = head.next;
		head.prev = null;
		return temp.value;
	}
	public T popLast() {
		if(isEmpty()) throw new NullPointerException("Empty Queue");
		size--;
		Node<T> temp = tail;
		tail = tail.prev;
		tail.next = null;
		return temp.value;
	}
	
	public boolean isEmpty() {return size==0;}
	public int size() {	return size; }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<T> curr = head;
		while(curr.next!=null) {
			sb.append(curr.value+", ");
			curr = curr.next;
		}
		sb.append(curr.value+"]");
		return sb.toString();
	}
	
}
