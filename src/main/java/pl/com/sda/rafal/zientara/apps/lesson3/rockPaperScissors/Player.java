package pl.com.sda.rafal.zientara.apps.lesson3.rockPaperScissors;

public abstract class Player  {
    private String nick;

    public Player(String nick) {
        this.nick = nick;
    }

    public String getNick(){
        return nick;
    }
}
