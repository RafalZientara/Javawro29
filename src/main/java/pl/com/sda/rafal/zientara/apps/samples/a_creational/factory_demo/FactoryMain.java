package pl.com.sda.rafal.zientara.apps.samples.a_creational.factory_demo;

public class FactoryMain {

    public static Car getCar(String type, String engine, String bodyType, String brand) {

        if ("Family".equalsIgnoreCase(type)) return new FamilyVehicle(engine, bodyType, brand);
        else if ("Utility".equalsIgnoreCase(type)) return new UtilityVehicle(engine, bodyType, brand);

        return null;
    }

    public static void main(String[] args) {

        Car utility = getCar("utility", "1.2 gas", "sedan", "toyota");
        Car family = getCar("family", "1.4 TDI", "minivan", "mercedes");

        System.out.println(utility.toString());
        System.out.println(family.toString());
    }
}