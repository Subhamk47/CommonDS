package org.subham.MyCollection;

import java.util.Comparator;
/*
 * Author : Subham Kumar
 */
public class PriorityQueue<T> {
	
	private static final float GROWTH_FACTOR = 1.5f;
	private int capacity = 100;
	private T[] arr ;
	private int size;
	private Comparator<T> comparator;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(Comparator<T> comparator) {
		arr = (T[]) new Object[capacity];
		size = 0;
		this.comparator = comparator;
	}
	
	public void add(T element) {
		if(size==capacity) grow();
		arr[size] = element;
		rise(size);
		size++;
	}
	private void rise(int index) {
		int parent = getParent(index);
		while(index > 0 && comparator.compare(arr[parent], arr[index]) >0  ) {
			swap(parent,index);
			index = parent;
			parent = getParent(index);
		}
	}
	@SuppressWarnings("unchecked")
	private void grow() {
		T [] temp = (T[]) new Object[ (int) ( capacity * GROWTH_FACTOR)];
		for(int i  = 0;i<size;i++) {
			temp[i] = arr[i];
		}
		arr = temp;
		capacity = temp.length;
	}

	private void sink(int index) {
		while(true) {
			int child =  getLeft(index);
			if(child>=size) return;
			if( getRight(index) <size && comparator.compare( arr[child] ,  arr[getRight(index)]) >0 ) {
				child = getRight(index);
			}
			if(comparator.compare( arr[index] , arr[child])  > 0) {
				swap(index, child);
				index = child;
			}else return;
		}
	}
	private int getParent(int index)   { return (index-1)/2; }
	private int   getLeft(int index)   { return index*2+1; }
	private int   getRight(int index)  { return index*2+2; }

	public T remove() {
		if(isEmpty()) throw new NullPointerException("Empty Queue");
		swap(0,size-1);
		T temp = arr[size-1];
		arr[size-1] = null;
		size--;
		sink(0);
		return temp;
	}
	
	private void swap(int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public T getMin() {
		if(isEmpty()) throw new NullPointerException("Empty Queue");
		return arr[0];
	}
	public int size() {return size;}
	public boolean isEmpty() {return size==0;}

	@Override
	public String toString() {
		StringBuilder  sb = new StringBuilder("[");
		for(int i  = 0;i<size-1;i++) {
			sb.append(arr[i] +", ");
		}
		sb.append(arr[size-1]+"]");
		return sb.toString();
	}
}
