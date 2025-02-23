import java.util.Scanner;

public class SimpleCipher {

    public static String caesarCipher(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        shift = encrypt ? shift : -shift;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (base + (c - base + shift + 26) % 26));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String vigenereCipher(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        key = key.toLowerCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shift = key.charAt(keyIndex) - 'a';
                shift = encrypt ? shift : -shift;
                result.append((char) (base + (c - base + shift + 26) % 26));
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the cipher method:");
        System.out.println("1. Caesar Cipher");
        System.out.println("2. Vigenère Cipher");
        int cipherChoice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Do you want to encrypt or decrypt? (e for encrypt / d for decrypt):");
        char action = scanner.nextLine().charAt(0);

        if (cipherChoice == 1) {
            if (action == 'e' || action == 'E') {
                System.out.println("Enter the PlainText:");
                String plainText = scanner.nextLine();

                System.out.println("Enter the shift value (integer):");
                int shift = scanner.nextInt();
                scanner.nextLine(); 

                String cipherText = caesarCipher(plainText, shift, true);
                System.out.println("CipherText: " + cipherText);
            } else if (action == 'd' || action == 'D') {
                System.out.println("Enter the CipherText:");
                String cipherText = scanner.nextLine();

                System.out.println("Enter the shift value :");
                int shift = scanner.nextInt();
                scanner.nextLine(); 

                String decryptedText = caesarCipher(cipherText, shift, false);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Invalid choice!");
            }
        } else if (cipherChoice == 2) {
            if (action == 'e' || action == 'E') {
                System.out.println("Enter the PlainText:");
                String plainText = scanner.nextLine();

                System.out.println("Enter the key:");
                String key = scanner.nextLine();

                String cipherText = vigenereCipher(plainText, key, true);
                System.out.println("CipherText: " + cipherText);
            } else if (action == 'd' || action == 'D') {
                System.out.println("Enter the CipherText:");
                String cipherText = scanner.nextLine();

                System.out.println("Enter the key:");
                String key = scanner.nextLine();

                String decryptedText = vigenereCipher(cipherText, key, false);
                System.out.println("Decrypted Text: " + decryptedText);
            } else {
                System.out.println("Invalid choice!");
            }
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}