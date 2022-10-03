package org.subham.MyCollection;

/*
 * @Author : Subham Kumar
 * 10/03/2022
 */
public class MyArrayList <T> {
	
	private static final float GROWTH_FACTOR = 1.5f;
	private int capacity = 100;
	private T [] arr ;
	private int size ;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		arr = (T[]) new  Object[capacity];
		size = 0;
	}
	public void add(T element) {
		if(size == arr.length/2) 
			grow();
		arr[size++] = element;
	}
	public T get(int index) {
		if( index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
		return arr[index];
	}
	
	public void set(int index,T element) {
		if(index<0 || index>=size) throw new ArrayIndexOutOfBoundsException();
		arr[index] = element;
	}
	public T remove(int index) {
		if(index>=size) throw new ArrayIndexOutOfBoundsException();
		T obj = arr[index];
		arr[index] = null;
		for(int i = index ; i<size-1;i++) {
			arr[i] = arr[i+1]; 
		}
		size--;
		return obj;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	private void grow() {
		T [] temp = (T[]) new Object[(int) (capacity*GROWTH_FACTOR)];
		for(int i  = 0;i<size;i++) {
			temp [i] = arr[i];
		}
		arr = temp;
		capacity = temp.length;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0;i<size;i++) {
			if(i == (size-1)) {
				sb.append(arr[i]);
				break;
			}
 			sb.append(arr[i]+", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
