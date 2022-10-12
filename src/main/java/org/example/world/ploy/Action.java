package org.example.world.ploy;

import org.example.Ability;
import org.example.Combat;
import org.example.Item;
import org.example.world.Direction;

public interface Action {
    void move(Direction direction);
    void attack(Combat combatTarget, Ability ability);
    void pickup(Item... items);
}
