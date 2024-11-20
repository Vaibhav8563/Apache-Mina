package ByteToDataType;

public class ByteArrayToDate {
    public static void main(String[] args) {
        // Given byte array
        byte[] byteArray = {8, 11, 7, -24};

        // 1st byte for Day
        int day = byteArray[0];

        // 2nd byte for Month
        int month = byteArray[1];

     /*  // Last two bytes for Year
        // Using bitwise operations to combine two bytes into an integer
        int year = (byteArray[2] << 8) | (byteArray[3] & 0xFF);
     */
        
        // Combine the 3rd and 4th bytes for Year
        int year = (byteArray[2] * 256) + (byteArray[3] & 0xFF);

        // Display the results
        System.out.println("Day: " + day);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
    }
}