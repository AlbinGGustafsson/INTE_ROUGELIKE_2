package org.roguelike.gear;

public class CannotEquipException extends IllegalStateException{
    public CannotEquipException(String message) {
        super(message);
    }
}
