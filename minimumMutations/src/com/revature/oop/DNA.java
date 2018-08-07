package com.revature.oop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
	
	public boolean checkMutation(String w1, String w2) {
		/*
		 *  change in one letter = mutation
		 */
		int count = 0;
		for (int i = 0; i < w1.length();i++) {
			
			if(w1.charAt(i) != w2.charAt(2)) {
				count ++;
				if (count > 1)
					return false;
			}
		}
		
		return (count == 1);
		
	}
	
	private void mutate(){
		/*
		 * add current string into a queue
		 * pop string into another queue 
		 * then find all 1 mutations from initial queue and add to the 2nd queue
		 * if the string == end string return
		 * 
		 * 		0 - 	initial
		 * 1	1	1 	mutations
		 * 2	2	2	mutations
		 * 
		 */
		Queue<String> currentMutation = new LinkedList<String>();
		currentMutation.add(start);
		Queue<String> nextMutation = new LinkedList<String>();
			
		while(!currentMutation.isEmpty()){
			String currentDNA = currentMutation.poll();
			if(currentDNA.equals(end)) 
				return;
			for(String b:bank){
				if(checkMutation(currentDNA, b)){
					nextMutation.add(b);
				}
			}
		}
		this.numMutations++;
		
		/*
		 *  next step would be to have the next mutation be the current one
		 *  and repeat the process again.
		 *  going from  0 -> 1-> 2 -> etc. mutations 
		 *  until you can reach the end string if possible
		 */
	}
		
		
		
	
	
	public int checkPath() {
		
		/*
		 * base cases
		 */
		if (!endCheck()) {
			this.numMutations = -1;
			return -1;
		}
	
		if (start.equals(end))
			return 0;
		
		mutate();
		
		
		return this.numMutations;
	}

	@Override
	public String toString() {
		return "DNA [start=" + start + ", end=" + end + ", bank=" + Arrays.toString(bank) + ", numMutations="
				+ numMutations + "]";
	}
	
	

}
