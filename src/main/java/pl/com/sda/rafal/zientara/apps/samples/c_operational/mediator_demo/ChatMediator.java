package pl.com.sda.rafal.zientara.apps.samples.c_operational.mediator_demo;

public interface ChatMediator {

    void sendMessage(String msg, User user);

    void addUser(User user);
}
