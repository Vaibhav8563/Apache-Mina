package ByteToDataType;


/*
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class XmlByteConversion {

    // Define the XML file path
    private static final String XML_FILE_PATH = "C:\\Users\\VaibhavGupta\\Documents\\VaibhavWorkspaceEclipse\\ByteArrayConversion\\src\\Resources\\employee_bank_details.xml";

    // Method to convert XML file content to byte array
    public static byte[] xmlToByteArray(File xmlFile) {
        byte[] byteArray = null;
        try {
            // Read file content into byte array
            byteArray = Files.readAllBytes(xmlFile.toPath());

            // Print byte array in the desired format
            System.out.println("Byte Array:");
            System.out.println(Arrays.toString(byteArray));
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
        return byteArray;
    }

    // Method to convert byte array back to XML string
    public static String byteArrayToXml(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        // Convert byte array back to XML String
        return new String(byteArray, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        // Create a File object with the specified XML file path
        File xmlFile = new File(XML_FILE_PATH);

        // Check if the XML file exists
        if (!xmlFile.exists()) {
            System.out.println("XML file not found at: " + XML_FILE_PATH);
            return;
        }

        // Convert XML to byte array
        byte[] byteArray = xmlToByteArray(xmlFile);

        // Convert byte array back to XML string and print
        String xmlContent = byteArrayToXml(byteArray);
        System.out.println("Reconstructed XML from Byte Array:");
        System.out.println(xmlContent);
    }
}



*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class XmlByteConversion {

    // Define the XML file path
    private static final String XML_FILE_PATH = "C:\\Users\\VaibhavGupta\\Documents\\VaibhavWorkspaceEclipse\\ByteArrayConversion\\src\\Resources\\employee_bank_details.xml";

    public static void main(String[] args) {
        // Create a File object with the specified XML file path
        File xmlFile = new File(XML_FILE_PATH);

        // Check if the XML file exists
        if (!xmlFile.exists()) {
            System.out.println("XML file not found at: " + XML_FILE_PATH);
            return;
        }

        try {
            // Read file content into byte array
            byte[] byteArray = Files.readAllBytes(xmlFile.toPath());

            // Print byte array in the desired format
            System.out.print("Byte Array: ");
            for (byte b : byteArray) {
                System.out.print(b + " ");
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        }
    }
}

