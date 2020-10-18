package pl.com.sda.rafal.zientara.apps.lesson3_Swing;


public class Main {
    public static void main(String[] args) {

        FirstWindow firstWindow = new FirstWindow();
        SecondWindow secondWindow = new SecondWindow();
        firstWindow.setListener(secondWindow);  //drugie okno nasłuchuje pierwsze poprzez setListener(ziomek który słucha)

    }
}
