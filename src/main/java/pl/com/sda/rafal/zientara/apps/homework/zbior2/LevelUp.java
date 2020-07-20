package pl.com.sda.rafal.zientara.apps.homework.zbior2;

public class LevelUp {

    public int countExperienceRequired(int level) {
        int exp = 0;
        int required = 10;
        for (int i = 0; i < level; i++) {
            exp += required;
            required *= 2;
        }
        return exp;
    }

}
