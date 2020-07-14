package pl.com.sda.rafal.zientara.apps.lesson3.levelup;

import java.util.Scanner;

public class Experience {
    private int experienceSum;
    private int level;
    LevelUpListener levelUpListener = new LevelUpListener();

    public Experience() {
        this.experienceSum = 0;
        this.level = 0;
    }

    public int getLevel() {
        return level;
    }

    public int getExperienceSum() {
        return experienceSum;
    }

    public void setExperienceSum(int experienceSum) {
        this.experienceSum = experienceSum;
    }

    public void addExperience(int addedExperience) {
        this.experienceSum += addedExperience;
    }

    public void levelCount() {
        int currentLevel = 0, currentExp = 0;
        for(int i = 1; currentExp <= this.experienceSum; i = i*2){
            currentExp += i * 10;
            if (currentExp <= this.experienceSum){
                currentLevel++;
                notifyListener(currentLevel);
            }
        }
        this.level = currentLevel;
    }

    private void notifyListener(int currentLevel) {
        levelUpListener.onLevelUp(currentLevel);
    }

    public void userIncreaseExperience(){
        Scanner scanner = new Scanner(System.in);
        int expGiven;

        System.out.println("Podaj liczbę punktów doświadczenia (wartość <= 0 kończy program): ");
        expGiven = scanner.nextInt();

        while (expGiven > 0){
            addExperience(expGiven);
            System.out.println("Podaj liczbę punktów doświadczenia (wartość <= 0 kończy program): ");
            expGiven = scanner.nextInt();
        }

        System.out.println("Masz: " + this.experienceSum +
                " punktów doświadczenia, co daje Ci poziom: " + this.level);

    }

    public interface LevelListener{
        void onLevelUp(int level);
    }
}
