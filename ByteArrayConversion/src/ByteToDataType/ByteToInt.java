package ByteToDataType;

public class ByteToInt {
    public static void main(String[] args) {
       byteint obj = new byteint();
       			obj.byteToInt();
       bytearray obj2 = new bytearray();
       			obj2.arrToInt();
       ByteArrayToIntArray obj3 = new ByteArrayToIntArray();
       			obj3.arrToIntArr();
    }
}

class byteint{
	public void byteToInt(){
		 byte byteValue = -24;
	        int intValue = Byte.toUnsignedInt(byteValue); // Converts byte to an unsigned int
	        System.out.println("Byte to Integer value: " + intValue);
	}
}

class bytearray{
	public void arrToInt(){
		 byte[] byteArray = {10, 20, 30, 40};
	        int intValue = byteArray[0]; // Implicit casting
	        System.out.println("ByteArray to Integer value: " + intValue);
	}
}


class ByteArrayToIntArray {
    public void arrToIntArr() {
        byte[] byteArray = {10, 20, 30, 40};
        int[] intArray = new int[byteArray.length];

        for (int i = 0; i < byteArray.length; i++) {
            intArray[i] = byteArray[i];
        }

        for (int intValue : intArray) {
            System.out.println("Integer value: " + intValue);
        }
    }
}

