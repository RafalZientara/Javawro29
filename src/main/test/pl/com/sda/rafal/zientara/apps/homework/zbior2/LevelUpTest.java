package pl.com.sda.rafal.zientara.apps.homework.zbior2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

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

        Mockito.verify(listener, Mockito.times(4)).onLevelUp(anyInt());
    }


}