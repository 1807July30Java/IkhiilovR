package com.revature.oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

	private ArrayList<String> start;
	private ArrayList<String> end;
	private ArrayList<String[]> bank;
	private int lines;
	
	public ReadFile(File file){
		start = new ArrayList<String>();
		end = new ArrayList<String>();
		bank = new ArrayList<String[]>();
		lines = 0;
		
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
//				System.out.println(reader.nextLine().split(";"));
				String line = reader.nextLine();
//				System.out.println(line.split(";"));
				String[] words = line.split(";");
//				System.out.println(words[0]);
				start.add(words[0]);
				end.add(words[1]);
				String[] splitBanks = words[2].split("\\,");
				bank.add(splitBanks);
				lines++;
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getStart(int index) {
		return start.get(index);
	}

	public String getEnd(int index) {
		return end.get(index);
	}

	public String[] getBank(int index) {
		return bank.get(index);
	}

	public int getLines() {
		return lines;
	}	
	
	
	

}
