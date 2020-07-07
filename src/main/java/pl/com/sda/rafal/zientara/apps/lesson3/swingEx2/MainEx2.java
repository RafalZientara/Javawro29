package pl.com.sda.rafal.zientara.apps.lesson3.swingEx2;

public class MainEx2 {
    public static void main(String[] args) {
        FirstWindow firstWindow = new FirstWindow();
        SecondWindow secondWindow = new SecondWindow();
        firstWindow.setListener(secondWindow);
    }
}
