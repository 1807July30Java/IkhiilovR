package com.revature.oop;

public class DnaNode {
	
	private String current;
	private String prev;
	private int numMutations;
	
	public DnaNode(String current, String prev, int numMutations) {
		super();
		this.current = current;
		this.prev = prev;
		this.numMutations = numMutations;
	}
	
	public String getCurrent() {
		return current;
	}
	
	public void setCurrent(String current) {
		this.current = current;
	}
	
	public String getPrev() {
		return prev;
	}
	
	public void setPrev(String prev) {
		this.prev = prev;
	}
	
	public int getNumMutations() {
		return numMutations;
	}
	
	public void setNumMutations(int numMutations) {
		this.numMutations = numMutations;
	}
	
	

}
