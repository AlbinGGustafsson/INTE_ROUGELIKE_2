package org.example;

@SuppressWarnings("SpellCheckingInspection")
public interface Equipable extends Comparable<Equipable> {
    boolean canBeEquippedBy(Player player);
    boolean isCompatibleWith(Equipable equipable);
    int maxNumberOfSameTypeEquips();
}
