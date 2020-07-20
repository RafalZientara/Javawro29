package pl.com.sda.rafal.zientara.apps.homework.zbior2;

public class LevelUp {

    //todo dla chętnych. Przerobić na BigDecimal
    private long level;
    private long experience;
    private LevelListener listener;

    public long countExperienceRequired(long level) {
        long exp = 0;
        long required = 10;
        for (long i = 0; i < level; i++) {
            exp += required;
            required *= 2;
        }
        return exp;
    }

    public long getLevel() {
        return level;
    }

    public long getExperience() {
        return experience;
    }

    public void addExp(long newExperience) {
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
        void onLevelUp(long level);
    }
}

