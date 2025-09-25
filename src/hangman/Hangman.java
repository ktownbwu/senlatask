package hangman;

import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"Array", "String", "chaR", "integer", "bOOlean"};

        String wordToGuess = words[new Random().nextInt(words.length)].toLowerCase(Locale.ROOT);
        char[] currentState = "_".repeat(wordToGuess.length()).toCharArray();
        int attempts = 6;
        Set<Character> guessedLetters = new HashSet<>();

        while (attempts > 0 && new String(currentState).contains("_")) {

            System.out.println("Слово: " + String.join(" ", new String(currentState).split("")));
            System.out.println("Попытки: " + attempts);
            System.out.println("Уже пробованные буквы: " + guessedLetters);

            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.length() != 1) {
                System.out.println("Введите только одну букву!");
                continue;
            }
            char guessedChar = input.charAt(0);

            if (guessedLetters.contains(guessedChar)) {
                System.out.println("Вы уже пробовали эту букву!");
                continue;
            }

            guessedLetters.add(guessedChar);

            boolean found = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedChar) {
                    currentState[i] = guessedChar;
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println("Нет такой буквы!");
            }
        }

        if (new String(currentState).equals(wordToGuess)) {
            System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("Вы проиграли. Слово было: " + wordToGuess);
        }

        scanner.close();
    }
}
