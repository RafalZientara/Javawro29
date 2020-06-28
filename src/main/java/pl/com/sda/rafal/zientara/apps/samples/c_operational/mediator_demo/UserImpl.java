package pl.com.sda.rafal.zientara.apps.samples.c_operational.mediator_demo;

public class UserImpl extends User {

    UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg){
        System.out.println(this.name+": WYSYŁAM WIADOMOŚĆ= "+msg);
        mediator.sendMessage(msg, this);
    }
    @Override
    public void receive(String msg) {
        System.out.println(this.name+": ODBIERAM WIADOMOŚĆ: "+msg);
    }

}
