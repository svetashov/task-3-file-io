package com.company;

public class Main {

    public static void main(String[] args) {
        try {
            CommandHandler.handle(args);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
