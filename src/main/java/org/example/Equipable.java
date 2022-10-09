package org.example;

@SuppressWarnings("SpellCheckingInspection")
public interface Equipable {
    boolean canBeEquippedBy(Player player);
    boolean isCompatibleWith(Equipable equipable);
}
