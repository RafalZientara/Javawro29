package pl.com.sda.rafal.zientara.apps.homework.zbior2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}