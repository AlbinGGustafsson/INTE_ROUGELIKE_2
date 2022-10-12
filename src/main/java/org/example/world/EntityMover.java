package org.example.world;

public class EntityMover {

    private Entity entity;

    public EntityMover(Entity entity) {
        this.entity = entity;
    }

    public void move(Direction direction){
        entity.getRoom().moveEntity(entity, entity.getPosition().getPos(direction));
    }

}
