package pl.com.sda.rafal.zientara.apps.samples.c_operational.mediator_demo;

public abstract class User {
    ChatMediator mediator;
    String name;

    User(ChatMediator med, String name){
        this.mediator=med;
        this.name=name;
    }

    public abstract void send(String msg);

    public abstract void receive(String msg);
}
