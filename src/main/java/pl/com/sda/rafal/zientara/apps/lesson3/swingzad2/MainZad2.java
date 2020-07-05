package pl.com.sda.rafal.zientara.apps.lesson3.swingzad2;

public class MainZad2 {

    public static void main(String[] args) {
        FirstWindow firstWindow = new FirstWindow();
        SecondWindow secondWindow = new SecondWindow();
        firstWindow.setListener(secondWindow);
    }
}
