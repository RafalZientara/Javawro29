package pl.com.sda.rafal.zientara.apps.lesson3.levelup;

public class LevelUpListener implements Experience.LevelListener {
    @Override
    public void onLevelUp(int level) {
        System.out.println("LEVEL UP! " + level + " GRATZ!");
    }
}
