package com.company;

public interface Command {
    /**
     * Выполняет команду и возвращает ответ
     *
     *
     * @param flags
     * @param args Аргументы команды и флаги
     * @return Ответ команды либо сообщение об ошибке в команде
     */
    public String[] execute(String[] flags, String[] args);
}
