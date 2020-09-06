package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandHandler {

    public static int handle(String[] args) {

        if (args.length == 0)
            throw new IllegalArgumentException("Command not found.");
        else {
            Command command;
            switch (args[0]) {
                case "ls":
                    command = new CommandLs();
                    break;
                case "mkdir":
                    command = new CommandMkdir();
                    break;
                case "echo":
                    command = new CommandEcho();
                    break;
                default:
                    throw new IllegalArgumentException("\"" + args[0] + "\" not a command.");
            }

            args = Arrays.copyOfRange(args, 1, args.length);
            return command.execute(getFlags(args), getArguments(args));
        }

    }

    public static String[] getArguments(String[] in) {
        ArrayList<String> arguments = new ArrayList<>();
        for (String elem : in) {
            if (!elem.startsWith("-")) {
                arguments.add(elem);
            }
        }

        return arguments.toArray(new String[0]);
    }

    public static String[] getFlags(String[] in) {
        ArrayList<String> flags = new ArrayList<>();
        for (String elem : in) {
            if (elem.startsWith("-")) {
                flags.add(elem.substring(1));
            }
        }

        return flags.toArray(new String[0]);
    }
}
