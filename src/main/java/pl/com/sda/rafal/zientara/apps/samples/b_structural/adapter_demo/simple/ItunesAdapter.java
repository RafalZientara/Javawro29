package pl.com.sda.rafal.zientara.apps.samples.b_structural.adapter_demo.simple;

public class ItunesAdapter implements SongAdapter {

    private ItunesSong song;

    public ItunesAdapter(ItunesSong song) {
        this.song = song;
    }

    @Override
    public String getSongName() {
        return song.trackName;
    }

    @Override
    public String getArtist() {
        return song.dude;
    }

    @Override
    public int getYear() {
        return song.releaseDate.getYear();
    }
}
