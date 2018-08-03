package oop;

public class Calculator<T> {

	T obj1;
	T obj2;
	
	public Calculator(T obj1, T obj2){
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	public Calculator() {}
	
	public static <T extends Number> T add(T number1, T number2) {
		
		if(number1 instanceof Integer) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Integer(number1.intValue() + number2.intValue());
			return addedValue;
		}
		
		else if(number1 instanceof Double) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Double(number1.doubleValue() + number2.doubleValue());
			return addedValue;
		}
		else if(number1 instanceof Float) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Float(number1.floatValue() + number2.floatValue());
			return addedValue;
		}
		else if(number1 instanceof Byte) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Byte((byte) (number1.byteValue() + number2.byteValue()));
			return addedValue;
		}
		else if(number1 instanceof Short) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Short((short) (number1.shortValue() + number2.shortValue()));
			return addedValue;
		}
		else if(number1 instanceof Long) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Long((Long) (number1.longValue() + number2.longValue()));
			return addedValue;
		}
		
		else {
			throw new IllegalArgumentException("Error adding values."
					+ number1.getClass() + " " + number2.getClass());
		}
	}
	
	public static <T extends Number> T subtract(T number1, T number2) {
		
		if(number1 instanceof Integer) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Integer(number1.intValue() - number2.intValue());
			return addedValue;
		}
		
		else if(number1 instanceof Double) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Double(number1.doubleValue() - number2.doubleValue());
			return addedValue;
		}
		else if(number1 instanceof Float) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Float(number1.floatValue() - number2.floatValue());
			return addedValue;
		}
		else if(number1 instanceof Byte) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Byte((byte) (number1.byteValue() - number2.byteValue()));
			return addedValue;
		}
		else if(number1 instanceof Short) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Short((short) (number1.shortValue() - number2.shortValue()));
			return addedValue;
		}
		else if(number1 instanceof Long) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Long((Long) (number1.longValue() - number2.longValue()));
			return addedValue;
		}
		
		else {
			throw new IllegalArgumentException("Error subtracting values."
					+ number1.getClass() + " " + number2.getClass());
		}
	}
	
	public static <T extends Number> T divide(T number1, T number2) {
		
		if(number1 instanceof Integer) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Integer(number1.intValue() / number2.intValue());
			return addedValue;
		}
		
		else if(number1 instanceof Double) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Double(number1.doubleValue() / number2.doubleValue());
			return addedValue;
		}
		else if(number1 instanceof Float) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Float(number1.floatValue() / number2.floatValue());
			return addedValue;
		}
		else if(number1 instanceof Byte) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Byte((byte) (number1.byteValue() / number2.byteValue()));
			return addedValue;
		}
		else if(number1 instanceof Short) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Short((short) (number1.shortValue() / number2.shortValue()));
			return addedValue;
		}
		else if(number1 instanceof Long) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Long((Long) (number1.longValue() / number2.longValue()));
			return addedValue;
		}
		
		else {
			throw new IllegalArgumentException("Error dividing values."
					+ number1.getClass() + " " + number2.getClass());
		}
	}

	public static <T extends Number> T multiply(T number1, T number2) {
		
		if(number1 instanceof Integer) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Integer(number1.intValue() * number2.intValue());
			return addedValue;
		}
		
		else if(number1 instanceof Double) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Double(number1.doubleValue() * number2.doubleValue());
			return addedValue;
		}
		else if(number1 instanceof Float) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Float(number1.floatValue() * number2.floatValue());
			return addedValue;
		}
		else if(number1 instanceof Byte) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Byte((byte) (number1.byteValue() * number2.byteValue()));
			return addedValue;
		}
		else if(number1 instanceof Short) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Short((short) (number1.shortValue() * number2.shortValue()));
			return addedValue;
		}
		else if(number1 instanceof Long) {
			@SuppressWarnings("unchecked")
			T addedValue = (T) new Long((Long) (number1.longValue() * number2.longValue()));
			return addedValue;
		}
		
		else {
			throw new IllegalArgumentException("Error multiplying values."
					+ number1.getClass() + " " + number2.getClass());
		}
	}
}
