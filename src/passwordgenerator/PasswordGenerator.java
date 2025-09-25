package passwordgenerator;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static String generatePassword(int length) {
        Random rnd = new SecureRandom();
        int len = Math.max(length, 4);

        char[] pwd = new char[len];
        pwd[0] = (char)('A' + rnd.nextInt(26));
        pwd[1] = (char)('a' + rnd.nextInt(26));
        pwd[2] = (char)('0' + rnd.nextInt(10));
        pwd[3] = (char)(33 + rnd.nextInt(15));

        for (int i = 4; i < len; i++) {
            int cat = rnd.nextInt(4);
            pwd[i] = switch(cat) {
                case 0 -> (char)('A' + rnd.nextInt(26));
                case 1 -> (char)('a' + rnd.nextInt(26));
                case 2 -> (char)('0' + rnd.nextInt(10));
                default -> (char)(33 + rnd.nextInt(15));
            };
        }
        for (int i = 0; i < len; i++) {
            int j = rnd.nextInt(len);
            char t = pwd[i]; pwd[i] = pwd[j]; pwd[j] = t;
        }

        return new String(pwd);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину пароля (от 8 до 12): ");
        int length = scanner.nextInt();
        // проверку на длину не добавлял

        String password = generatePassword(length);
        System.out.println("Сгенерированный пароль: " + password);
    }
}