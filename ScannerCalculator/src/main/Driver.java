package main;

import oop.Calculator;
import java.util.Scanner;
public class Driver {


	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		Scanner reader = new Scanner(System.in);
		
		// get operation
		Boolean validInput = false;
		String operand = new String();
		while(!validInput) {
			System.out.println("Enter the operation.('+','-','/','*')");
			operand = reader.next();
			//reader.close();
			switch(operand) {
				case "+": case "-": case "/": case "*": 
					validInput = true;
					break;
				default: 
					System.out.println("Please enter a valid input");
					
			
			}
		}
		
		validInput = false;
		String type = new String();
		while(!validInput) {
			System.out.println("Enter the type of number.(byte, short, int, long, float, double).");
			type = reader.next();
			type = type.toLowerCase();
	
			switch(type) {
				case "byte": case "short": case "int": case "long": case "float": case "double": 
					validInput = true;
					break;
				default: 
					System.out.println("Please enter a valid input");
					
			
			}
		}
		
		validInput = false;
		String number1 = new String();
		String number2 = new String();
		Byte byteNumber1 = 0, byteNumber2 = 0;
		Short shortNumber1 = 0, shortNumber2 = 0;
		Integer intNumber1 = 0 , intNumber2 = 0;
		Long longNumber1 = (long) 0.0, longNumber2 = (long) 0.0;
		Float floatNumber1 = (float) 0.0, floatNumber2 = (float) 0.0;
		Double doubleNumber1 = 0.0, doubleNumber2 = 0.0;
		
		while(!validInput) {
			System.out.println("Enter number1");
			number1 = reader.next();
			System.out.println("Enter number2");
			number2 = reader.next();
			
	
			switch(type) {
				case "byte": 
					try {
						byteNumber1 = Byte.parseByte(number1);
						byteNumber2 = Byte.parseByte(number2);
						validInput = true;
						
					}catch (Exception e){
						System.out.println("Please enter valid input");
						validInput = false;
					}
					
					break;
				case "short":
					try {
						shortNumber1 = Short.parseShort(number1);
						shortNumber2 = Short.parseShort(number2);
						validInput = true;
						
					}catch (Exception e){
						System.out.println("Please enter valid input");
						validInput = false;
					}
					
					break;
				case "int": 
					try {
						intNumber1 = Integer.parseInt(number1);
						intNumber2 = Integer.parseInt(number2);
						validInput = true;
						
					}catch (Exception e){
						System.out.println("Please enter valid input");
						validInput = false;
					}
					
					break;
				case "long": 
					try {
						longNumber1 = Long.parseLong(number1);
						longNumber2 = Long.parseLong(number2);
						validInput = true;
						
					}catch (Exception e){
						System.out.println("Please enter valid input");
						validInput = false;
					}
					
					break;
				case "float": 
					try {
						floatNumber1 = Float.parseFloat(number1);
						floatNumber2 = Float.parseFloat(number2);
						validInput = true;
						
					}catch (Exception e){
						System.out.println("Please enter valid input");
						validInput = false;
					}
					
					break;
				case "double": 
					try {
						doubleNumber1 = Double.parseDouble(number1);
						doubleNumber2 = Double.parseDouble(number2);
						validInput = true;
						
					}catch (Exception e){
						System.out.println("Please enter valid input");
						validInput = false;
					}
					
					break;
				default: 
					System.out.println("Please enter a valid input");
			
			}
	
		}
		
		switch (operand) {
			case "+": 
				switch(type) {
					case "byte":
						System.out.println(calc.add(byteNumber1, byteNumber2));
						break;
					case "short":
						System.out.println(calc.add(shortNumber1, shortNumber2));
						break;
					case "int":
						System.out.print(calc.add(intNumber1, intNumber2));
						break;
					case "long":
						System.out.println(calc.add(longNumber1, longNumber2));
						break;
					case "float":
						System.out.print(calc.add(floatNumber1, floatNumber2));
						break;
					case "double":
						System.out.print(calc.add(doubleNumber1, doubleNumber2));
						break;
				}
				break;
				
			case "-":
				switch(type) {
				case "byte":
					System.out.println(calc.subtract(byteNumber1, byteNumber2));
					break;
				case "short":
					System.out.println(calc.subtract(shortNumber1, shortNumber2));
					break;
				case "int":
					System.out.print(calc.subtract(intNumber1, intNumber2));
					break;
				case "long":
					System.out.println(calc.subtract(longNumber1, longNumber2));
					break;
				case "float":
					System.out.print(calc.subtract(floatNumber1, floatNumber2));
					break;
				case "double":
					System.out.print(calc.subtract(doubleNumber1, doubleNumber2));
					break;
				}
				break;
			case "/": 
				switch(type) {
				case "byte":
					System.out.println(calc.divide(byteNumber1, byteNumber2));
					break;
				case "short":
					System.out.println(calc.divide(shortNumber1, shortNumber2));
					break;
				case "int":
					System.out.print(calc.divide(intNumber1, intNumber2));
					break;
				case "long":
					System.out.println(calc.divide(longNumber1, longNumber2));
					break;
				case "float":
					System.out.print(calc.divide(floatNumber1, floatNumber2));
					break;
				case "double":
					System.out.print(calc.divide(doubleNumber1, doubleNumber2));
					break;
				}
				break;
			case "*": 
				switch(type) {
				case "byte":
					System.out.println(calc.multiply(byteNumber1, byteNumber2));
					break;
				case "short":
					System.out.println(calc.multiply(shortNumber1, shortNumber2));
					break;
				case "int":
					System.out.print(calc.multiply(intNumber1, intNumber2));
					break;
				case "long":
					System.out.println(calc.multiply(longNumber1, longNumber2));
					break;
				case "float":
					System.out.print(calc.multiply(floatNumber1, floatNumber2));
					break;
				case "double":
					System.out.print(calc.multiply(doubleNumber1, doubleNumber2));
					break;
				}
				break;
			default: 
			System.out.println("Please enter a valid input");
			break;
		
		}
	}
}
