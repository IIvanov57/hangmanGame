package ru.ivanov.hangmanGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //заполняем словарь
    Dictionary.addWords();

    //начало игры
    while (true) {
      System.out.println("Напишите \"да\" если хотите начать новую игру или \"нет\" чтобы выйти из игры");
      Scanner inputDecide = new Scanner(System.in);
      String result = inputDecide.nextLine();
      if (result.equalsIgnoreCase("нет")) {
        break;
      }

      int countMistake = 0;
      //массив для загаданного слова
      char[] word;
      //список из букв, котрые отгадал игрок
      ArrayList<Character> wordForGamer = new ArrayList<>();
      //спписок куда будем складывать буквы, которых нет в загаданном слове
      ArrayList<Character> mistakeChar = new ArrayList<>();
      //рандомно выбираем солово из словоря
      String randomWord = Dictionary.randomWord();
      word = randomWord.toCharArray();
      Helper.fillingArray(word, wordForGamer);
      System.out.println("Слово загаданно! ");
      while (true) {
        if (Helper.checkResolution(wordForGamer)) {
          System.out.println("Победа! Слово: " + Helper.printArray(mistakeChar));
          break;
        }
        if (countMistake != 7) {
          System.out.println("Слово: " + Helper.printArray(wordForGamer));
          System.out.println("Ошибки " + "(" + countMistake + ")" + ": " + Helper.printArray(mistakeChar));
          System.out.println("Введите букву: ");

          Scanner scannerInputChar = new Scanner(System.in);
          String charInput = scannerInputChar.nextLine();
          if (charInput.length() > 1){
            System.out.println("Введите одину букву!");
            continue;
          }
          char charUser = charInput.charAt(0);

          if (Helper.findCharAndCounterMistake(word, wordForGamer, charUser) == 0) {
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