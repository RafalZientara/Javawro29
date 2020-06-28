package pl.com.sda.rafal.zientara.apps.samples.a_creational.factory_demo.abstractFactory;

public class CheapCarFactory implements AbstractFactory {

    @Override
    public String engine() {
        return "chomiki w kołowrotku";
    }//ctrl + alt + s

    @Override
    public String color() {
        return "rdzawy";
    }

}
