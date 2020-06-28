package pl.com.sda.rafal.zientara.apps.samples.a_creational.factory_demo.abstractFactory;

public class LuxusCarFactory implements AbstractFactory {

    @Override
    public String engine() {
        return "super silnik atomowy";
    }

    @Override
    public String color() {
        return "czerwony";
    }

}
