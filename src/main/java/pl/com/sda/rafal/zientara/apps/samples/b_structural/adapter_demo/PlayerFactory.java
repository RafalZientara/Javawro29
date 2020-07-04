package pl.com.sda.rafal.zientara.apps.samples.b_structural.adapter_demo;

public class PlayerFactory {

    public static AdvancedMediaPlayer get(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            return new VlcPlayer();

        } else if (audioType.equalsIgnoreCase("mp4")) {
            return new Mp4Player();
        }
        return null;
    }
}
