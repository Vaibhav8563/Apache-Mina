package ByteToDataType;

public class ByteToFloat {

	public static void main(String[] args) {
		ToFloat obj = new ToFloat();
		obj.byteToFloat();

	}

}


class ToFloat {
    public void byteToFloat() {
	byte byteValue = 42;
        float floatValue = byteValue; // Implicit conversion
        System.out.println("Byte to Float value: " + floatValue);
    }
}


class ByteArrayToFloat {
		public void arrToFloat() {
			byte[] byteArray = {10, 20, 30, 40};
			float floatValue = byteArray[0]; // Implicit casting
				System.out.println("ByteArray to Float value: " + floatValue);
    }
}