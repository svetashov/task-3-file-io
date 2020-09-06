package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            String[] answer = CommandHandler.handle(args);
            for (String word : answer) {
                System.out.println(word);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
