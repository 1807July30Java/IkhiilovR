package com.revature.oop;

import java.util.Arrays;
import java.util.TreeSet;

public class DNA {
	
	private String start;
	private String end;
	private String[] bank;
	private String current;
	private int numMutations;
	private TreeSet<DnaNode> dnaTree;
	
	
	public DNA(String start, String end, String[] bank ){
		this.start = start;
		this.end = end;
		this.bank = bank;
		this.numMutations = 0;
		this.current = start;
	}

	private boolean endCheck() {
		if (this.end.contains("[^ACGT]")) {
			return false;
		}  
		if (end.length() != 8) {
			return false;
		}
		if(!Arrays.asList(bank).contains(end))
			return false;
		return true;
			
	}
	
	public boolean checkMutation() {
		
		return false;
		
	}
	
	private void mutate(){
		
		int currentNumMutations =0;
		for (int i =0; i< bank.length; i++) {
			
			for(int j = 0; j < this.start.length(); j++) {
				
				if(current.charAt(j) != bank[i].charAt(j)) {
					
					currentNumMutations ++;
					if(currentNumMutations > 1) {
						currentNumMutations = 0;
						break;
					}
				}
				
			}
			
		}	
		
	}
	
	public int checkPath() {
		
		/*
		 * base cases
		 */
		if (!endCheck()) 
			return -1;
	
		if (start.equals(end))
			return 0;
		
		
		while(this.numMutations < bank.length && !current.equals(end) ){
			
			mutate();
			this.numMutations ++;
			
		}
		
		
		return this.numMutations;
	}

	@Override
	public String toString() {
		return "DNA [start=" + start + ", end=" + end + ", bank=" + Arrays.toString(bank) + ", numMutations="
				+ numMutations + "]";
	}
	
	

}
