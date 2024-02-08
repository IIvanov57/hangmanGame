package ru.ivanov.hangmanGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            System.out.println("Напишите \"да\" если хотите начать игру или \"нет\" чтобы выйти из игры");
            Scanner inputDecide = new Scanner(System.in);
            String result = inputDecide.nextLine();
            if (result.equalsIgnoreCase("нет")){
                break;
            }

        }
    }
}