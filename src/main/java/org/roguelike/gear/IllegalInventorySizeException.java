package org.roguelike.gear;

public class IllegalInventorySizeException extends IllegalStateException{
    public IllegalInventorySizeException(String arg) {
        super(arg);
    }
}
