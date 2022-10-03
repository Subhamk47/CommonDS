package org.subham.MyCollection;

/*
 * Author : @Subham Kumar
 */
public class MyLinkedList<T> {
	
	private int size ;
	private Node<T> head;
	private Node<T> tail;
	
	public MyLinkedList() {
		size = 0;
	}
	public void add(T element) {
		if(size == 0) {
			head = new Node<T>(element);
			tail = head;
			size++;
			return;
		}
		tail.next = new Node<T>(element);
		tail = tail.next;
		size++;
	}
	public T get(int index) {
		if(index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
		if(index == 0) {
			return head.value;
		}
		int i  = 1;
		Node<T> curr = head;
		while(i<index) {
			curr = curr.next;
			i++;
		}
		return curr.next.value;
	}
	
	public void set(int index,T element) {
		if(index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
		if(index == 0) {
			head.value = element;
			return ;
		}
		int i  = 1;
		Node<T> curr = head;
		while(i<=index) {
			curr = curr.next;
			i++;
		}
		curr.value = element;
	}
	public T remove(int index) {
		if(index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
		if(index == 0 ) {
			Node<T> temp = head;
			head = head.next;
			return temp.value;
		}
		int i  = 1;
		Node<T> curr = head;
		while(i<index) {
			curr = curr.next;
			i++;
		}
		Node<T> temp = curr.next;
		curr.next = curr.next.next;
		size--;
		return temp.value;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
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
