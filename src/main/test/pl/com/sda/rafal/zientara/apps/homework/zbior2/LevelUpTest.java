package pl.com.sda.rafal.zientara.apps.homework.zbior2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class LevelUpTest {

    private LevelUp levelUp;

    @BeforeEach
    public void setup() {
        levelUp = new LevelUp();
    }

    @Test
    public void countLevelExperience() {
        assertEquals(10, levelUp.countExperienceRequired(1));
        assertEquals(30, levelUp.countExperienceRequired(2));
        assertEquals(70, levelUp.countExperienceRequired(3));
        assertEquals(150, levelUp.countExperienceRequired(4));
    }

    @Test
    public void playerStartsWith0Level() {
        assertEquals(0, levelUp.getLevel());
        assertEquals(0, levelUp.getExperience());
    }

    @Test
    public void playerGetsFirstLevel() {
        levelUp.addExp(10);

        assertEquals(1, levelUp.getLevel());
        assertEquals(10, levelUp.getExperience());
    }

    @Test
    public void playerGetsFirstLevelWithSomeExtraExperience() {
        levelUp.addExp(29);

        assertEquals(1, levelUp.getLevel());
        assertEquals(29, levelUp.getExperience());
    }

    @Test
    public void playerGetsTwoLevelsAtOnce() {
        levelUp.addExp(30);

        assertEquals(2, levelUp.getLevel());
        assertEquals(30, levelUp.getExperience());
    }

    @Test
    public void playerGetsThreeLevelsAtOnce() {
        levelUp.addExp(72);

        assertEquals(3, levelUp.getLevel());
        assertEquals(72, levelUp.getExperience());
    }

    @Test
    public void playerGetsLevelTwoAfterTwoAddedPoints() {
        levelUp.addExp(10);
        levelUp.addExp(20);

        assertEquals(2, levelUp.getLevel());
        assertEquals(30, levelUp.getExperience());
    }

    @Test
    public void playerGetsLevelTwoAfterThreeAddedPoints() {
        levelUp.addExp(10);
        levelUp.addExp(10);
        levelUp.addExp(10);

        assertEquals(2, levelUp.getLevel());
        assertEquals(30, levelUp.getExperience());
    }

    @Test
    public void listenerCanHearLevelUp() {
        LevelUp.LevelListener listener = Mockito.mock(LevelUp.LevelListener.class);
        levelUp.setListener(listener);

        levelUp.addExp(10);

        Mockito.verify(listener, Mockito.times(1)).onLevelUp(1);
    }

    @Test
    public void listenerCanHearEveryLevelUp() {
        LevelUp.LevelListener listener = Mockito.mock(LevelUp.LevelListener.class);
        levelUp.setListener(listener);

        levelUp.addExp(150);

        Mockito.verify(listener, Mockito.times(4)).onLevelUp(anyLong());
    }

    @Test
    public void checkMaxLevelWithLong() {
        long level = 59;
        long exp = 0;
        long required = 10;
        for (long i = 0; i < level; i++) {
            exp += required;
            required *= 2;
            System.out.println("Level:" + (i + 1));
            System.out.println("exp:" + exp);
            assertTrue(exp > 0);
            //na level 60 przekręca się licznik long'a
        }
    }

    @Test
    public void checkMaxLevelWithBigDecimal() {
        //z big decimal można szaleć do woli
        BigDecimal TWO = new BigDecimal(2);
        long level = 10000;
        BigDecimal exp = new BigDecimal(0);
        BigDecimal required = new BigDecimal(10);
        for (long i = 0; i < level; i++) {
            exp = exp.add(required);
//            exp += required;
            required = required.multiply(TWO);
//            required *= 2;
            System.out.println("Level:" + (i + 1));
            System.out.println("exp:" + exp);
            assertTrue(exp.compareTo(BigDecimal.ZERO) > 0);
        }
    }
}