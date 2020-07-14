package pl.com.sda.rafal.zientara.apps.lesson3.levelup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExperienceTest {

    @Test
    public void addExperiencePoints(){
        Experience experience = new Experience();
        int startExperience = 10, expectedExperience = 35, addedExperience = 25;

        experience.setExperienceSum(startExperience);
        experience.addExperience(addedExperience);

        assertEquals(expectedExperience, experience.getExperienceSum());
    }

    @Test
    public void gainLevelOne(){
        Experience experience = new Experience();
        int levelExperienceRequired = 10, expectedLevel = 1;

        experience.addExperience(levelExperienceRequired);
        experience.levelCount();

        assertEquals(expectedLevel, experience.getLevel());
    }

    @Test
    public void gainLevelTwo(){
        Experience experience = new Experience();
        int levelExperienceRequired = 30, expectedLevel = 2;

        experience.addExperience(levelExperienceRequired);
        experience.levelCount();

        assertEquals(expectedLevel, experience.getLevel());
    }

    @Test
    public void gainLevelThree(){
        Experience experience = new Experience();
        int levelExperienceRequired = 70, expectedLevel = 3;

        experience.addExperience(levelExperienceRequired);
        experience.levelCount();

        assertEquals(expectedLevel, experience.getLevel());
    }

    @Test
    public void gainLevelFour(){
        Experience experience = new Experience();
        int levelExperienceRequired = 150, expectedLevel = 4;

        experience.addExperience(levelExperienceRequired);
        experience.levelCount();

        assertEquals(expectedLevel, experience.getLevel());
    }

    @Test
    public void gainLevelFourDifferentExp(){
        Experience experience = new Experience();
        int levelExperienceRequired = 250, expectedLevel = 4;

        experience.addExperience(levelExperienceRequired);
        experience.levelCount();

        assertEquals(expectedLevel, experience.getLevel());
    }

}