package pl.com.sda.rafal.zientara.apps.samples.b_structural.adapter_demo;

public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Odtwarzam vlc o nazwie: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //nic nie rób, to player plików VLC!
    }
}
