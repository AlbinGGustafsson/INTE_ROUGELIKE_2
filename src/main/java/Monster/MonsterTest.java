package Monster;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MonsterTest {

    private static final int CORRECT_LEVEL_VALUE = 10;

    @Test
    void calculateHealthReturnsCorrectValue(){
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        int expected = 420;
        assertEquals(expected, troll.getHealth());
    }

    @Test
    void AttackDamageIsGivenCorrectValue(){
        Troll troll = new Troll(CORRECT_LEVEL_VALUE);
        int expected = 50;
        assertEquals(expected, troll.attackDamage());
    }
}
