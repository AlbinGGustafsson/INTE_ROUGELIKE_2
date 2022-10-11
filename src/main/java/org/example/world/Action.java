package org.example.world;

import org.example.Ability;
import org.example.Combat;
import org.example.Item;

public interface Action {
    void move(Direction direction);
    void attack(Combat combatTarget, Ability ability);
    void pickup(Item... items);
}
