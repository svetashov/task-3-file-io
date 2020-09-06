package com.company;

public interface Command {
    /**
     * Выполняет команду и возвращает ответ
     *
     *
     * @param flags
     * @param args Аргументы команды и флаги
     * @return Код ошибки, 0 если ошибки нет
     */
    public int execute(String[] flags, String[] args);
}
