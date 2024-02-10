package ru.ivanov.hangmanGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Dictionary.addWords();
    while (true) {
      System.out.println("Напишите \"да\" если хотите начать новую игру или \"нет\" чтобы выйти из игры");
      Scanner inputDecide = new Scanner(System.in);
      String result = inputDecide.nextLine();
      if (result.equalsIgnoreCase("нет")) {
        break;
      }

      int countMistake = 0;
      char[] word;
      ArrayList<Character> wordForUser = new ArrayList<>();
      ArrayList<Character> mistakeChar = new ArrayList<>();
      String randomWord = Dictionary.randomWord();
      word = randomWord.toCharArray();
      Helper.fillingArray(word, wordForUser);
      System.out.println("Слово загаданно! ");
      while (true) {
        if (Helper.checkResolution(wordForUser)) {
          System.out.println("Победа! Слово: " + Helper.printArray(mistakeChar));
          break;
        }
        if (countMistake != 7) {
          System.out.println("Слово: " + Helper.printArray(wordForUser));
          System.out.println("Ошибки " + "(" + countMistake + ")" + ": " + Helper.printArray(mistakeChar));
          System.out.println("Введите букву: ");

          Scanner scannerInputChar = new Scanner(System.in);
          String charInput = scannerInputChar.nextLine();
          char charUser = charInput.charAt(0);

          if (Helper.findCharAndCounterMistake(word, wordForUser, charUser) == 0) {
            mistakeChar.add(charUser);
            countMistake++;
          }
        } else {
          System.out.println("Вы проиграли =(");
          break;
        }

      }

    }
  }
}