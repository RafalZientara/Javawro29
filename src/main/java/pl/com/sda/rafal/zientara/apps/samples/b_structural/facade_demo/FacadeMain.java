package pl.com.sda.rafal.zientara.apps.samples.b_structural.facade_demo;

public class FacadeMain {

    public static void main(String[] args) {
        //Uzywamy fasady zeby ukryc przed klientem istnienie wielu skomplikowanych systemow
        Kelner kelner = new Kelner();
        kelner.przyniesPiwo();
        kelner.podajMenuVege();
        kelner.podajMenuMiesne();
        kelner.rachunekProsze();
    }
}
