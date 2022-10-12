package org.example.world.ploy;

import org.example.world.Direction;
import org.example.world.Entity;

public class EntityMover {

    private Entity entity;

    public EntityMover(Entity entity) {
        this.entity = entity;
    }

    public void move(Direction direction){
        entity.getRoom().moveEntity(entity, entity.getPosition().getPos(direction));
    }
}
