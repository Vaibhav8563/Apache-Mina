package ByteToDataType;

public class ByteToDouble {

	public static void main(String[] args) {
		ToDouble obj = new ToDouble();
		obj.byteToDouble();
		
		ByteArrayToDouble obj2 = new ByteArrayToDouble();
		obj2.arrToDouble();
		
		
	}

}


class ToDouble {
    public void byteToDouble() {
	byte byteValue = 42;
        double doubleValue = byteValue; // Implicit conversion
        System.out.println("Byte to Double value: " + doubleValue);
    }
}

class ByteArrayToDouble {
    public void arrToDouble() {
        byte[] byteArray = {10, 20, 30, 40};
        double doubleValue = byteArray[0]; // Implicit casting
        System.out.println("Double value: " + doubleValue);
    }
}