package ru.ivanov.hangmanGame;

import java.util.ArrayList;

public class Helper {
    //символ нижнего подчеркивания
    private static final char UNDERSCORE_CHAR = 95;

    public static void fillingArray(char[] word, ArrayList<Character> characters) {
        for (int i = 0; i < word.length; i++) {
            characters.add(UNDERSCORE_CHAR);
        }
    }

    public static String getWord(ArrayList<Character> characters) {
        StringBuilder arrayChar = new StringBuilder();
        for (Character i : characters) {
            arrayChar.append(i);
        }
        return arrayChar.toString();
    }

    public static int findChar(char[] word, ArrayList<Character> characters, char charUser) {
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
            if (i == UNDERSCORE_CHAR) {
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
