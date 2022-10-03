package org.subham.MyCollection;

public class Node <T>{
	T value;
	Node<T> next;
	Node<T> prev; // Only to perform doubly linkedlist
	Node(T value ){
		this.value = value;
		next = null;
		prev = null;
	}
}
