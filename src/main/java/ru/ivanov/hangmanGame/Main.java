package ru.ivanov.hangmanGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //заполняем словарь
    Dictionary.addWords();

    //начало игры
    while (true) {
      System.out.println("Напишите \"да\", если хотите начать новую игру или \"нет\", чтобы выйти из игры");
      Scanner inputDecide = new Scanner(System.in);
      String result = inputDecide.nextLine();
      if (result.equalsIgnoreCase("нет")) {
        break;
      } else if (!result.equalsIgnoreCase("да")) {
        System.out.println("Введите \"да\"  или \"нет\"");
        continue;
      }

      int countMistake = 0;
      //массив для загаданного слова
      char[] word;
      //список из букв, которые отгадал игрок
      ArrayList<Character> wordForGamer = new ArrayList<>();
      //список куда будем складывать буквы, которых нет в загаданном слове
      ArrayList<Character> mistakeChar = new ArrayList<>();
      //рандомно выбираем солово из словаря
      String randomWord = Dictionary.randomWord();
      word = randomWord.toCharArray();
      Helper.fillingArray(word, wordForGamer);
      //для теста
      //System.out.println(randomWord);
      System.out.println("Слово загадано! ");
      while (true) {
        if (Helper.checkResolution(wordForGamer)) {
          System.out.println("Победа! Слово: " + Helper.getWord(wordForGamer));
          break;
        }
        if (countMistake != 7) {
          System.out.println("Слово: " + Helper.getWord(wordForGamer));
          System.out.println("Ошибки " + "(" + countMistake + ")" + ": " + Helper.getWord(mistakeChar));
          System.out.println("Введите букву: ");

          Scanner scannerInputChar = new Scanner(System.in);
          String charInput = scannerInputChar.nextLine();

          //блок валидации вводимого символа
          // (проверяем символ не число, не больше одного символа, символ является кириллицей)
          if (charInput.length() > 1) {
            System.out.println("Введите одну букву!");
            continue;
          } else if (!Character.isLetter(charInput.charAt(0)) ||
                  !(Character.UnicodeBlock.of(charInput.charAt(0)) == Character.UnicodeBlock.CYRILLIC)) {
            System.out.println("Введите русскую букву!");
            continue;
          }
          //берем символ
          char charUser = charInput.toLowerCase().charAt(0);

          //считаем кол-во ошибок и добавляем не верные попытки в список mistakeChar
          if (Helper.findChar(word, wordForGamer, charUser) == 0
                  && !Helper.checkCharInMistakes(mistakeChar, charUser)) {

            mistakeChar.add(charUser);
            countMistake++;
          }
        } else {
          System.out.println("Вы проиграли =(");
          System.out.println("Правильное слово: " + randomWord);
          break;
        }

      }

    }
  }
}