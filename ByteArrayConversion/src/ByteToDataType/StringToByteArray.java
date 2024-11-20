package ByteToDataType;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringToByteArray {
	
	    public static void main(String[] args) {
	        // Example byte array
	        byte[] byteArray = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100}; // "Hello World"

	        // 1. Convert byte array to String
	        String convertedString = new String(byteArray, StandardCharsets.UTF_8);
	        System.out.println("Converted String: " + convertedString);

	        // 2. Convert String back to byte array
	        String str = "I am Vaibhav Gupta";
	        byte[] newByteArray = str.getBytes(StandardCharsets.UTF_8);
	        System.out.println();

	        // Print the resulting byte array
	        System.out.println("Converted Byte Array: " + Arrays.toString(newByteArray));
	    }
	}