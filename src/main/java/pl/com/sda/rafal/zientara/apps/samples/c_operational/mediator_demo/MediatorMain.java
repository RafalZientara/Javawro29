package pl.com.sda.rafal.zientara.apps.samples.c_operational.mediator_demo;

public class MediatorMain {

    public static void main(String[] args) {
        ChatMediator wiezaKontrolna = new ChatMediatorImpl();
        User user1 = new UserImpl(wiezaKontrolna, "Samolot Pierwszy");
        User user2 = new UserImpl(wiezaKontrolna, "Samolot Drugi");
        User user3 = new UserImpl(wiezaKontrolna, "Samolot Trzeci");
        User user4 = new UserImpl(wiezaKontrolna, "Samolot Czwarty");
        wiezaKontrolna.addUser(user1);
        wiezaKontrolna.addUser(user2);
        wiezaKontrolna.addUser(user3);
        wiezaKontrolna.addUser(user4);

        user1.send("Podchodzę do lądowania!");
    }
}
