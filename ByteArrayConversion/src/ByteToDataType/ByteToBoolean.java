package ByteToDataType;

public class ByteToBoolean {

	public static void main(String[] args) {
		ToBoolean obj = new ToBoolean();
				  obj.byteToBoolean();
		ByteArrayToBooleanArray obj2 = new ByteArrayToBooleanArray();
				obj2.arrToBooleanArr();

	}

}



class ToBoolean {
    public void byteToBoolean() {
        byte byteValue = 1;
        boolean boolValue = byteValue != 0; // Non-zero byte is considered true
        System.out.println("Byte to Boolean value: " + boolValue);
    }
}


class ByteArrayToBooleanArray {
    public void arrToBooleanArr() {
        byte[] byteArray = {1, 0, -1, 0}; // Example values
        boolean[] booleanArray = new boolean[byteArray.length];

        for (int i = 0; i < byteArray.length; i++) {
            booleanArray[i] = byteArray[i] != 0;
        }

        for (boolean boolValue : booleanArray) {
            System.out.println("Boolean value: " + boolValue);
        }
    }
}