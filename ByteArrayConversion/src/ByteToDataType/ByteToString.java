package ByteToDataType;

public class ByteToString {
	public static void main(String[] args) {
		ToString obj = new ToString();
		obj.byteToString();
		
		ByteArrayToString obj2 = new ByteArrayToString();
		obj2.arrToString();
	}
}



class ToString{
	public void byteToString() {
		byte byteValue = 42;
        String stringValue = Byte.toString(byteValue);
        System.out.println("Byte to String value: " + stringValue);
    }
}

class ByteArrayToString {
    public void arrToString() {
        byte[] byteArray = {65, 66, 67, 68}; // ASCII values for "ABCD"
        String stringValue = new String(byteArray);
        System.out.println("String value: " + stringValue);
    }
}