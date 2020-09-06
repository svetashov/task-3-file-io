package com.company;

import java.io.File;
import java.util.Arrays;

public class CommandMkdir implements Command {
    @Override
    public int execute(String[] flags, String[] args) {
        if (flags.length > 0)
            throw new IllegalArgumentException("Too much flags");
        if (args.length == 0)
            throw new IllegalArgumentException("Directory name not found");
        if (args.length > 1)
            throw new IllegalArgumentException("Too much arguments");

        File directory = new File(System.getProperty("user.dir") + File.separator + args[0]);
        if (directory.exists())
            throw new IllegalArgumentException("Directory " + args[0] + " already exists");
        directory.mkdir();

        return 0;
    }
}
