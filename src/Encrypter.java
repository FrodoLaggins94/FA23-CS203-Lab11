import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
    	String content = readFile(inputFilePath);
        char[] charArray = content.toCharArray();

        StringBuilder encryptedText = new StringBuilder();

        for (char currentChar : charArray) {
            if (Character.isLetter(currentChar)) {
                char encryptedChar = encryptChar(currentChar);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(currentChar);
            }
        }

        writeFile(encryptedText.toString(), encryptedFilePath);
    }

   

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
    	String content = readFile(messageFilePath);
        char[] charArray = content.toCharArray();

        StringBuilder decryptedText = new StringBuilder();

        for (char currentChar : charArray) {
            if (Character.isLetter(currentChar)) {
                char decryptedChar = decryptChar(currentChar);
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }

        writeFile(decryptedText.toString(), decryptedFilePath);
    }
    
    /**
     * Encrypts a single character using the Caesar cipher.
     *
     * @param inputChar the character to be encrypted
     * @return the encrypted character
     */
    
    private char encryptChar(char inputChar) {
    	if (Character.isUpperCase(inputChar)) {
            return (char) ((inputChar - 'A' + shift) % 26 + 'A');
        } else if (Character.isLowerCase(inputChar)) {
            return (char) ((inputChar - 'a' + shift) % 26 + 'a');
        } else {
            return inputChar;
        }
    
    }
    
    /**
     * Decrypts a single character using the Caesar cipher.
     *
     * @param inputChar the character to be decrypted
     * @return the decrypted character
     */
    
    private char decryptChar(char inputChar) {
    	if (Character.isUpperCase(inputChar)) {
            return (char) ((inputChar - 'A' - shift + 26) % 26 + 'A');
        } else if (Character.isLowerCase(inputChar)) {
            return (char) ((inputChar - 'a' - shift + 26) % 26 + 'a');
        } else {
            return inputChar;
        }
    
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        try (Scanner fileScanner = new Scanner(Paths.get("encrypted.txt"))){
        	while(fileScanner.hasNextLine()) {
        		String line = fileScanner.nextLine();
        		
        try (Scanner fileScanner1 = new Scanner(Paths.get("encryptMe.txt"))){
             while(fileScanner1.hasNextLine()) {
            	 String line1 = fileScanner1.nextLine();   
        	}
        	fileScanner1.close(); 
        }catch (Exception e) {
        	System.out.println("Error: " + e.toString());
        }
        return message;
        	}}
		return message;
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     * @throws FileNotFoundException 
     */
    private static void writeFile(String data, String filePath) throws FileNotFoundException {
    	try (PrintWriter output = new PrintWriter("decrypted.txt")){
    		output.println();
    		output.close(); 
    		
    		try (PrintWriter output1 = new PrintWriter("newEncrypted.txt")){
        		output1.println();
        		output1.close(); 
    	
    		} catch (Exception e) {
    		System.out.println("Error: "+ e.toString());	
    		}
    	}
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
