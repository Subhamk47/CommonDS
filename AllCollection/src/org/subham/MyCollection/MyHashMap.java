package org.subham.MyCollection;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;
/*
 * Author : Subham Kumar
 * 
 */
public class MyHashMap<Key , Value> {
	
	private static final float GROWTH_FACTOR = 1.75f;
	private static final float LOAD_FACTOR = 0.75f;
	private int capacity = 1<<4;
	private int size;
	private HashNode [] arr ;
	
	@SuppressWarnings("unchecked")
	public MyHashMap() {
		size = 0;
		arr = (MyHashMap<Key, Value>.HashNode[]) Array.newInstance(HashNode.class, capacity);
	}
	
	public void put(Key key, Value value) {
		HashNode node = getNodeFromKey(key);
		// insert 
		if(node == null) {
			insert(key,value);
		}
		//update
		else {
			node.value = value;
		}
		if(  size >= (int) capacity*LOAD_FACTOR) {
			reHash();
		}
	}
	@SuppressWarnings("unchecked")
	private void reHash() {
		HashNode [] temp = arr;
		arr = (MyHashMap<Key, Value>.HashNode[]) Array.newInstance(HashNode.class, (int) (capacity * GROWTH_FACTOR));
		capacity = arr.length;
		for(int i = 0;i<temp.length;i++) {
			HashNode root = temp[i];
			while(root!=null) {
				put(root.key, root.value);
				root = root.next;
			}
		}
	}

	private void insert(Key key, Value value) {
		int index = getHash(key);
		HashNode node  = arr[index];
		HashNode temp = new HashNode(key, value);
		temp.next = node;
		arr[index] = temp;
		size++;
	}

	private HashNode getNodeFromKey(Key key) {
		int index = getHash(key);
		HashNode node = arr[index];
		while(node!=null) {
			if(node.key.equals(key)) return node;
			node = node.next;
		}
		return null;
	}

	private int getHash(Key key) {
		return key.hashCode()%capacity;
	}

	public Value get(Key key) {
		HashNode node = getNodeFromKey(key);
		if(node == null) return null;
		return node.value;
	}
	public boolean containsKey(Key key) {
		return getNodeFromKey(key)!=null;
	}
	public List<Key> keySet(){
		List<Key> result = new ArrayList<>();
		for(int i = 0;i<capacity;i++) {
			HashNode temp = arr[i];
			while(temp != null) {
				result.add(temp.key);
				temp = temp.next;
			}
		}
		return result;
	}
	public int size() {
		return size;
	}
	private class HashNode{
		Key key;
		Value value;
		HashNode next;
		HashNode(Key key, Value value) {
			this.key = key;
			this.value = value;
			next = null;
		}
	}
}
