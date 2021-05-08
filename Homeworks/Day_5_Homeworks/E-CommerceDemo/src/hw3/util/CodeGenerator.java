package hw3.util;

import java.util.Random;

public class CodeGenerator {
	private final static String value = "ABCDEFGHIKLMNOPQRSTUVWXYZ" +
			"abcdefghiklmnopqrstuvwxyz" +
			"0123456789";
	
	public static String generateCode(int length) {
		Random random = new Random();
		char[] characters = new char[length];
		
		for(int i = 0; i < characters.length; i++) {
			characters[i] = value.charAt(random.nextInt(value.length()));
		}
		return String.valueOf(characters);
	}
}
