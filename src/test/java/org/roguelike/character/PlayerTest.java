package org.roguelike.character;

import org.roguelike.gear.CannotEquipException;
import org.roguelike.gear.Chestpiece;
import org.roguelike.gear.Helmet;
import org.roguelike.characters.Race;
import org.roguelike.characters.Player;
import org.roguelike.world.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player PLAYER;

    @BeforeEach
    public void setUp(){
        PLAYER = new Player("name", Race.DWARF, 5);
    }

    @Test
    void equippingUnequibleGearDoesntWork() {
        Helmet h = new Helmet("", "", 12, 123);
        assertThrows(CannotEquipException.class, ()-> PLAYER.equip(h));

    }

    @Test
    public void addingItemsToInventoryWorks(){
        Helmet h = new Helmet("", "", 12, 123);
        PLAYER.addToInventory(h);
        assertTrue(PLAYER.getInventory().contains(h));
    }
    @Test
    public void equippingWorks(){
        Helmet h = new Helmet("", "", 1, 123);
        PLAYER.addToInventory(h);
        PLAYER.equip(h);
        assertTrue(PLAYER.getEquipment().contains(h));
    }
    @Test
    public void unequippingWorks(){
        Helmet h = new Helmet("", "", 1, 123);
        PLAYER.addToInventory(h);
        PLAYER.equip(h);
        PLAYER.unequip(h);
        assertFalse(PLAYER.getEquipment().contains(h));
    }

    @Test
    public void rightDmgIsTaken(){
        Chestpiece c = new Chestpiece("", "", 4, 400);
        Helmet h = new Helmet("", "", 1, 267);
        PLAYER.addToInventory(c);
        PLAYER.addToInventory(h);
        PLAYER.equip(c);
        PLAYER.equip(h);
        int hp = PLAYER.getHp();
        PLAYER.takeDmg(1000);
        assertEquals(hp - 200, PLAYER.getHp());
    }

    @Test
    public void lvlOneZeroEquipPlayerHasRightBaseDmg(){
        Player p = new Player("name", Race.DWARF);
        assertEquals(0, p.getBaseDmg().getMagicDmg());
        assertEquals(11, p.getBaseDmg().getPhysDmg());
    }

    @Test
    void emptyStringNameThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Player("", Race.HUMAN, 10);
        });
    }

    @Test
    void nameIsNullThrowsException(){
        assertThrows(NullPointerException.class, () ->{
            new Player(null, Race.HUMAN, 10);
        });
    }

    @Test
    void spaceInStringThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Player("Albin Ganding", Race.HUMAN, 10);
        });
    }

    @Test
    void tooLongNameThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Player("hdhdhdhdhdhdhdhhdhdhdhdhdhdhdhdh", Race.HUMAN, 10);
        });
    }

    @Test
    void StringWithOneCharacterCreatesPlayer() {
        Player player = new Player("E", Race.HUMAN, 10);
        String expected = "E";
        assertEquals(expected, player.getName());
    }

    @Test
    void whiteSpaceBeginningOfStringThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Player(" Jorvel", Race.HUMAN, 10);
        });
    }

    @Test
    void whiteSpaceEndOfStringThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->{
            new Player("Jorvel ", Race.HUMAN, 10);
        });
    }


    @Test
    void raceIsNullThrowsException(){
        assertThrows(NullPointerException.class, () ->{
            new Player("name", null, 10);
        });
    }

    @Test
    void toString_Returns_Correct_String(){

        String exppectedString = PrintFormatConstants.BOLD + PrintFormatConstants.PURPLE + "P" + PrintFormatConstants.RESET;
        assertEquals(exppectedString, PLAYER.toString());

    }

    @Test
    void Player_Changing_Room_To_The_Right(){
        World world = new World(new TestableRoomCreator());
        world.getRoom(0).setEntity(PLAYER, new Position(4,2));
        PLAYER.move(Direction.RIGHT);

        Room newRoom = world.getRoom(1);
        Position newPlayerPosition = newRoom.getDoor(Direction.LEFT).getPosition().getPos(Direction.RIGHT);
        assertEquals(PLAYER, newRoom.getTile(newPlayerPosition).getEntity());
        assertFalse(world.getRoom(0).contains(PLAYER));
    }

    @Test
    void Player_Changing_Room_To_The_Left(){
        World world = new World(new TestableRoomCreator());
        world.addRoom();
        world.getRoom(1).setEntity(PLAYER, new Position(1,2));
        PLAYER.move(Direction.LEFT);

        Room newRoom = world.getRoom(0);
        Position newPlayerPosition = newRoom.getDoor(Direction.RIGHT).getPosition().getPos(Direction.LEFT);
        assertEquals(PLAYER, newRoom.getTile(newPlayerPosition).getEntity());
        assertFalse(world.getRoom(1).contains(PLAYER));
    }

}