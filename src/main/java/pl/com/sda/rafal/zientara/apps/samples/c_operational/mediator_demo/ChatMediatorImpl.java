package pl.com.sda.rafal.zientara.apps.samples.c_operational.mediator_demo;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

    private List<User> users;

    public ChatMediatorImpl(){
        this.users=new ArrayList<>();
    }

    @Override
    public void addUser(User user){
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for(User u : this.users){
            //wiadomości nie powinien otrzymać użytkownik, który ją wysłał
            if(u != user){
                u.receive(msg);
            }
        }
    }

}
