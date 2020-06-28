package pl.com.sda.rafal.zientara.apps.samples.b_structural.adapter_demo;

public class AdapterMain {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "Sławomir-Miłość w Zakopanem.mp3");
        audioPlayer.play("vlc", "Deadpool 2.vlc");
        audioPlayer.play("mp4", "Frozen.mp4");
        audioPlayer.play("avi", "Urodziny Krzycha.avi");
    }
}
