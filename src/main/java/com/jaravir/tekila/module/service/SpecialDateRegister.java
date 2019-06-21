package com.jaravir.tekila.module.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SpecialDateRegister {
	private static SpecialDateRegister handle;
	private List<SpecialDate> register;
	
	private SpecialDateRegister() {
		this.register = new CopyOnWriteArrayList<SpecialDate>();
	}
	
	public static SpecialDateRegister getInstance() {
		if (handle == null)
			handle = new SpecialDateRegister();
		
		return handle;
	}
	
	public void add (SpecialDate dt) {
		this.register.add(dt);
	}
	
	public void remove (SpecialDate dt) {
		this.register.remove(dt);
	}
	
	public boolean contains (SpecialDate dt) {
		return this.register.contains(dt);
	}
	
	public int size() {
		return this.register.size();
	}
	
	public boolean isTodaySpecialDate() {
		Iterator<SpecialDate> it = this.register.iterator();
		while (it.hasNext()) {
			if (it.next().isToday())
				return true;
		}
		return false;
	}
	
	public void clear() {
		this.register.clear();
	}
}
