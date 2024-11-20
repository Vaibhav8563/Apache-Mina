package ByteToDataType;

public class ByteToChar {
    public static void main(String[] args) {
        ToChar obj = new ToChar();
        obj.byteToChar();
        
        ByteArrayToCharArray obj2 = new ByteArrayToCharArray();
        obj2.arrToCharArray();
    }
}

class ToChar{
	public void byteToChar() {
		byte byteValue = 65; // ASCII code for 'A'
        char charValue = (char) byteValue; // Explicit casting
        System.out.println("Byte to Character value: " + charValue);
	}
}


class ByteArrayToCharArray {
    public void arrToCharArray() {
        byte[] byteArray = {65, 66, 67, 68}; // ASCII values for "ABCD"
        char[] charArray = new char[byteArray.length];

        for (int i = 0; i < byteArray.length; i++) {
            charArray[i] = (char) byteArray[i];
        }

        System.out.println("Character array: " + String.valueOf(charArray));
    }
}