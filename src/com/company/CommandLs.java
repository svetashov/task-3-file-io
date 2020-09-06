package com.company;

import java.io.File;
import java.nio.CharBuffer;
import java.util.*;

public class CommandLs implements Command {

    private final static HashMap<String, Boolean> FLAGS = new HashMap<String, Boolean>() {{
        put("r", false);
        put("R", false);
    }};

    @Override
    public int execute(String[] flags, String[] args) {
        for (String flag :
                flags) {
            if (!FLAGS.containsKey(flag))
                throw new IllegalArgumentException("Flag \"-" + flag + "\" is unknown");
            else
                FLAGS.put(flag, true);
        }
        if (args.length > 0)
            throw new IllegalArgumentException("Too much arguments");

        File dir = new File(System.getProperty("user.dir"));
        printFileList(dir, FLAGS.get("R"));

        return 0;
    }

    private String spaces(int spaces) {
        return CharBuffer.allocate(spaces).toString().replace('\0', ' ');
    }

    private void printFullFileListRecursiveHelp(File directory, int level) {
        if (!directory.isDirectory())
            throw new IllegalArgumentException("Argument is not a directory");

        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.sort(files,
                    (f1, f2) -> FLAGS.get("r") ?
                            f2.getName().compareTo(f1.getName()) :
                            f1.getName().compareTo(f2.getName()));

            for (File file : files) {
                System.out.println(spaces(level * 2) + file.getName());
                if (file.isDirectory())
                    printFullFileListRecursiveHelp(file, level + 1);
            }
        }
    }

    private void printFileList(File directory, boolean isRecursive) {
        String[] files;
        if (isRecursive) {
            printFullFileListRecursiveHelp(directory, 0);
        } else {
            files = directory.list();
            if (files != null)
                Arrays.sort(files, (o1, o2) -> FLAGS.get("r") ? o2.compareTo(o1) : o1.compareTo(o2));
            for (String elem :
                    files) {
                System.out.println(elem);
            }
        }

    }
}
