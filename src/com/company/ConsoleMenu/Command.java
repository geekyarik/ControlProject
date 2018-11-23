package com.company.ConsoleMenu;

public enum Command {
    COMMANDS("commands"),
    ADD("add"),
    REMOVE("remove"),
    SEARCH("search"),
    PRICE("price"),
    LIST("list"),
    SORT("sort"),
    EXIT("exit"),
    CONSOLE("console"),
    FILE("file");

    final String comText;

    Command(String comText) {
        this.comText = comText;
    }

    final String getComText() {
        return this.comText;
    }

    @Override
    public String toString() {
        return "Operation text is '"
                + this.comText + "'";
    }
}
