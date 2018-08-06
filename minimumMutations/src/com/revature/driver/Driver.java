package com.revature.driver;

import java.io.File;
import java.util.ArrayList;

import com.revature.oop.DNA;
import com.revature.oop.ReadFile;

public class Driver {

	public static void main(String[] args) {
		File file = new File("/Users/MarkIkhilov/Desktop/Ramin Docs/Revature/Spring Tools/minimumMutations/src/com/revature/driver/data.txt");
		ReadFile input = new ReadFile(file);
		ArrayList<DNA> dna = new ArrayList<DNA>();
		
		for (int i = 0; i < input.getLines(); i++) {
			DNA temp = new DNA(input.getStart(i), input.getEnd(i), input.getBank(i));
			dna.add(temp);
			System.out.println(temp);
		}
	}

}
