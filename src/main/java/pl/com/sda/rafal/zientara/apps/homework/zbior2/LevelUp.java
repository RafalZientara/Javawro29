package pl.com.sda.rafal.zientara.apps.homework.zbior2;

public class LevelUp {

    private int level;
    private int experience;
    private LevelListener listener;

    public int countExperienceRequired(int level) {
        int exp = 0;
        int required = 10;
        for (int i = 0; i < level; i++) {
            exp += required;
            required *= 2;
        }
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void addExp(int newExperience) {
        experience += newExperience;
        checkLevel();
    }

    private void checkLevel() {
        while (countExperienceRequired(level + 1) <= experience) {
            level++;
            if (listener != null) {
                listener.onLevelUp(level);
            }
        }
    }

    public void setListener(LevelListener listener) {
        this.listener = listener;
    }

    public interface LevelListener {
        void onLevelUp(int level);
    }
}

