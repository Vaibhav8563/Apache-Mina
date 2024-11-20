package ByteToDataType;

public class ByteToShort {

	public static void main(String[] args) {
		ToShort obj = new ToShort();
		obj.byteToShort();

	}

}


class ToShort {
    public void byteToShort() {
        byte byteValue = 42;
        short shortValue = byteValue; // Implicit conversion
        System.out.println("Byte to Short value: " + shortValue);
    }
}