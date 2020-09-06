package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CommandEcho implements Command {
    @Override
    public int execute(String[] flags, String[] args) {
        if (flags.length > 0)
            throw new IllegalArgumentException("Too much flags");
        if (args.length < 2) throw new IllegalArgumentException("2 arguments required");
        if (args.length > 2) throw new IllegalArgumentException("Too much arguments");

        try {
            File file = new File(System.getProperty("user.dir") + File.separator + args[1]);
            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(args[0]);
                fileWriter.flush();
            } else throw new IllegalArgumentException("File already exists");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
