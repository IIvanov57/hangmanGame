package ru.ivanov.hangmanGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Dictionary {
  public static ArrayList<String> words = new ArrayList<>();

  public static void addWords() {
    //File file = new File("src\\main\\java\\resources");
    try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\java\\resources\\russian_nouns.txt"))) {
      String wordLine = reader.readLine();

      while (wordLine != null || words.size() == 100) {
        // System.out.println(wordLine);
        //проверяем что слово не короткое и добавляем в список
        if (wordLine.length() > 5 && wordLine.length() < 8) {
          words.add(wordLine);
        }

        //читаем следующий слово
        wordLine = reader.readLine();
      }


    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //метод для получения рандомного слова
  public static String randomWord() {
    int index = (int) (Math.random() * words.size());

    return words.get(index);
  }
}
