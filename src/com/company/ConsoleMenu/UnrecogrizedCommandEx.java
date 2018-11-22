package com.company.ConsoleMenu;

import java.lang.Exception;

public class UnrecogrizedCommandEx extends Exception {
    UnrecogrizedCommandEx(String message) {
        super(message);
    }
}
