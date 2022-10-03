package org.subham.MyCollection;

/*
 * Author: Subham Kumar
 * Queue is a Data Structure which is used to perform FIFO operations
 * In this class we are going to use LinkedList node to implement our Data Structure. However we also do it by using an Array.
 * The reason why we don't choose array due to fixed size of means Array size is not dynamic in nature.
 * Note : FIFO stands for first in first out type of collections
 */
public class MyQueue<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public MyQueue() {
		size = 0;
		head = null;
		tail =null;
	}
	public void offer(T element) {
		if(head == null) {
			head = new Node<T>(element);
			tail = head;
			size++;
			return ;
		}
		tail.next = new Node<T>(element);
		tail = tail.next;
		size++;
	}
	public T peek() {
		if(isEmpty()) throw new NullPointerException("Empty Queue");
		return head.value;
	}
	public T pop() {
		if(isEmpty())  throw new NullPointerException("Empty Queue");
		Node<T> temp = head;
		head = head.next;
		size--;
		return temp.value;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}

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
