package pl.com.sda.rafal.zientara.apps.samples.a_creational.factory_demo;

public class FactorySecondMain {

    public Car getCar(String type, String engine, String bodyType, String brand) {

        if ("Family".equalsIgnoreCase(type)) return new FamilyVehicle(engine, bodyType, brand);
        else if ("Utility".equalsIgnoreCase(type)) return new UtilityVehicle(engine, bodyType, brand);

        return null;
    }

    public static void main(String[] args) {
        FactorySecondMain factory = new FactorySecondMain();
        Car car = factory.getCar("familyyyyy", "1500 koni", "sedan", "mercedes");
    }
}