package org.example;

public class CannotEquipException extends IllegalStateException{
    public CannotEquipException(String message) {
        super(message);
    }
}
