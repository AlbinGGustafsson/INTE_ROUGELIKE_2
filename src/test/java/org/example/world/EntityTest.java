package org.example.world;

import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {

    @Test
    void updateRoom_Room_Contains_Entity_Updates_Room(){
        Entity player = new Player("name", Race.HUMAN);
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);

        room.getTile(new Position(1,1)).setEntity(player);
        //gör man setEntity() genom room så uppdateras rummet hos Player.

        player.updateRoom(room);
        assertEquals(room, player.getRoom());
    }
    @Test
    void updateRoom_Room_Not_Contains_Entity_Not_Updates_Room(){
        Entity player = new Player("name", Race.HUMAN);
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        player.updateRoom(room);
        assertNotEquals(room, player.getRoom());
    }

    @Test
    void updatePosition_Position_Has_Entity_updates_Position(){
        Entity player = new Player("name", Race.HUMAN);
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);

        room.getTile(new Position(1,1)).setEntity(player);
        //Inte uppdaterad innan
        assertNotEquals(new Position(1,1), player.getPosition());

        player.updatePosition(new Position(1,1), room);

        //Uppdaterad efter
        assertEquals(new Position(1,1), player.getPosition());
    }
    @Test
    void updatePosition_Position_Not_Has_Entity_Not_updates_Position(){
        Entity player = new Player("name", Race.HUMAN);
        TestableRoomCreator tcr = new TestableRoomCreator();
        Room room = tcr.loadRoom(0);
        room.setEntity(player, new Position(2,2));
        player.updatePosition(new Position(1,1), room);
        assertNotEquals(new Position(1,1), player.getPosition());
    }

}
