package ByteToDataType;

public class ByteToLong {
	public static void main(String[] args) {
		ToLong obj =new ToLong();
		obj.byteToLong();
		
		ByteArrayToLong obj2 = new ByteArrayToLong();
		obj2.arrToLong();
	}
}

class ToLong {
    public void byteToLong() {
        byte byteValue = 42;
        long longValue = byteValue; // Implicit conversion
        System.out.println("Byte to Long value: " + longValue);
    }
}



 class ByteArrayToLong {
    public void arrToLong() {
        byte[] byteArray = {10, 20, 30, 40};
        long longValue = byteArray[0]; // Implicit casting
        System.out.println("ByteArray to Long value: " + longValue);
    }
 }
