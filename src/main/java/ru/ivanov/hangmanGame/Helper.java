package ru.ivanov.hangmanGame;

import java.util.ArrayList;

public class Helper {

    public static void fillingArray(char[] word, ArrayList<Character> characters) {
        for (int i = 0; i < word.length; i++) {
            char j = 95;
            characters.add(j);
        }
    }

    public static String printArray(ArrayList<Character> characters) {
        String arrayChar = "";
        for (Character i : characters) {
            //System.out.print(i);
            arrayChar = arrayChar + "" + i;
        }
        return arrayChar;
    }

    public static int findCharAndCounterMistake(char[] word, ArrayList<Character> characters, char charUser) {
        int count = 0;
        for (int i = 0; i < word.length; i++) {
            if (charUser == word[i]) {
                characters.set(i, word[i]);
                count++;
            }
        }
        return count;
    }

    public static Boolean checkResolution(ArrayList<Character> characters) {
        int count = 0;
        for (Character i : characters) {
            if (i.charValue() == 95) {
                count++;
            }
        }

        if (count == 0) {
            return true;
        }
        return false;
    }

    public static Boolean checkCharInMistakes(ArrayList<Character> characters, char chatUser) {
        return characters.contains(chatUser);
    }
}
