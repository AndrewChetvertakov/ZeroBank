package com.zero_bank.utilities;

public class NoElementDefinedException extends RuntimeException{
    public NoElementDefinedException(String element) {
        super("No such element found in PoM. Check your getElement() parameter or define the element: " + element);
    }
}
