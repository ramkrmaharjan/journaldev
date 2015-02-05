package com.cart.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomHashMap {
	
	private int size;
	
	private Set<Entry> entrySet = new HashSet<Entry>();
	public int getSize() {
		return size;
	}
	
	public void put(String key,String value) {
		Entry e = new Entry(key,value);
		entrySet.add(e);
		System.out.println(e.hashCode()+":" + "");
	}
	
	public String get(String key) {
		for(Entry e: entrySet) {
			if(e.getKey().equals(key)) {
				return e.getValue();
			}
		}
		return null;
	}
	
	public List<String> getKeySet() {
		List<String> list = new ArrayList<String>();
		for(Entry e: entrySet) {
			list.add(e.getKey());
		}
		return list;
	}
	
	public List<String> getValues() {
		List<String> list = new ArrayList<String>();
		for(Entry e: entrySet) {
			list.add(e.getValue());
		}
		return list;
	}
	
	public Set<Entry> getEntrySet() {
		return entrySet;
	}
	
	class Entry {
		private String key;
		private String value;
		
		Entry(String key,String value) {
			this.setKey(key);
			this.setValue(value);
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	
	public static void main(String[] args) {
		CustomHashMap m = new CustomHashMap();
		m.put("a", "John");
		m.put("b", "Johny");
		m.put("c", "Johnyy");
		m.put("c", "Johnyyy");
		
		System.out.println(m.get("c"));
	}
}
